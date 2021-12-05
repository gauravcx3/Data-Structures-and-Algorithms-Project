//Gaurav Chakraverty (22750993)

import java.util.Arrays;

/**
* Class MyProject implements the provided Project interface (Project.java).
* 
* @author Gaurav Chakraverty (22750993). 
*/
public class MyProject implements Project{
	//zero-argument constructor
	public MyProject() {};
	
	
	/**
     * Executes a floodFill and returns the count of pixels affected by the floodFill operation.
     * 
     * @param image The input image (which in a 2D int array).
     * @param row The row index of the pixel from where we start the floodFill.
     * @param col The column index of the pixel from where we start the floodFill.
     * @return The count of pixels affected by this operation.
     */
	public int floodFillCount(int[][] image, int row, int col) {
		//store the row and column size of the given image
		int rowsize = image.length;
		int colsize = image[0].length;
		//we store our target color (color of pixel from where we begin floodFill).
		int targetColor = image[row][col];
		//we will later make a copy of our original image.
		int[][] tempImage = new int[rowsize][colsize];
		//creating a variable called black just so program is easier to understand
		int black = 0;
		//we need a counter no know how many pixels were affected by floodFill
		int counter = 0;
		
		//if color of start pixel is already black then we have nothing to floodFill.
		if(targetColor==black) {
			return 0;
		}
		
		//we copy the original image and store in tempImage
		for (int r = 0; r < rowsize; r++) {
			for (int c = 0; c < colsize; c++) {
				tempImage[r][c] = image[r][c];
			}
		}
		
		//every time we discover a pixel that we need to process we will add it to 
		//the below tempStack so we can get back to it later.
		int[][] tempStack=new int[rowsize*colsize][2];
		//stackTop keeps track of if we still have things we have inside our tempStack
		//and is only considered empty when is back to -1.
		int stackTop=-1;
		//we increment stackTop because we are about to add the start pixel inside
		stackTop++;
		
		//we store the row and column index of the start pixel so we can process it 
		//inside the while loop after this
		tempStack[stackTop][0] = row;
		tempStack[stackTop][1] = col;
		
		//this is where we will process each pixel once by one from our tempStack
		//keeps looping as long as tempStack is not empty or stackTop is -1.
		while (stackTop>-1) {
			//we store the row and column index of the topmost item in our stackTop
			int rowx = tempStack[stackTop][0];
			int colx = tempStack[stackTop][1];
			
			//we need to mark the pixel we are processing as black
			tempImage[rowx][colx] = black;
			//need to keep count each time we mark a pixel black
			counter = counter+1;
			
			//we decrement stackTop which then points to the next item in the tempStack
			//or -1 if empty.
			stackTop--;
			
			//we are looking at the pixel above the current pixel
			//if we are not at the upper boundary of the image and 
			//the pixel above is of the targetColor
			if ((rowx-1>=0)&&(tempImage[rowx-1][colx]==targetColor)) {
				//we increment stackTop and add the index of the pixel above to tempStack
				//so we can process it later.
				stackTop++;
				tempStack[stackTop][0] = rowx-1;
				tempStack[stackTop][1] = colx;
			}
			//we are looking at the pixel below the current pixel
			//if we are not at the lower boundary of the image and 
			//the pixel below is of the targetColor
			if ((rowx+1<rowsize)&&(tempImage[rowx+1][colx]==targetColor)) {
				//we increment stackTop and add the index of the pixel below to tempStack
				//so we can process it later.
				stackTop++;
				tempStack[stackTop][0] = rowx+1;
				tempStack[stackTop][1] = colx;
			}
			//we are looking at the pixel on the left of the current pixel
			//if we are not at the left boundary of the image and 
			//the pixel on the left is of the targetColor
			if ((colx-1>=0)&&(tempImage[rowx][colx-1]==targetColor)) {
				//we increment stackTop and add the index of the pixel on the left to tempStack
				//so we can process it later.
				stackTop++;
				tempStack[stackTop][0] = rowx;
				tempStack[stackTop][1] = colx-1;
			}
			//we are looking at the pixel on the right of the current pixel
			//if we are not at the right boundary of the image and 
			//the pixel on the right is of the targetColor
			if ((colx+1<colsize)&&(tempImage[rowx][colx+1]==targetColor)) {
				//we increment stackTop and add the index of the pixel on the right to tempStack
				//so we can process it later.
				stackTop++;
				tempStack[stackTop][0] = rowx;
				tempStack[stackTop][1] = colx+1;
			}
		}
		//we return the count of pixels we changed to black
		return counter;
	}
	
	
	/**
     * Finds and returns the brightness of the brightest exactly k*k square that appears in the given image.
     * 
     * @param image The input image (which in a 2D int array).
     * @param k the dimension of the squares to consider.
     * @return The total brightness of the brightest square found.
     */
	public int brightestSquare(int[][] image, int k) {
		//store the row and column size of the given image
		int rowsize = image.length;
		int colsize = image[0].length;
		//summed-area table based on the input image
		int[][] sumImage = new int[rowsize][colsize];
		int tempSum = 0;
		int secondSum = 0;
		int kTopLeft = 0;
		int kTopRight = 0;
		int kBotLeft = 0;
		int kBotRight = 0;
		int maxBright = 0;
		int kBright = 0;
		//go through each row
		for (int row = 0; row < rowsize; row++) {
			tempSum = 0;
			//go through each column 
			for (int col = 0; col < colsize; col++) {
				//keep summing values for each pixel
				tempSum = tempSum + image[row][col];
				//store the current sum value inside sumImage
				sumImage[row][col] = tempSum;
				//we now need to consider the pixels above
				if (row>0) {
					//we need to add the value of the pixel above as well
					secondSum = tempSum + sumImage[row-1][col];
					//store the current sum value inside sumImage
					sumImage[row][col] = secondSum;
					secondSum = 0;
				}
			}
		}
		
		//we start from the pixel on the bottom right of Square
		for (int rowx = (k-1); rowx < rowsize; rowx++) {
			for (int colx = (k-1); colx < colsize; colx++) {
				//pixel on the bottom right of square
				kBotRight = sumImage[rowx][colx];
				//if we have column on the left of square
				if((colx > k-1)) {
					//pixel outside bottom left corner of square
					kBotLeft = sumImage[rowx][colx-k];
				}
				//if we have row above the square
				if ((rowx > k-1)) {
					//pixel outside the top right of square
					kTopRight = sumImage[rowx-k][colx];
				}
				//if we have row above and column on the left of square
				if ((rowx > k-1)&&(colx > k-1)) {
					//pixel outside the top left of the square
					kTopLeft = sumImage[rowx-k][colx-k];
				}
				//formula to calculate the total brightness of the square
				kBright = kBotRight - kBotLeft - kTopRight + kTopLeft;
				//compare the total brightness of each square
				if (kBright > maxBright) {
					//total brightness of the brightest square
					maxBright = kBright;
				}
				
				kBotRight=kBotLeft=kTopRight=kTopLeft=0;
				
			}
		}
		return maxBright;
	}

	
	/**
     * Finds and returns the maximum brightness that MUST be encountered when drawing a path between 2 pixels.
     *
     * @param ur The row index of the start pixel for the path
     * @param uc The column index of the start pixel for the path
     * @param vr The row index of the end pixel for the path
     * @param vc The column index of the end pixel for the path
     * @return The minimum brightness of the path from (ur, uc) to (vr, vc)
     */
	public int darkestPath(int[][] image, int ur, int uc, int vr, int vc) {
		int infy = 1000; //anything more than 255 will do
		int brightestInDarkest=0;
		
		int rows = image.length;
		int cols = image[0].length;
		
		//boolean array that shows if node is covered
		boolean[][] covered = new boolean[rows][cols];
		
		//stores and updates the minimum path dist to a pixel from start pixel
		int[][] keyValues = new int[rows][cols];
		
		//Initialize with all 0 at first
		int[][] distances = new int[rows][cols];
		
		//fill all values as false at first
		for (boolean[] row: covered)
		    Arrays.fill(row, false);
		
		//fill all values as infy at first
		for (int[] row: keyValues)
		    Arrays.fill(row, infy);
		
		//fill all values as 0 at first
		for (int[] row: distances)
		    Arrays.fill(row, 0);
		
		//dist to startPixel is 0.
		keyValues[ur][uc]=0;
		 
		distances[ur][uc]=image[ur][uc];
		
		//while the destination pixel has not been reached
		while(covered[vr][vc]==false){
			
			//find pixel with least key value
			int minKeyVal=infy; 
			int minKeyIdx_x=-1;
			int minKeyIdx_y=-1;
			//go through each row
			for(int y=0;y<rows;y++){
				//go through each column
				for(int x=0;x<cols;x++){
					//if pixel has not been covered
					if(covered[y][x]==false){
						//if minKeyVal is more than keyValues
						if(minKeyVal>keyValues[y][x]){
							//update minKeyVal with the lower value
							minKeyVal = keyValues[y][x];
							//store coordinates of pixel with least key value
							minKeyIdx_x = x;
							minKeyIdx_y = y;
						}
					}
				}
			}
			//mark the pixel as covered
			if((minKeyIdx_x>=0) && (minKeyIdx_y>=0)){
				covered[minKeyIdx_y][minKeyIdx_x]=true;
			}
			
			//check north,south,left and right pixels
			
			//check if anything on the left
			if(((minKeyIdx_x-1)>=0) && ((minKeyIdx_x-1)<cols)){
				//get edge value for connection to left pixel
				//edge value is greater of the 2 pixels
				int edgeVal = getEdge(image, minKeyIdx_x, minKeyIdx_y, (minKeyIdx_x-1), minKeyIdx_y);
				//get the greater value between edgeVal and distances
				int currentPath = maxOf(edgeVal,distances[minKeyIdx_y][minKeyIdx_x]);
				//if currentPath is less than keyValues and left pixel is not covered
				if((currentPath<keyValues[minKeyIdx_y][minKeyIdx_x-1]) 
						&& (!covered[minKeyIdx_y][minKeyIdx_x-1])){
					//update distances and keyValues to equal currentPath
					distances[minKeyIdx_y][minKeyIdx_x-1] = keyValues[minKeyIdx_y][minKeyIdx_x-1] = currentPath;
				}
			}
			
			//check west if exists//check if anything on the right
			if(((minKeyIdx_x+1)>=0) && ((minKeyIdx_x+1)<cols)){
				//get edge value for connection to right pixel
				//edge value is greater of the 2 pixels
				int edgeVal = getEdge(image, minKeyIdx_x, minKeyIdx_y, (minKeyIdx_x+1), minKeyIdx_y);
				//get the greater value between edgeVal and distances		
				int currentPath = maxOf(edgeVal,distances[minKeyIdx_y][minKeyIdx_x]);
				//if currentPath is less than keyValues and right pixel is not covered		
				if((currentPath<keyValues[minKeyIdx_y][minKeyIdx_x+1]) 
						&& (!covered[minKeyIdx_y][minKeyIdx_x+1])){
					distances[minKeyIdx_y][minKeyIdx_x+1] = keyValues[minKeyIdx_y][minKeyIdx_x+1] = currentPath;
				}
			}
			
			//check north if exists
			if(((minKeyIdx_y-1)>=0) && ((minKeyIdx_y-1)<rows)){
				int edgeVal = getEdge(image, minKeyIdx_x, minKeyIdx_y, minKeyIdx_x, (minKeyIdx_y-1));
						
				int currentPath = maxOf(edgeVal,distances[minKeyIdx_y][minKeyIdx_x]);
						
				if( (currentPath<keyValues[minKeyIdx_y-1][minKeyIdx_x]) 
						&& (!covered[minKeyIdx_y-1][minKeyIdx_x])){
					distances[minKeyIdx_y-1][minKeyIdx_x] = keyValues[minKeyIdx_y-1][minKeyIdx_x] = currentPath;
				}
			}
			
			//check south if exists
			if(((minKeyIdx_y+1)>=0) && ((minKeyIdx_y+1)<rows)){
				int edgeVal = getEdge(image, minKeyIdx_x, minKeyIdx_y, minKeyIdx_x, (minKeyIdx_y+1));
								
				int currentPath = maxOf(edgeVal,distances[minKeyIdx_y][minKeyIdx_x]);
								
				if( (currentPath<keyValues[minKeyIdx_y+1][minKeyIdx_x]) 
						&& (!covered[minKeyIdx_y+1][minKeyIdx_x])){
					distances[minKeyIdx_y+1][minKeyIdx_x] = keyValues[minKeyIdx_y+1][minKeyIdx_x] = currentPath;
				}
			}
			
		}
		brightestInDarkest = distances[vr][vc];
		
		return brightestInDarkest;
	}
	
