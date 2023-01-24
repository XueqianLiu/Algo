public class search2DMatrix_74 {
    public static void main(String[] args){
        int[][] twoD_array = {
                {1, 2, 3, 5},
                {7, 8, 10, 11},
                {13, 15, 19, 20}
        };
        // show matrix
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(twoD_array[i][j] + " ");
            }
            System.out.println();
        }
        int target_matrix = 20;
        boolean res = true;
        res = searchMatrix(twoD_array, target_matrix);
        System.out.println("The target is in the matrix or not: " + res);
//        System.out.print("position:");
//        for (int i = 0; i < res.length; i++){
//            System.out.print(res[i] + " ");
//        }
    }


    // time complexity O(log(mn))
    // space complexity O(1)
    public static boolean searchMatrix(int[][] matrix, int target){
        int r_num = matrix.length;
        int c_num = matrix[0].length;
        int left = 0;
        int right = r_num * c_num - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / c_num;
            int col = mid % c_num;
            if(matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }
}

// why do you use left + (right - left)?
// left + right might cause overflow issue, if both left and right is very large
//
// (1) The algo is a just standard binary search
// (2) we can initialise left and right indexs, left = 0 and right = m x n - 1.
// (3) we run a loop in this matrix
//     we pick up the index in the middle of the virtual array as a pivot index
//     mid = left + (right - left) / 2
//     the index corresponds to
//     row = mid is divided by col nums
//     and col = taking reminders of mid divided by col num
//     Compare mid and target to identify in which part one has to look for target.


