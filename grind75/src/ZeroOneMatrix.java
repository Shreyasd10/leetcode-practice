import java.util.*;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < rows ;i++){
            for(int j = 0; j < cols ;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if( newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && mat[newRow][newCol] == -1){
                    mat[newRow][newCol] = mat[row][col] + 1;
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        ZeroOneMatrix solution = new ZeroOneMatrix();

        // Test case 1
        int[][] matrix1 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println("Test Case 1:");
        System.out.println("Input:");
        printMatrix(matrix1);
        int[][] result1 = solution.updateMatrix(matrix1);
        System.out.println("Output:");
        printMatrix(result1);

        // Test case 2
        int[][] matrix2 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("\nTest Case 2:");
        System.out.println("Input:");
        printMatrix(matrix2);
        int[][] result2 = solution.updateMatrix(matrix2);
        System.out.println("Output:");
        printMatrix(result2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
