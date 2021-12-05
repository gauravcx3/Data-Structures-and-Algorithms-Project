# Data-Structures-and-Algorithms-Project

---
### CITS2200 - Data Structures and Algorithms (2020/Sem-1)
#### The University of Western Australia

---
#### Problem Specification
You must implement the following four functions, and provide a report on your implementations. Each function is worth a different number of marks for a total of 20 marks. Details for what the mark breakdowns mean are provided below.

All questions work with a greyscale image specified as a 2D int array. The array is indexed first by row, then by column. Every row in the array will be the same length. Every element in the array will be non-negative and no greater than 255. A value of 0 represents a black pixel, and a value of 255 represents white, with shades of grey in between.

Time complexity specifications use R for number of rows, C for number of columns, and P = R\*C for number of pixels.

---
#### public int floodFillCount(int\[][] image, int row, int col)
Compute the number of pixels that change when performing a black flood-fill from the pixel at ( row , col ) in the given image. A flood-fill operation changes the selected pixel and all contiguous pixels of the same colour to the specified colour. A pixel is considered part of a contiguous region of the same colour if it is exactly one pixel up/down/left/right of another pixel in the region.

---
#### public int brightestSquare(int\[][] image, int k)
Compute the total brightness of the brightest exactly k\*k square that appears in the given image. The total brightness of a square is defined as the sum of its pixel values. You may assume that k is positive, no greater than R or C , and no greater than 2048.

---



