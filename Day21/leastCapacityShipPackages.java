package Day21;

public class leastCapacityShipPackages {
    // tell the least capatcity to ship packages within D days

    // /brute 
    //  // Time: O((sum - max) * n)
    // Space: O(1)
    public static int leastCapBrute(int[] arr, int d){
        int sum=0;
        int max=0;

        for(int a: arr){
            max= Math.max(max,a);
            sum+=a;
        }

        for(int i=max; i <=sum; i++){
            int days=1;
            int load=0;
            
            for(int a: arr){
                if(load + a >i){
                    days++;
                    load=a;
                }else{
                    load +=a;
                }
            }
            if(days <= d) return i;
        }
        return -1;
    }



    // optimal
     // TTime: O(n * log(sum))
    // Space: O(1)

    public static int leastCapOptimal(int[] arr, int d){
        int max=0;
        int sum=0;

        for(int a: arr){
            max=Math.max(a,max);
            sum +=a;
        }

        int low=max;
        int high=sum;

        while( low <=high){
            int mid =(low+high)/2;

            int days= findDays(arr, mid);

            if(days <=d){
                high=mid-1;

            }else{
                low=mid+1;
            }

        }
        return low;
    }

    public static int findDays(int[] arr, int mid){
        int load=0;
        int days=1;

        for(int a: arr){
            if(a+load >mid){
                days++;
                load=a;
            }else{
                load +=a;
            }
        }
    return days;
    }


    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(leastCapBrute(arr, 5));
        System.out.println(leastCapOptimal(arr, 5));
    }

    
    

    
}
