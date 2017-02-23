class Endpoint{
    private int id = 0;
    private int latency = 0;
    private int cache_servers[];

    public Endpoint(int id, int latency, int caches){
        this.id = id;
        this.latency = latency;
        this.cache_servers = new int[caches];
    }

    public void add_cache(int id, int latency){
        this.cache_servers[id] = latency;
    }

    public int[] get_caches(){
        return cache_servers;
    }
}
