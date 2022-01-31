/**
 * Name: Saul Ouellet
 * Date: January 25th 2022
 * Description: This project implements a Main class with various methods to print and manipulate 1D and 2D Arrays. I've implemented
 * most of them so that the prints are in the methods themselves for clean readability.
 */

package Lab;

public class Main {

    /***
     * it's a main function, what else is there to say?
     * @param args This supplies arguments to the main function.
     */

    public static void main(String[] args){

        System.out.println("Q1 Test =================================================================================================================");

        String fullName = "Saul Z. Ouellet";

        displayName(fullName);

        System.out.println("Q2 Test =================================================================================================================");

        int testArr[] = { 1, 2, 3, 4, 5};

        displayArray(testArr);

        System.out.println("Q3 Test =================================================================================================================");

        int testArr2[][] = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
        };

        displayArray2(testArr2);

        System.out.println("Q4 Test =================================================================================================================");

        int testArr3[] = {1, 2, 3};

        int testArr4[] = {5, 6, 7};

        int testArr5[] = {5, 6, 7};

        compareArray(testArr, testArr4);    //diff sizes

        compareArray(testArr3, testArr4);   //diff elems

        compareArray(testArr4, testArr5);   //same

        System.out.println("Q5 Test =================================================================================================================");

        int testArrA[][] = {        //3x5
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
        };

        int testArrB[][] = {        //3x5
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
        };

        int testArrC[][] = {        //3x4
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11,12,13,14},
        };

        int testArrD[][] = {        //2x5
               {1, 2, 3, 4, 5},
               {6, 7, 8, 9, 10},
        };

        int testArrZ[][] = {        //3x5
                {1, 1, 1, 1, 1},
               {6, 7, 8, 9, 10},
               {11,12,13,14,15},
        };


        compareArray2(testArrA, testArrB);  //3x5 vs 3x5 works -- they match

        compareArray2(testArrA, testArrZ); //3x5 vs 3x5 works -- they don't match

        compareArray2(testArrA, testArrC);  //3x5 vs 3x4 doesnt work

        compareArray2(testArrA, testArrD);  //3x5 vs 2x5 doesnt work

        System.out.println("Q6 Test =================================================================================================================");

        sumArray(testArr);

        System.out.println("Q7 Test =================================================================================================================");

        sumArray2(testArrA);

        System.out.println("Q8 Test =================================================================================================================");

        int testArrM[][] = {        //5x3
                {1, 2, 3},
                {6, 7, 8},
                {11,12,13},
                {16,17,18},
                {19,20,21}
        };

        int testArrN[][] = {        //5x3
                {1, 2, 3},
                {6, 7, 8},
                {11,12,13},
            };

        displayArray2(multMat(testArrA, testArrM));     //successful     3x5 * 5x3
        int multA[][] = multMat(testArrA, testArrA);    //unsuccessful   3x5 * 3x5
        int multB[][] = multMat(testArrM, testArrD);    //unsuccessful   5x3 * 2x5
        displayArray2(multMat(testArrN,testArrN));      //successful     3x3 * 3x3

    }//main bracket

    /***
     * function takes string input, outputs it in format displaying name
     * @param name Supplies string to function
     */
    public static void displayName(String name){
        System.out.println("Name: " + name);
    }

    /***
     * function displays 1D array using a for loop
     * @param intArr supplies 1D int array to function
     */
    public static void displayArray(int intArr[]){
        System.out.print("[");
        for(int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i]);
            if(i != intArr.length-1)
            System.out.print(", ");
        }
        System.out.print("]\n");
    }

    /***
     * function displays a 2D array using nested for loops
     * @param intArr supplies 2D int array to function
     */
    public static void displayArray2(int intArr[][]){
        for(int i = 0; i < intArr.length; i++){
            System.out.print("[");
            for(int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j]);
                if(j != intArr[i].length-1)     //print commas until you've reached your last element
                System.out.print(", ");
            }
            System.out.print("]\n");
        }
    }

    /***
     * function compares 2 1D int arrays with one another, will indicate if arrays are compatible or not.
     * @param a supplies first int 1D array to function
     * @param b supplies second int 1D array to function
     * @return  return is boolean (true or false) -- automatically false if not compatible
     */
    public static boolean compareArray(int a[], int b[]){
        if(a.length != b.length){
            System.out.println("Arrays are incompatible (Not the same size)");
            return false;
        }
        for(int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.out.println("Equal: false");
                return false;
            }
        }
        System.out.println("Equal: true");
        return true;
    }

    /***
     * function compares 2 2D int arrays with one another, will indicate if they're compatible or not.
     * @param a supplies first int 2D array to function
     * @param b supplies second int 2D array to function
     * @return  returns boolean (true or false) -- automatically false if not compatible
     */
    public static boolean compareArray2(int a[][], int b[][]){
        if(a.length != b.length || a[0].length != b[0].length){
            System.out.println("Arrays are incompatible (Different Row and/or Column Size)");
            return false;
        }
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length;j++){
                if(a[i][j] != b[i][j]) {
                    System.out.println("Equal: false");
                    return false;
                }
            }
        }
        System.out.println("Equal: true");
        return true;
    }

    /***
     * function returns the sum of all elements in 1D array using for loop
     * @param intArr supplies int 1D array to function
     * @return returns an int of the sum
     */
    public static int sumArray(int intArr[]){
        int sum = 0;
        for(int elem : intArr)
            sum += elem;

        System.out.println(sum);
        return sum;
    }

    /***
     * function returns the sum of all elements in a 2D array using nested for loops
     * @param intArr supplies int 2D array to function
     * @return returns an int of the sum of all elems
     */
    public static int sumArray2(int intArr[][]){
        int sum = 0;
        for(int i = 0; i < intArr.length; i++)
            for(int j = 0; j < intArr[i].length; j++){
                sum += intArr[i][j];
            }
        System.out.println(sum);
        return sum;
    }

    /***
     * function checks if two matrices can multiply, then does so if possible using nested for loops -- else it says why it failed and returns null
     * @param a supplies first int 2D array to function
     * @param b supplies second int 2D array to function
     * @return returns the result, which is an int 2D array
     */
    public static int[][] multMat(int a[][], int b[][]){
        if(a[0].length != b.length){
            System.out.println("Matrices are incompatible! Matrix 1 column size != Matrix 2 row size! Returning null.\n" +
                    "Matrix 1 column size: " + a[0].length +
                    "\nMatrix 2 row size: " + b.length);
            return null;
        }

        int result[][] = new int[a.length][b[0].length];    //Resulting matrix is row size of A by column size of B

        for(int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < result.length; k++) {
                    result[i][j] += a[i][k]*b[k][j];        //sum of dot product between row of matrix A and column of matrix B
                }
            }
        }
        return result;
    }

}//Main bracket
