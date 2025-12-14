package ArrQuestions;

public class rotatebyk {

    public static void reverse(int [] arr, int start, int end){
        while(start<end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
    public static void rotateByD(int []arr,int n, int d){
        d= d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr, 0, n-1);


    }

    public static void main(String[] args){
        int arr[]={1,2,3,4,5,6,7};
        int n=arr.length;
        int d=3;
        rotateByD(arr, n, d);

        for(int num:arr){
            System.out.print(num+" ");
        }

    }
}
