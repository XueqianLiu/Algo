import java.util.Arrays;
public class SortAnArray_912 {
    public static void main(String[] args){
        int[] nums = {5, 2, 3, 1};

        int[] res = sortArray(nums);

        System.out.print("output: ");
        for (int i = 0; i < nums.length; i++){
            System.out.print(res[i] + " ");
        }

    }
    // time complexity: O(n * log n) + O(n) = O(n * log n)
    // The time complexity of the sortArray function is O(nlogn) due to the use of the
    // merge sort algorithm. The merge sort algorithm divides the input array into two halves
    // and recursively sorts each half, resulting in a time complexity of O(nlogn) for the divide step.
    // The merge step has a time complexity of O(n) as it merges two sorted arrays into
    // a single sorted array. The overall time complexity is O(nlogn).

    // space complexity:  O(n)
    // The space complexity of the sortArray function is O(n)
    // because it creates a copy of the input array for each recursive call
    // and the maximum number of such calls is log(n).
    // Additionally, the merge function creates a new array to store the sorted result,
    // which also takes O(n) space.
    // Thus, the overall space complexity of the sortArray function is O(n).
    public static int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length;
        // base case
        if (nums.length  == 1) {
            return nums;
        }
        // divide the input array in half on each recursive call
        int mid = left + (right - left) / 2;
        int[] ResLeft=sortArray(Arrays.copyOfRange(nums,0,mid));
        int[] ResRight=sortArray(Arrays.copyOfRange(nums,mid,nums.length));

        int[] result  = merge(ResLeft, ResRight);
        return result;
    }


    public static int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length){
            if (left[leftIndex] <= right[rightIndex]){
                res[resIndex] = left[leftIndex];
                leftIndex++;
            } else{
                res[resIndex] = right[rightIndex];
                rightIndex++;

            }
            resIndex++;
        }

        while(leftIndex < left.length){
            res[resIndex] = left[leftIndex];
            leftIndex++;
            resIndex++;
        }
        while(rightIndex<right.length){
            res[resIndex] = right[rightIndex];
            rightIndex++;
            resIndex++;
        }
        return res;
    }
}
