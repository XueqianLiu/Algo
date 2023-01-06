import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class findKClosestElements_658 {
    public static void main(String[] args) {
        int[] arr =  {1, 1, 1, 10, 10, 10};
        int k = 1;
        int target = 9;
        List<Integer> res = new ArrayList<Integer>();
        res = findClosestElements(arr, k, target);
        res = solution(arr, k, target);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x){
                left = mid;
            } else {
                right = mid;
            }
        }

        if(Math.abs(x - arr[left])<= Math.abs(x - arr[right])){
            right = left + 1;
        } else {
            left = right - 1;
        }
//        System.out.println(left);
//        System.out.println(right);

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            if( right >= arr.length || left >=0  && Math.abs(x - arr[left])<= Math.abs(x - arr[right])) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        Collections.sort(res);
        return res;
    }


    public static List<Integer> solution(int[] arr, int k, int x) {
        // Initalize two variables to perform binary search with left and right
        int left = 0;
        int right = arr.length - k;
        // perform a binary search
        while (left < right) {

            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
//        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
// time complexity: O(log(N-K))
//
// space complexity: O(1)
// we use a constant amount of space for our pointers, and space used for the
// output does not count towards the space complexity.

//1. Initalize two variables to perform binary search with, left = 0 and right = len(arr) - k.
//2. Perform a binary search. At each operation, calculate mid = (left + right) / 2
// and compare the two elements located at arr[mid] and arr[mid + k]. If the
// element at arr[mid] is closer to x, then move the right pointer. If the
// element at arr[mid + k] is closer to x, then move the left pointer. Remember,
// the smaller element always wins when there is a tie.

// 3. At the end of the binary search, we have located the leftmost index for the
// final answer. Return the subarray starting at this index that contains k elements.



