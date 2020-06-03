class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        uniquePermutations(result, list, nums, visited);
        
        return new ArrayList(result);
    }
    
    public void uniquePermutations(Set<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new LinkedList(list));
        }
        else {
            for(int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                uniquePermutations(result, list, nums, visited);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}