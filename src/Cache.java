public class Cache {

    private class Video {
        int freq, size;
        Video next;
        Video (int freq, int size) {
            this.freq = freq;
            this.size = size;
        }
    }

    private int id, capacity;
    private Video head;
    private final int TRESHHOLD = capacity / 2;

    public Cache (int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public void addVideo (int freq, int size) {


        if ((size + capacity) > capacity) {
            System.out.println();
            return;
        }

        if (head == null) {

            // head = new Video();
        }
    }

    public int getId () {
        return id;
    }

    public int getCapacity () {
        return capacity;
    }

    public String toString () {
        return String.format("Cache #%d:\n -> Capaity: %dmb", id, capacity);
    }

}
