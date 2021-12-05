import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
      int[][] image = new int[][] {
    	  { 0, 0, 1, 1, 1 },
    	  { 0, 1, 1, 2, 2 },
    	  { 2, 3, 3, 0, 2 },
    	  { 2, 2, 2, 2, 2 }
      };
      
      int[][] image2 = new int[][] {
    	  { 0, 1, 2, 3, 4 },
    	  { 5, 6, 7, 8, 9 },
    	  { 10, 11, 12, 13, 14 },
    	  { 15, 16, 17, 18, 19 }
      };
      
      int[][] image3 = new int[][] {
    	  { 31, 2, 4, 33, 5, 36 },
    	  { 12, 26, 9, 10, 29, 25 },
    	  { 13, 17, 21, 22, 20, 18 },
    	  { 24, 23, 15, 16, 14, 19 },
    	  { 30, 8, 28, 27, 11, 7 },
    	  { 1, 35, 34, 3, 32, 6 }
      };
      
      int[][] image4 = new int[][] {
          { 0, 0, 85, 85, 85 },
          { 0, 85, 255, 170, 170 },
          { 170, 255, 255, 0, 170 },
          { 170, 170, 170, 170, 170 }
          };
      
      int row = 3;
      int col = 4;
      System.out.println("Rows in image: "+image.length);
      System.out.println("Columns in image: "+image[1].length);
      System.out.println("Pixel value at row "+row+" and column "+col+" = "+image[row][col]);
      
      MyProject x = new MyProject();
      
      int y = x.floodFillCount(image, row, col);
      System.out.println("floodFillCount: "+y);
      
      int z = x.brightestSquare(image, 1);
      System.out.println("brightestSquare: "+z);
      
      int[][] queries = new int[][] {
    	  { 1, 0, 3 },
    	  { 1, 1, 5 },
    	  { 2, 2, 5 }
      };
      
      int[][] queries2 = new int[][] {
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
    	  { 1, 0, 3 },
		  { 1, 1, 5 },
		  { 2, 2, 5 },
      };
      
      System.out.println("Number of queries: "+queries.length);
      int[] a = x.brightestPixelsInRowSegments(image4, queries);
      System.out.println("brightestPixelsInRowSegments: "+Arrays.toString(a));

      int c = x.darkestPath(image4, 1, 1, 1, 3);
      System.out.println("darkestPath: "+c);
       
	}
}
