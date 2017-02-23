import java.util.LinkedList;

public class Cache {

    private class Video {
        public int id, freq, size;

        Video (int id, int freq, int size) {
            this.id   = id;
            this.freq = freq;
            this.size = size;
        }
    }

    private int id, capacity, bufferSize;
    LinkedList<Video> buffer;

    public Cache (int id, int capacity) {
        this.id = id;
        this.capacity = capacity;

        buffer = new LinkedList<>();
    }

    public void addVideo (int id, int freq, int size) {

        for (Video v : buffer) {
            if (v.id == id) {
                Video temp = buffer.remove(buffer.indexOf(v));
                bufferSize -= temp.size;

                addToBuffer(id, freq, size);
                return;
            }
        }

        if (size > capacity) {
            return;
        } else if ((bufferSize + size) > capacity) {
            // Memory buffer too large
            Video temp = buffer.removeFirst();
            bufferSize -= temp.size;
        }

        addToBuffer(id, freq, size);
    }

    public void addToBuffer (int id, int freq, int size) {
        bufferSize += size;
        buffer.add(new Video(id, freq, size));
    }

    public boolean hasVideo (int id) {

        for (Video v : buffer) {
            if (v.id == id) {
                return true;
            }
        }

        return false;
    }

    public void printVideo () {
        for (Video v : buffer) {
            System.out.print(v.id + " --> ");
        }
        System.out.println();
    }

    public int getId () {
        return id;
    }

    public int getCapacity () {
        return capacity;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public String toString () {
        return String.format("Cache #%d:\n" +
                                "  -> Buffer:   %dmb\n" +
                                "  -> Capacity: %dmb"
                                , id, bufferSize, capacity);
    }

}
