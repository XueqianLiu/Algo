import java.util.HashMap;
public class twoSum_1 {
    public static void main(String[] args){
        int [] array = {2,7,11,15};
        int target = 9;
        int [] res = twoSum(array, target);
        int [] followupRes = followUp(array, target);




    }
    // Brute Force
    // time complexity: O(N^2)
    // space complexity: O(1)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i != j && nums[i] + nums[j] == target) {
                    int []res = {i, j};
                    return res;
                }
            }
        }
        return new int[0];
    }


    // follow up: Can you come up with an algorithm that is less than O(n2) time complexity?
    // time complexity: O(N)
    // We traverse the list containing n elements exactly twice. Since the hash table reduces the lookup time to O(1)
    // the overall time complexity is O(n)O(n)O(n).

    // space complexity: O(N)
    // The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.
    public static int[] followUp(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++ ) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        return null;
    }
    // I use two iterations. In the first one, I add each element as a key and its index as a value to
    // a hash table. In the second one, I check each element's complement (target - num[i] ) exists in
    // the hash table. If it does exist, we can return current element's index and complement index.

}
