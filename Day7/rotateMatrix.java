package Day7;
import java.util.*;
public class rotateMatrix {

    // breute and better 
    // time: O(n2)
    // space : O(n2) extra space

    public static int[][] rotateMatrix(int[][] arr){
        // square matrix 
        int n=arr.length;
        int [][] result=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[j][n-1-i]=arr[i][j];
            }
        }return result;

    }

    // optimal 
    // time: O(n2)
    // space: O(1)

    public static void rotateMatrix2(int [][] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int t=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=t;
            }
        }
        for(int i=0;i<n;i++){
            int l=0; 
            int r=n-1;
            while(l<r){
                int t=arr[i][l];
                arr[i][l]=arr[i][r];
                arr[i][r]=t;
                l++;
                r--;

            }
        }
        

    }

    public static void main(String[] args) {
        int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        
    System.out.println(Arrays.deepToString(rotateMatrix(arr)));
    rotateMatrix2(arr);
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }

    
    }
}
