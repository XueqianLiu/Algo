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





    }

    // time complexity = O(log(N))
    // space complexity = O(N)
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
    // space complexity = O(N)
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
    //space complexity O(N)
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
    //space complexity: O(N)
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
    //space complexity: O(N)
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


    //time complexity:
    //space complexity:
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
}