	//the edge between two pixels is the just the greater of the 2 pixels
	private int getEdge(int[][] img, int x1, int y1, int x2, int y2){
		int edgeVal=0;
		if(img[y1][x1]>img[y2][x2])
			edgeVal = img[y1][x1];
		else
			edgeVal = img[y2][x2];
		
		return edgeVal;
	}
	
	//compares and returns the max between 2 values
	private int maxOf(int a, int b){
		if(a>b)
			return a;
		else
			return b;
	}

	
	/**
     * Calculates and returns the results of a list of queries on the given image.
     * 
     * @param image The input image (which in a 2D int array).
     * @param queries The list of query row segments
     * @return The list of brightest pixels for each query row segment.
     */
	public int[] brightestPixelsInRowSegments(int[][] image, int[][] queries) {
		int rowsize = image.length;
		int colsize = image[0].length;
		int pixels = rowsize*colsize;
		int queryCount = queries.length;
		int[] output = new int[queryCount];
		
		if ((queryCount*colsize)<((pixels*colsize) + queryCount)) {
			for (int queryNum = 0; queryNum < queryCount; queryNum++) {
				output[queryNum] = brightMax(image, queries[queryNum][0],queries[queryNum][1],queries[queryNum][2]);
			}
		}
		else {
			//stores every possible answer to any query
			int[][] solMatrix = new int[pixels][colsize];
			//loop through the image rows
			for (int solRow = 0; solRow < rowsize; solRow++) {
				//loop through the image columns
				for (int solCol = 0; solCol < colsize; solCol++) {
					//go through each item in the column. Start at solCol and go till the end.
					for (int solColVal = solCol; solColVal < colsize; solColVal++) {
						//the rowIndex in solMatrix where we will store current value
						int index = (solRow*colsize) + solCol;
						//Store the brightest pixel value for each query
						solMatrix[index][solColVal] = brightMax(image, solRow,solCol, solColVal+1);
					}
				}
			}
			//go through each query
			for(int queryNum = 0; queryNum < queryCount; queryNum++) { 
				//the rowIndex in solMatrix where we have to look at
				int serial = queries[queryNum][1] + ((queries[queryNum][0])*colsize);
				//extract the brightest pixel value for each query and store in output
				output[queryNum] = solMatrix[serial][(queries[queryNum][2])-1];
			}
		}
		
		return output;
	}
	
	//calculates and returns the brightest pixel value in a given row segment
	private int brightMax(int[][] image, int row,int colStart, int colEnd ) {
		int maxBright = 0;
		int currentPixel = 0;
		//loop only goes from colStart to colEnd-1
		for (int col = colStart; col < colEnd; col++) {
			currentPixel = image[row][col];
			//compares and stores the pixel with max brightness
			if (currentPixel > maxBright) {
				maxBright = currentPixel;
			}
		}
		//returns max brightness
		return maxBright;
	}
	
}