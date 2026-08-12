class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num ,0)+1);
        }
        List <Integer> List = new ArrayList<>(map.keySet());
        Collections.sort(List , (a,b) -> map.get(b)-map.get(a));
        return List.subList(0,k).stream().mapToInt(Integer::intValue).toArray();

    }
}
