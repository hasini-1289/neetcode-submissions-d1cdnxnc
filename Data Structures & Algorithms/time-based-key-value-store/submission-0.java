class TimeMap {

    HashMap<String, ArrayList<Integer>> timeMap;
    HashMap<String, ArrayList<String>> valueMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        valueMap.putIfAbsent(key, new ArrayList<>());

        timeMap.get(key).add(timestamp);
        valueMap.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        ArrayList<Integer> times = timeMap.get(key);
        ArrayList<String> values = valueMap.get(key);

        int left = 0, right = times.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = (left + right) / 2;

            if (times.get(mid) <= timestamp) {
                result = values.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
