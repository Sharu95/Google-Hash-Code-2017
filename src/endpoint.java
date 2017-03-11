class Endpoint{
    private int id = 0;
    private int latency = 0;
    private int cache_servers[];
    public boolean caches = false;

    public Endpoint(int id, int latency, int caches){
        this.id = id;
        this.latency = latency;
        this.cache_servers = new int[caches];

        for(int i=0;i<cache_servers.length;i++){
            cache_servers[i] = -1;
        }

    }

    public void add_cache(int id, int latency){
        caches = true;
        this.cache_servers[id] = latency;
    }

    public int[] get_caches(){
        return this.cache_servers;
    }

    public int get_latency(){
        return this.latency;
    }

    public int get_id(){
        return this.id;
    }
}
