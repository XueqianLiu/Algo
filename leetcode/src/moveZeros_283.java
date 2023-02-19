public class moveZeros_283 {
    public static void main(String[] args){
        int[] nums = {0, 1, 3, 0, 12, 0};

        moveZero(nums);
        System.out.println("Move Zeros results: ");
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    // time complexity: O(n)
    // space complexity: O(1)
    public static void moveZero(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) {
            return;
        }
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0) {
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
