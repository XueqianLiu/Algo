import java.util.Arrays;

public class Recursion_I {

    public static void main(String[] args){

        // initialise an unsorted array
        int[] array = {4, 9, 1, 2, 10, 0};


        int n = array.length;
        // selection sort
//        selectionSort(array, n);
//        System.out.print("Selection sort: ");
//        for (int i = 0; i < n; i++){
//            System.out.print(array[i] + " ");
//        }


        // merge sort
        int left = 0, right = array.length;
//        int[] res_arr = mergeSort(array, left, right-1);
//        System.out.print("");
//        for (int i = 0; i < res_arr.length; i++){
//            System.out.print(res_arr[i] + " ");
//        }


        // power calculate
        int a = 3, b = 3;
//        long res = power(a, b);
//        System.out.print("a to the power of b: "+ res);


        // given a String 'A1B2C3D4', how to convert it ro String "ABCD1234"
        String input = "A1B2C3D4";
//        String output = sortString(input);
//        System.out.println("The string is: " + output);


        // quick sort
//        quickSort(array, 0, array.length - 1);
//        System.out.println("Quick Sort: ");
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i] + " ");
//        }

        // rainbow sort
        int[] rainbowArray = {1, 0, 0, 1, 1,-1, 0, -1};
        rainbowSort( rainbowArray );
        System.out.println("Rainbow Sort: ");
        for(int i = 0; i < rainbowArray.length; i++){
            System.out.print(rainbowArray[i] + " ");
        }

    }

    // time complexity O(n)
    // The algorithm only iterates through the array once and performs a constant amount of work at each iteration.
    // space comlexity O(1)
    // The algorithm sorts the input array in place,
    // without requiring any additional memory for data structures such as temporary arrays or stacks.
    public static void rainbowSort(int[] array){
        if (array == null || array.length <= 1) {
            return;
        }
        // left side -1
        // right side 1
        // between -1 and 1, is 0
        // between 0 and 1 is to be discovered
        int neg = 0;
        int one = array.length - 1;
        int zero = 0;
        while (zero <= one) {
            if (array[zero] < 0){
                swap(array, neg++, zero++);
            } else if (array[zero] == 0) {
                zero++;
            } else if (array[zero] > 0) {
                swap(array, zero ,one--);
            }
        }
    }

    // time complexity O(n log n)  worst case O(n^2)
    // space complexity O(log n) worst case  O(n)
    public static void quickSort(int[] array, int left, int right){
        if (left >= right) {
            return;
        }
            // define a pivot and use the pivot to partition the array
        int indexOfPivot = partition(array, left, right);
        quickSort(array, left, indexOfPivot - 1);
        quickSort(array, indexOfPivot + 1, right);
    }

    public static int partition(int[] array, int left, int right){
        int pivotIndex = pivot(left, right);
        int pivot = array[pivotIndex];
        // 把pivot换到最后一位！
        swap(array, pivotIndex, right);
        int leftbound = left;
        int rightbound = right - 1;
        while(leftbound <= rightbound) {
            if(array[leftbound] < pivot) {
                leftbound++;
            } else if (array[rightbound] >= pivot) {
                rightbound--;
            } else {
                swap(array, leftbound++, rightbound--);
            }
        }
        swap(array, leftbound,right);
        return leftbound;
    }

    public static int pivot(int left,int right){
        int pivot = left + (int)(Math.random() * (right - left + 1));
        return pivot;
    }

    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    // time complexity O(n (log n))
    // space complexity O(n)
    //This is because the algorithm is using a StringBuilder object to construct the sorted string,
    // which requires O(n) space to store the characters in the input string,
    // and temporary space on the call stack for the recursive calls to sortString.
    // The temporary space on the call stack is equal to the maximum depth of the recursion tree,
    // which is log n for a divide-and-conquer algorithm like merge sort.
    // However, since the space required by the StringBuilder object dominates the space required by the call stack,
    // the overall space complexity is O(n).
    public static String sortString(String input) {
        if (input.length() <= 1){
            return input;
        }

        int mid = input.length() / 2;
        String left = input.substring(0, mid);
        String right = input.substring(mid);

        left = sortString(left);
        right = sortString(right);


        return mergeStr(left, right);
    }

    public static String mergeStr(String left, String right) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < left.length() && j < right.length()){
            // check char is letter or digit
            if (Character.isLetter(left.charAt(i))){
                sb.append(left.charAt(i));
                i++;
            }
            else if (Character.isLetter(right.charAt(j))){
                sb.append(right.charAt(j));
                j++;
            }else {
                while(i < left.length()){
                    sb.append(left.charAt(i));
                    i++;
                }
                while(j < right.length()){
                    sb.append(right.charAt(j));
                    j++;
                }
            }
        }
        while(i < left.length()){
            sb.append(left.charAt(i));
            i++;
        }
        while(j < right.length()){
            sb.append(right.charAt(j));
            j++;
        }
        return sb.toString();
    }

    // time complexity: O(log(b))
    // time complexity: O(log(b))
    public static long power(int a, int b){
        if (b == 0){
            return 1;
        }
        long midRes = power(a, b / 2);

        if (b % 2 == 1) {
            return midRes * midRes * a;
        } else {
            return midRes * midRes;
        }
    }

    // MergeSort
    // time complexity: O(N log(N))
    // the algorithm divides the input array in half on each recursive call,
    // and then takes linear time (O(n)) to merge the two halves back together.
    // The merge method has a time complexity of O(n)

    // space complexity: O (N)
    //The space complexity is O(n), as the algorithm creates a new array to
    // store the merged result on each call, and the maximum depth of recursion is log(n)
    public static int[] mergeSort(int[] array, int left, int right){
        // base case
        if (left == right) {
            return new int[] {array[left]};
        }

        //recursive rule is below
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        return merge(leftResult, rightResult);
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
            } else {
                res[resIndex] = right[rightIndex];
                rightIndex++;
            }
            resIndex++;
        }
        while (leftIndex < left.length) {
            res[resIndex] = left[leftIndex];
            leftIndex++;
            resIndex++;
        }
        while (rightIndex < right.length) {
            res[resIndex] = right[rightIndex];
            rightIndex++;
            resIndex++;
        }
        return res;
    }



    // time complexity: O(N^2)
    // space complexity: O(1)
    // selection sort an array a[] with size n.
    public static void selectionSort(int[] array, int n){
        for (int i = 0; i < n - 1; i++) {
            int globalMin = i;
            for (int j = i + 1; j < n; j++) {
                if(array[j] < array[globalMin]){
                    globalMin = j;
                }
            }

            int temp = array[i];
            array[i] = array[globalMin];
            array[globalMin] = temp;
        }
    }
}
