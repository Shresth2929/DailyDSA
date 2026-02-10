package Day20;

public class minDaysToMakeMbouquets {
    // min no of days to make M bouquets 

    // Brute Force
    // Time: O(maxDay × n)
    // Space: O(1)
    public static int findNoBrute(int[] arr,int m, int k){
        int n=arr.length;
        if(n < m*k) return -1;

        int max=0;
        for(int a: arr){
            max=Math.max(a,max);
        }
        for(int i=1;i<= max;i++){
            if(canMake(arr, m, k, i)){
                return i;
            }
        }
        return -1;

    }

    public static boolean canMake(int[] arr, int m, int k, int day){
        int bouquets=0;
        int flower=0;

        for(int a: arr){
            if( a<= day){
                flower++;
                if(flower == k){
                    bouquets++;
                    flower=0;
                }
            }else{
                flower=0;
            }
        }
        return bouquets >= m;
    }


    
     // Optimal (Binary Search)
    // Time: O(n × log(maxDay))
    // Space: O(1)

    public static int findNoOptimal(int[] arr, int m, int k){
        int n=arr.length;
        if(n < m*k) return -1;

    
        int low= Integer.MAX_VALUE;
        int high= Integer.MIN_VALUE;
        
        for(int a: arr){
            low=Math.min(low,a);
            high=Math.max(high,a);
        }

        int ans=-1;

        while(low <=high){
            int mid=(low+high)/2;

            if(canMake(arr,m,k, mid)){
                ans=mid;
                high= mid-1;
            }else{
                low=mid+1;

            }

        }
        return ans;
    }




    public static void main(String[] args){
        int[] arr={7,7,7,7,13,11,12,7};
        System.out.println(findNoBrute(arr, 2, 3));
        System.out.println(findNoOptimal(arr, 2, 3));

    }
    
}
