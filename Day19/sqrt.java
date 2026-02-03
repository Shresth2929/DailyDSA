package Day19;

public class sqrt {
    // find sqrt of an int

    // in short :   find max no which on squaring is <= n

    // brute:
    // time: O(n)
    public static int sqrtBrute(int x){
        int ans=0;
        for(int i=0;i<x;i++){
            if( (long) i*i <=x){
                ans =i;
            }else{
                break;
            }
        }

        return ans;

    }


    // optimal
    // Time: O(log2 n)

    public static int sqrtOptimal(int n){
        int low=0;
        int high=n;
        int ans=0;

        while(low <= high){
            int mid=(high+low)/2;

            long sq=(long) mid* mid;
            if(sq <=n ){
                ans=mid; 
                // possible hai 

                // but search for bigger
                low=mid+1;

            }else{
                high=mid-1;
            }
        }
        return ans;
    } 


    

    public static void main(String[] args) {
        System.out.println(sqrtBrute(28));
        System.out.println(sqrtOptimal(28));
        
    }
    
}
