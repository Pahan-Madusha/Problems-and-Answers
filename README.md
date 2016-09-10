##Problem - Submask Queries

Consider an **```n-element```** set, _**```U = {1, 2, 3, ..., n}```.**_ Each subset _**```S ⊂ U```**_ is assigned a value, _**```val(S)```**_. Initially _**```val(S) = 0```**_ for all _**```S ⊂ U```**_.

We have three types of queries:

1. **```1 x s```**: Given an integer, **```x```**, and set _**```S ⊂ U```**_ , assign a value, ```x```, for all subsets of **```S```** (i.e., set **```val(T) = x```** for all _**```T ⊂ S```**_ ).
2. **```2 x s```**: Given an integer, **```x```**, and set ,_**```S ⊂ U```**_ **```XOR```** all values in the subset of **```S```** with  **```x```**(i.e., set **```val(T) = val(T) ⊕ x```** for all _**```T ⊂ S```**_).
3. **```3 s```**: Given set _**```S ⊂ U```**_, find and print **```val(S)```** on a new line.
in which set **```S```** is a binary string of length **```n```** where the index of each 1-bit corresponds to the index of an element in **```U```** that belongs to set **```S```**.
<br>
Given **```n```**, perform all **```m```** queries. For each query of type **```3```**, print the value of **```val(S)```** on a new line.

####Input Format

The first line contains two space-separated integers describing the respective values of **```n```** (the size of set **```U```**) and **```m```**(the number of queries to perform). 
Each of the **```m```** subsequent lines contains a query in the form:

1. ```1 x s```
2. ```2 x s```
3. ```3 s```
<br>
where **```s```** is a binary string (i.e., zeroes and ones) of length **```n```** and the index of each 1-bit denotes the index of an element in **```U```** to include in subset **```S```**.

####Constraints

* **```1 ≤ n ≤ 16```**
* **```1 ≤ m ≤ 10^5```**
* **```0 ≤ x ≤ 2^30 - 1```** for each query.

####Output Format

For each query of type **3**, print the answer to the query (i.e., **```val(S)```**) on a new line.

####Sample Input

 **```3 4```<br>
 ```1 3 110```<br>
 ```3 100```<br>
```2 1 011```<br>
```3 010```**<br>

####Sample Output

 **```3```**
 **```2```**
 
####Explanation

Initially, **```val(S) = 0```** for all **```S ⊂ U = {1, 2, 3}```**_. We perform the following sequence of queries:

1. For ```1 3 110```, ```S = 1```, so we set ```val({1, 2}) = val({2}) = val({1}) = val(Ø) = 3```
2. For ```3 100```, ```S = 1``` so ```val(S) = val({1}) = 3```.
3. For ```2 1 011```, we ```xor``` values ```val({2, 3}), val({2}), val({3}), val(Ø)``` with  ```x = 1``` and get 
        ```val({2, 3} = 1)
        val({2}) = 2
        val({3}) = 1
        val(Ø) = 2```
4. For ```3 010```, ```S = {2}```  so ```val(S) = val({2}) = 2```.
