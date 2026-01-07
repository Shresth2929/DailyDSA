package Day7;
import java.util.*;


public class setMatrixZero {

    // brute 
    // time: O(n3)
    // space: O(1)

    // public static void setMatrixZero(int[][] arr){
    //     int n=arr.length;
    //     int m=arr[0].length;

    //      for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {

    //             if (arr[i][j] == 0) {

    //                 // Mark entire row
    //                 for (int col = 0; col < m; col++) {
    //                     if (arr[i][col] != 0)
    //                         arr[i][col] = -1;
    //                 }

    //                 // Mark entire column
    //                 for (int row = 0; row < n; row++) {
    //                     if (arr[row][j] != 0)
    //                         arr[row][j] = -1;
    //                 }
    //             }
    //         }
    //     } 

           
    //             // convert -1 to 0
    //         for(int i=0;i<n;i++){
    //             for(int j=0;j<m;j++){
    //                 if(arr[i][j]==-1){
    //                     arr[i][j]=0;
    //                 }
    //             }
    // }
    // }

    // better 
    // time: O(n2)
    // space: O(n+m)

    // Ek array row[]
    // Ek array col[]
    // Pehle note karo kaunsi row/col me zero hai
    // Fir un rows/cols ko zero bana do

    // public static void setMatrixZero(int[][] arr){
    //     int n=arr.length;
    //     int m=arr[0].length;

    //     boolean[]rows= new boolean[n];
    //     boolean[]cols=new boolean[m];

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(arr[i][j] ==0){
    //                 rows[i]=true;
    //                 cols[j]=true;
    //             }
    //         }

    //     }
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(rows[i] || cols[j]){
    //                 arr[i][j]=0;
    //             }
    //         }
    //     }
    // }


    // optimal
    // First row & first column ko marker bana do
    // Extra space ki zarurat nahi
    // matrix[i][0] → row marker
    // matrix[0][j] → column marker
    // Ek extra variable col0 to track first column
    // time: O(n2)
    // space: O(1)

   public static void setMatrixZero(int[][] arr) {

    int n = arr.length;        // number of rows
    int m = arr[0].length;     // number of columns

    int col0 = 1;              // ye batata hai: first column zero hogi ya nahi

    // ================= STEP 1: MARK ROWS & COLUMNS =================
    for (int i = 0; i < n; i++) {

        // Agar first column me zero mila
        if (arr[i][0] == 0) {
            col0 = 0;          // matlab poori first column zero hogi
        }

        // Column 1 se check karte hain (0 skip because marker hai)
        for (int j = 1; j < m; j++) {

            // Agar kisi cell me zero mila
            if (arr[i][j] == 0) {

                arr[i][0] = 0;   // ith row ko mark kar diya
                arr[0][j] = 0;   // jth column ko mark kar diya
            }
        }
    }

    // ================= STEP 2: CONVERT MARKS INTO ZERO =================
    // Reverse traversal taaki markers overwrite na ho
    for (int i = n - 1; i >= 0; i--) {

        for (int j = m - 1; j >= 1; j--) {

            // Agar row ya column marked hai
            if (arr[i][0] == 0 || arr[0][j] == 0) {
                arr[i][j] = 0;   // cell ko zero kar do
            }
        }

        // Agar first column ko zero banana tha
        if (col0 == 0) {
            arr[i][0] = 0;
        }
    }
}

     




    public static void main(String[] args) {
        int[][] arr={
            {1,1,1,1},
            {1,0,0,1},
            {1,1,0,1},
            {1,1,1,1}
        };
    
    setMatrixZero(arr);

    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j]);
        }
        System.out.println();
    }
}    
}
    