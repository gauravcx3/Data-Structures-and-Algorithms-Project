# Data-Structures-and-Algorithms-Project

---
### CITS2200 - Data Structures and Algorithms (2020/Sem-1)
#### The University of Western Australia

---
#### Problem Specification
You must implement the following four functions, and provide a report on your implementations. Each function is worth a different number of marks for a total of 20 marks. Details for what the mark breakdowns mean are provided below.

All questions work with a greyscale image specified as a 2D `int` array. The array is indexed first by row, then by column. Every row in the array will be the same length. Every element in the array will be non-negative and no greater than 255. A value of 0 represents a black pixel, and a value of 255 represents white, with shades of grey in between.

Time complexity specifications use `R` for number of rows, `C` for number of columns, and `P = R\*C` for number of pixels.

---
#### `public int floodFillCount(int\[]\[] image, int row, int col)`
Compute the number of pixels that change when performing a black flood-fill from the pixel at ( `row` , `col` ) in the given image. A flood-fill operation changes the selected pixel and all contiguous pixels of the same colour to the specified colour. A pixel is considered part of a contiguous region of the same colour if it is exactly one pixel up/down/left/right of another pixel in the region.

---
#### `public int brightestSquare(int\[]\[] image, int k)`
Compute the total brightness of the brightest exactly `k\*k` square that appears in the given image. The total brightness of a square is defined as the sum of its pixel values. You may assume that `k` is positive, no greater than `R` or `C` , and no greater than 2048.

---
#### `public int darkestPath(int\[]\[] image, int ur, int uc, int vr, int vc)`
Compute the maximum brightness that MUST be encountered when drawing a path from the pixel at ( `ur` , `uc` ) to the pixel at ( `vr` , `vc` ). The path must start at ( `ur` , `uc` ) and end at ( `vr` , `vc` ), and may only move one pixel up/down/left/right at a time in between. The brightness of a path is considered to be the value of the brightest pixel that the path ever touches. This includes the start and end pixels of the path.

---
#### `public int\[] brightestPixelsInRowSegments(int\[]\[] image, int\[]\[] queries)`
Compute the results of a list of queries on the given image. Each query will be a three-element int array `{r, l, u}` defining a row segment. You may assume `l < u`. A row segment is a set of pixels ( `r` , `c` ) such that `r` is as defined, `l <= c` , and `c < u`. For each query, find the value of the brightest pixel in the specified row segment. Return the query results in the same order as the queries are given.

---
#### Testing
Your code must compile correctly when compiled with:
~~~
javac Project.java MyProject.java SampleProjectUnitTest.java
~~~
After compiling, you can test your code using the provided sample unit tests with:
~~~
java SampleProjectUnitTest
~~~

---
NOTE: THIS PROJECT WAS PART OF THE DATA STRUCTURES AND ALGORITHMS UNIT (CITS2200) AT THE UNIVERSITY OF WESTERN AUSTRALIA.
