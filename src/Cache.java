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

    private int id, capacity, memoryUsed;

    LinkedList<Video> cacheList;

    public Cache (int id, int capacity) {
        this.id = id;
        this.capacity = capacity;

        cacheList = new LinkedList<>();
    }

    public void addVideo (int id, int freq, int size) {

        if ((memoryUsed + size) < capacity) {
            memoryUsed += size;
        } else {
            cacheList.removeFirst();
        }

        cacheList.add(new Video(id, freq, size));
    }

    public void printVideo() {
        for (Video v : cacheList) {
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

    public String toString () {
        return String.format("Cache #%d:\n" +
                                "  -> Memory:   %dmb\n" +
                                "  -> Capacity: %dmb\n"
                                , id, memoryUsed, capacity);
    }

}
