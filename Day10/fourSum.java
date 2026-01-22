package Day10;
import java.util.*;

public class fourSum {

    // brute
    // time: O(n4) space: O(unqiue results)

    public static List<List<Integer>> fourSum(int[] arr, int t){
        Set<List<Integer>>set=new HashSet<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        int sum= arr[i]+arr[j]+ arr[k]+arr[l];
                        
                        if(sum ==t){
                        List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        Collections.sort(temp);
                        set.add(temp);

                        }

                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // better : hashset
    // time:O(n3) space: O(n) 

    public static List<List<Integer>> fourSum2(int[] arr, int t){
        Set<List<Integer>> result=new HashSet<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer>set=new HashSet<>();

                for(int k=j+1;k<n;k++){
                    int fourt =t-(arr[i]+arr[j]+ arr[k]);

                    if(set.contains(fourt)){
                        List<Integer>temp=Arrays.asList(arr[i],arr[j], arr[k],fourt);
                        Collections.sort(temp);
                        result.add(temp);
                    }

                    set.add(arr[k]);
                }

            }

        }
         return  new ArrayList<>(result);


    }



    // optimal: two pointers
   // time:O(n3) space: O(1) 

   public static List<List<Integer>> fourSum3(int[] arr, int t){
    int n=arr.length;
    Arrays.sort(arr);

    Set<List<Integer>> set=new HashSet<>();

    for(int i=0;i<n;i++){
        if(i>0 && arr[i] == arr[i-1]) continue;

        for(int j=i+1;j<n;j++){

            if(j>i+1 && arr[j] == arr[j-1]) continue;

            int left=j+1;
            int right=n-1;

            while(left<right){
                long sum= (long)arr[i]+arr[j]+ arr[left]+arr[right];

                if(sum==t){
                    set.add(Arrays.asList(arr[i],arr[j], arr[left],arr[right]));
                    left++;
                    right--;

                    while(left <right &&  arr[left]== arr[left-1]) left++;
                    while(left <right && arr[right]== arr[right+1]) right --;

                }
                else if(sum >t){
                    right --;
                }else{
                    left++;
                }
            }
        }
    }
    return new ArrayList<>(set);

   }

    

    



    public static void main(String[] args) {
        int arr[]={-2,3,4,-1,1,1,2,-2,3,3,4,-4};
        int t=4;
        System.out.println(fourSum(arr, t));
        System.out.println(fourSum2(arr, t));
        System.out.println(fourSum3(arr, t));


        
    }
    
}
