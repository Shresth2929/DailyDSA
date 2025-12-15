package ArrQuestions;

public class moveZeros {
    public static void moveeZerosInEnd(int [] arr, int n){
        int j=0;

        for(int i=0;i<n;i++){
            if(arr[i] !=0){
                arr[j]=arr[i];
                j++;

            }
        }
        while(j<n){
            arr[j]=0;
            j++;
        }


    }

    public static void main(String[] args){
        int arr[]={1,0,0,2,0,0,3,4,0,0,5,0,6,7,0};
        int  n=arr.length;

        moveeZerosInEnd(arr, n);
        for(int num:arr){
            System.out.print(num+" ");
        }
    
}
}