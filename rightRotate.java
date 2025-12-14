// arr = [1, 2, 3, 4, 5, 6, 7]
// Right rotate by 1 →
// Output: [7, 1, 2, 3, 4, 5, 6]

// arr = [1, 2, 3, 4, 5, 6, 7]
// d = 3
// Right rotate by 3 → last 3 elements front aa jaayenge:
// [5, 6, 7, 1, 2, 3, 4]

// STEP 1 — Reverse the whole array
// STEP 2 — Reverse first d elements
// STEP 3 - Reverse last n—d elements


package ArrQuestions;

public class rightRotate {
    public static void rightRotateBy1(int[] arr, int n){
        int temp=arr[n-1];
        for(int i=n-1;i>0;i--){
            arr[i]=arr[i-1];

        }
        arr[0]=temp;


    }

    public static  void Rotate(int arr[], int start, int end){
        while(start < end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void rightRotateByD(int []arr, int n, int d){
        d=d%n;
        Rotate(arr, 0, n-1);
        Rotate(arr, 0, d-1);
        Rotate(arr, d, n-1);
        
    }


    public static void main(String[] args){
        int arr[]={1,2,3,4,5,6,7};
        int  n=arr.length;

        rightRotateBy1(arr, n);
        for(int num:arr){
            System.out.print(num+" ");
        }

        int d=3;
        System.out.println();

        // rightRotateByD(arr, n,d);
        for(int num:arr){
            System.out.print(num+" ");
        }

    }
    
}
