package Day9;
import java.util.*;

public class majorityEl {
    // return count of majority elements(elem taht occur more thatn n/3 times)
    // there can be only n/3 majority elements 

    // brute
    // time: O(n2) sapce: O(1)
    // public static List<Integer> countMajority(int[] arr){
    //     int n=arr.length;
    //     List<Integer> ans=new ArrayList<>();

    //     for(int i=0;i<n;i++){
    //         if(ans.contains(arr[i])) continue;
    //         int c=0;

    //         for(int j=0;j<n;j++){
                
    //             if(arr[i]==arr[j]){
    //                 c++;
    //             }
    //         }
    //         if(c >n/3 ){
    //             ans.add(arr[i]);
    //         }
    //     }
    //     return ans;
    // }


    // better : hashing
    // time: O(n) sapce: O(n)
    // public static List<Integer> countMajority(int[] arr){
    //     int n=arr.length;
    //     HashMap<Integer, Integer>map=new HashMap<>();
    //     List<Integer>list=new ArrayList<>();

    //     for(int num: arr){
    //         map.put(num,map.getOrDefault(num,0)+1);
    //     }
    //     for(int key: map.keySet()){
    //         if(map.get(key)> n/3){
    //             list.add(key);
    //         }
    //     }

    //     return list;
    // }

    // optimal: extended boyer moore voting algorithm
    public static List<Integer> countMajority(int[] arr){
        int n=arr.length;
        int c1=0;
        int c2=0;
        int can1=0;
        int  can2=0;
        for(int num: arr){
            if(num==can1){
                c1++;
            }else if(num==can2){
                c2++;
            }else if(c1==0){
                can1=num;
                c1=1;
            }else if(c2==0){
                can2=num;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int num: arr){
            if(num== can1){
                c1++;
            }else if(num== can2){
                c2++;
            }
        }

        List<Integer> list=new ArrayList<>();
        if(c1> n/3) list.add(can1);
        if(c2> n/3) list.add(can2);

        return list;
    }


    public static void main(String[] args) {
        int arr[]={1,1,1,1,3,2,2,2};
        System.out.println(countMajority(arr));

    }
    
}
