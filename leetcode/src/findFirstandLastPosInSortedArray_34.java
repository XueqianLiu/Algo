public class findFirstandLastPosInSortedArray_34 {
    public static void main(String[] args){
        int[] nums = {2,2};
        int target = 2;
        int[] res = searchRange(nums, target);
        System.out.println("The first position of element is: " + res[0]);
        System.out.println("The last position of element is: " + res[1]);
    }


    // time complexity: log n + log n = O(log(N))
    // space complexity: O(1)
    public static int[] searchRange(int[] nums, int target){
        if (nums.length == 0 || nums == null) {
            return new int[] {-1,-1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid;
            } else if (nums[mid]>target){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        int res0 = 0;
        if (nums[left] == target){
            res0 = left;
        }
        if (nums[right] == target && nums[left] != target){
            res0 = right;
        }
        left = 0;
        right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target){
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target){
            return new int[] {res0, right};
        }
        if (nums[left] == target){
            return new int[] {res0, left};
        }
        return new int[] {-1,-1};
    }
}

// (1) we can use two binary search to solve this problem.
//     One binary search is for finding the first position and the other binary search is for
//     finding the last position of the target.
// (2) we can use 2 variabes to keep tarck of the subarray that we are scanning.
//     let's call them left and right. initially, left is set to 0 and right is set to the last
//     index of the array.
// (3) we iterate when left is smaller than right - 1;
// (4) at each step, we calculate the middle element  mid  = left + (right - left) / 2.
//     we can use the value of the middle element to decide which half of the array we need
//     to search.
//     We are trying to find the first occurrence of the element. if nums[mid] = target, then
//     right = mid. if nums[mid] > target, right = mid, else left = mid; we need to continue to
//     check to left.
//     then we try to find the last occurrence of the element. if nums[mid] = target, then
//     left = mid. ....   we need to countnue to check to right.
// (5) we can return [-1, -1] at the end of our function which indicates that target was
//     not found in the array.
