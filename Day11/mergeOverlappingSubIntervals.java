package Day11;
import java.util.*;

public class mergeOverlappingSubIntervals {


    // brute
    // time: O(n2)     space: O(n)


    public static List<int[]> mergeOverLappingSubIntervals(int[][] arr){
                
        int n=arr.length;
        List<int[]> res=new ArrayList<>();
        boolean[] visited=new boolean[n];

        Arrays.sort(arr, (a,b)-> a[0] - b[0]);

        for(int i=0;i<n;i++){
            if(visited[i]) continue;

            int start=arr[i][0];
            int end=arr[i][1];

            visited[i]=true;

            for(int j=i+1;j<n;j++){
                if(!visited[j] && arr[j][0] <=end && arr[j][1] >=start){
                    end=Math.max(end,arr[j][1]);
                    visited[j]=true;
                }
            }
            res.add(new int[]{start,end});   
        }
        return res;

    }

    // optimal
    // time:O(n log n ) sorting                  space:  O(1) / O(n) (output)

    public static List<List<Integer>> mergeOverLap(int[][] arr){
         Arrays.sort(arr, (a,b) -> a[0] - b[0]);
         int n=arr.length;

         List<List<Integer>> list=new ArrayList<>();

         int start=arr[0][0];
         int end=arr[0][1];

         for(int i=1;i<n;i++){
            if(arr[i][0] <=end){
                end = Math.max(end,arr[i][1]);
            }else{
                list.add(Arrays.asList(start,end));
                start=arr[i][0];
                end=arr[i][1];
            }
         }
         list.add(Arrays.asList(start,end));
         return list ;
    }



    public static void main(String[] args) {
        int[][] arr={
            {1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}
        };
        
        List<int[]> res = mergeOverLappingSubIntervals(arr);

        for (int[] interval : res){
                System.out.println(Arrays.toString(interval));
            }
        
        System.out.println(mergeOverLap(arr));

}
}

