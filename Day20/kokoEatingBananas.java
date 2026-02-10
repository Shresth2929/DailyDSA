package Day20;

public class kokoEatingBananas {
    // return min int K(how many bananas per hr) such that koko can eat all bananas with in H hrs  

    // brute
    // time: O(max(arr) * n);
    // space: O(1)
    public static int findKBrute(int[] arr, int h){
        int max=0;
        for(int a: arr){
            max=Math.max(a,max);
        }

        for(int k=1;k<=max;k++){
            int hrs=0;
            
            for(int a: arr){
                 hrs += (a+k -1)/k;
                
            }
            if(hrs <=h){
                return k;
            }
        }
        return -1;
    }

    // optimal;
    // time: 0(log 2 max(arr))

    public static int findKOptimal(int[] arr, int h){
        int low=1;
        int high=0;

        for(int a: arr){
            high=Math.max(a,high);

        }
        int ans=high;
        while(low<=high){
            int mid=(low+high)/2;
            int hrs=0;

            for(int a: arr){
                hrs +=(a+ mid -1)/mid;

            }
            if(hrs<= h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
            return ans;
    }




    public static void main(String[] args){
        int[] arr= {3, 6, 7, 11};
        int h=8;
        System.out.println(findKBrute(arr,h));
        System.out.println(findKOptimal(arr,h));


    }

    
}
