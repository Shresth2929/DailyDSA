package Day10;
import java.util.*;

public class threeSum {
    // find triplets that sum up to the target 

    // brute 
    // time: O(n3)
    // space: O(unique triplets )
    public static List<List<Integer>> threeSum(int[] arr,int t){
        int n=arr.length;
        HashSet<List<Integer>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==t){
                        List<Integer>temp=Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                }
            }
        }
        return new ArrayList<>(set);
    }

    // better
    // time: O(n2) space: O(n)

    public static List<List<Integer>> threeSum2(int[] arr, int t){
        int n=arr.length;
        Set<List<Integer>>res=new HashSet<>();

        for(int i=0;i<n;i++){
            Set<Integer>set=new HashSet<>();

            for(int j=i+1;j<n;j++){
                int third= (t -(arr[i]+arr[j]));

                if(set.contains(third)){
                    List<Integer>temp=Arrays.asList(arr[i],arr[j],third);
                    Collections.sort(temp);
                    res.add(temp);

                }
                set.add(arr[j]);
            }

        }
        return new ArrayList<>(res);

    }

    // optimal: Two pointers
    public static List<List<Integer>> threeSum3(int[] arr, int t){
        List<List<Integer>>ans=new ArrayList<>();

        Arrays.sort(arr);
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(i>0 && arr[i] ==arr[i-1]) continue;

            int left=i+1;
            int right=n-1;

            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum == t){
                    ans.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;

                
                while(left <right && arr[left] == arr[left-1]) left++;
                while(left <right && arr[right] == arr[right+1]) right --;
                }
                else if(sum>t){
                    right --;
                }
                else{
                    left ++;
                }
            }
        }
        return ans;

    }


    public static void main(String[] args){
        int arr[]={-1,2,3,4,5,-1,2,2,3,2,5,3};
        int t=4;
        System.out.println(threeSum(arr,t));
        System.out.println(threeSum2(arr,t));
        System.out.println(threeSum3(arr,t));

    }
    
}
