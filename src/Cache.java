public class Cache {
    private int id, capacity;

    public Cache (int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
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
