class LFUCache {

    private int capacity;
    private int minFreq;
    private Map<Integer, Integer> valueMap; 
    private Map<Integer, Integer> freqMap;  
    private Map<Integer, LinkedHashSet<Integer>> listMap; 

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
        listMap = new HashMap<>();
    }

    public int get(int key) {
        if (!valueMap.containsKey(key))
            return -1;

        int freq = freqMap.get(key);
        freqMap.put(key, freq + 1);

        listMap.get(freq).remove(key);
        if (freq == minFreq && listMap.get(freq).isEmpty())
            minFreq++;

        listMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);

        return valueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            get(key); 
            return;
        }

        if (valueMap.size() == capacity) {
            int evict = listMap.get(minFreq).iterator().next();
            listMap.get(minFreq).remove(evict);
            valueMap.remove(evict);
            freqMap.remove(evict);
        }

        valueMap.put(key, value);
        freqMap.put(key, 1);
        minFreq = 1;
        listMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */