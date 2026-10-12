class LRUCache {
LinkedHashMap<Integer, Integer> map;
int capacity;
    public LRUCache(int capacity) {
     map = new LinkedHashMap<>(capacity, 0.75f, true);
       this.capacity = capacity;
    }
    
    public int get(int key) {
       if(map.containsKey(key)){
       return map.get(key);
       }else{
        return -1;
       }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
             map.put(key, value);
        }else{
            if(map.size()==capacity){
                int del = map.keySet().iterator().next();
                map.remove(del);
            }
        map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */