import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
public class binarySearch {
    public static void main(String[] args){
        // classic binary search
        int[] testArray ={ 1, 2, 3, 5, 7, 8, 9};
        int[] nullArray = {};
        int target = 5;
        int result = 0;
//        result = classicalBinarySearch(testArray, target);
//        System.out.print(result);


        // binary search in Matrix
        //        int[][] twoD_array = new int[10][20];
        int[][] twoD_array = {
                                {1, 2, 3, 5},
                                {7, 8, 10, 11},
                                {13, 15, 19, 20}
                            };
        // show matrix
//        for(int i = 0; i < 3; i++){
//            for(int j = 0; j < 4; j++){
//                System.out.print(twoD_array[i][j] + " ");
//            }
//            System.out.println();
//        }
        int target_matrix = 20;
        int[] res = {};
//        res = matrixBinarySearch(twoD_array, target_matrix);
//        System.out.print("position:");
//        for (int i = 0; i < res.length; i++){
//            System.out.print(res[i] + " ");
//        }


        //show the closest element of the target
        int[] closestElementArray = {1, 2, 3, 8, 9};
        target = 11;
//        result = closestElement(closestElementArray, target);
//        System.out.println("Closest element is: " + result);


        //show the first target
        int[] firstTargetArray = {1, 1, 2, 3, 5};
        target = 5;
//        result = firstTarget(firstTargetArray, target);
//        System.out.println("first target occur position: " + result);


        //show the last target
        int[] lastTargetArray = {1, 5, 5, 5, 7};
        target = 5;
//        result = lastTarget(lastTargetArray, target);
//        System.out.println("last target occur position: " + result);


        //show the k closest in array
        int[] kClosestArray = {1, 2, 3, 6, 8, 9};
        int k = 3;
        target = 4;
//        res = kClosest(kClosestArray, target, k);
//        System.out.print("k closest element: ");
//        if(res.length == 0 || res == null){
//            System.out.print("None");
//        }
//        for(int i = 0; i < res.length; i++){
//            System.out.print(res[i] + " ");
//        }


        // show the smallest element that is larger than target
        int[] smallestElementArray = {1,2,2,2,2,2,7,7,7,7,8,8,9};
        target = 7;
//        result = smallestElement(smallestElementArray, target);
//        System.out.println("The smallest element is: " + result);


        // k-th smallest in two sorted array
        int[] A = {2,5,7,10,13};
        int[] B = {1,3,4,13,20};
        int leftA = 0, leftB = 0;
        k = 5;
//        result = kthSmallestInTwoSortedArrays(A, leftA, B, leftB, k);
//        System.out.println(k+"th smallest in two sorted array : " + result);


        // Search In Unknown Sized Sorted Array
        Map<Integer, Integer> dic = new HashMap<Integer,Integer >();
        for(int i = 0; i <= 100; i++) {
            dic.put(i,i);
        }
        target = 10;
//        result = searchInUnknownSizedSortedArray(dic, target);
//        System.out.println("The position of the target is: " + result);






    }

    // time complexity = O(log(N))
    // space complexity = O(1)
    private static int classicalBinarySearch(int[] array, int target){
        // check array
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (array[middle] > target){
                right = middle - 1;
            }
            else if (array[middle] < target){
                left = middle + 1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }

    // time complexity = O(log(N))
    // space complexity = O(1)
    public static int[] matrixBinarySearch(int[][] matrix, int target){

        if(matrix.length == 0 || matrix[0].length == 0 ){
            int[] res = {-1, -1};
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;  // left
        int j = row * col - 1; // right
        while (i <= j) {
            int middle = i + (j - i) / 2;
            int r = middle / col; // row position
            int c = middle % col; // column position
            if (matrix[r][c] == target){
                int[] res = {r + 1, c + 1};
                return res;
            }
            else if (matrix[r][c] > target){
                j = middle - 1;
            }
            else {
                i = middle + 1;
            }
        }
        int[] arr = {-1, -1};
        return arr;
    }

    //time complexity O(log(N))
    //space complexity O(1)
    public static int closestElement(int[] array, int target){
        if(array.length == 0 || array == null){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return array[mid];
            }
            else if(array[mid] < target){
                left = mid;
            }
            else {
                right = mid;
            }
        }

        if(Math.abs((target - array[right])) > Math.abs(target - array[left])){
            return array[left];
        }
        else{
            return array[right];
        }
    }


    //time complexity: O(log(N))
    //space complexity: O(1)
    public static int firstTarget(int[] array, int target){
        if(array.length == 0 || array == null){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(target == array[mid]){
                right = mid;
            }
            else if (array[mid] > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        if(array[left] == target){
            return left;
        }
        if(array[right] == target){
            return right;
        }
        return -1;

    }


    //time complexity: O(log(N))
    //space complexity: O(1)
    public static int lastTarget(int[] array, int target){
        if(array.length == 0 || array == null){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(target == array[mid]){
                left = mid;
            }
            else if (array[mid] > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        if(array[right] == target){
            return right;
        }
        if(array[left] == target){
            return left;
        }
        return -1;
    }


    //time complexity: O(log(N))
    //space complexity: O(1)
    public static int[] kClosest(int[] array, int target, int k){
        if(array.length < k){
            return new int[0];
        }
        if(array.length == 0 || array == null){
            return new int[0];
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                left = mid;
            }
            else if (array[mid] < target){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if(Math.abs(target - array[left])<=Math.abs(target - array[right])){
            right = left + 1;
        } else {
            left = right - 1;
        }
        int[] res= new int[k];
        for(int i = 0; i < k; i++){
            if(right >= array.length || left >= 0 && Math.abs(target - array[left])<=Math.abs(target - array[right])){
                res[i] = array[left];
                left--;
            } else {
                res[i] = array[right];
                right++;
            }
        }
        return res;
    }

    //time complexity: O(log(N))
    //space complexity: O(1)
    public static int smallestElement(int[] array, int target){
        if (array[array.length - 1] <= target){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1){
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                left = mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[left] > target) {
            return array[left];
        }
        if (array[right] > target) {
            return  array[right];
        }
        return -1;
    }


    public static int kthSmallestInTwoSortedArrays(int[] a, int aleft, int[] b, int bleft, int k) {
        // base case
        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }
        if (bleft >= b.length) {
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }

        //since index starts from left
        //the k/2 - the element should be left + k/2 - 1
        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        // if a.size too small, then remove elements from b first.
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

        if (aval <= bval) {
            return kthSmallestInTwoSortedArrays(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return kthSmallestInTwoSortedArrays(a, aleft, b, bmid + 1, k - k / 2);
        }
    }


    //time complexity: O(log(N))
    //space complexity: O(1)
    public static int searchInUnknownSizedSortedArray(Map<Integer, Integer> dic, int target){
        if (dic == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        while (dic.get(right) != null && dic.get(right) < target) {
            left = right;
            right = 2 * right;
        }
        return binarySearchUnknownArray(dic, target, left, right);
    }

    public static int binarySearchUnknownArray(Map<Integer,Integer> dic, int target, int left, int right) {
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (dic.get(mid) == null || dic.get(mid) > target){
                right = mid - 1;
            }
            else if (dic.get(mid) < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }


}