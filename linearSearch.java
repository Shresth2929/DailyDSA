package ArrQuestions;

public class linearSearch {
    public static boolean linearr(int []arr, int n, int k){
        boolean contains=false;
        for(int i=0;i<n;i++){
            if(arr[i]==k){
                contains=true;

            }
        }
        return contains;

    }

    public static void main(String[] args){
        int arr[]={1,2,3,4,5,6,7};
        int  n=arr.length;
        int k=14;
        System.out.println(linearr(arr, n, k));

    }
    
}
