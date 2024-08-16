public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }

    public static void fill(int[][] image, int sr,int sc,int oldColor,int newColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = newColor;
        fill(image,sr - 1,sc,oldColor,newColor);
        fill(image,sr + 1,sc,oldColor,newColor);
        fill(image,sr,sc - 1,oldColor,newColor);
        fill(image,sr,sc + 1,oldColor,newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;  // Starting row
        int sc = 1;  // Starting column
        int color = 2;  // New color

        // Apply flood fill
        int[][] result = floodFill(image, sr, sc, color);

        // Print the result
        System.out.println("Updated image after flood fill:");
        for(int[] row : result) {
            for(int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
