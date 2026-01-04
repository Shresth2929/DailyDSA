package Day5;

public class sortArr012 {
  
    // brute (sorting algo)
    // time Complexity: O(n log n)
    // Space Complexity: O(1) (in-place for primitives)
    // public static void bubbleSort(int[] arr){
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i;j<arr.length;j++){
    //             if(arr[i]>arr[j]){
    //                 int t=arr[i];
    //                 arr[i]=arr[j];
    //                 arr[j]=t;
    //             }
    //         }
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]);
    //     }

    // }

    // better: 
    // Complexity Time: O(n)
    // Space: 0(1)
    // Passes: 2 (one for iterating&counting and one for filling the arr) hence Good But not optimal

    // public static void sortArr012(int[] arr){
    //     int c0=0;
    //     int c1=0;
    //     int c2=0;
    //     for(int i: arr){
    //         if(arr[i]==0){
    //             c0++;
    //         }else if(arr[i]==1){
    //             c1++;
    //         }else{
    //             c2++;
    //         }
    //     }
    //     int idx=0;
    //     while(c0>0){
    //         arr[idx]=0;
    //         idx++;
    //         c0--;
    //     }
    //     while(c1>0){
    //         arr[idx]=1;
    //         idx++;
    //         c1--;
    //     }
    //     while(c2>0){
    //         arr[idx]=2;
    //         idx++;
    //         c2--;
    //     }
    //     for(int i=0;i<arr.length;i++){
    //     System.out.print(arr[i]+" ");
    //     }
    // }

    // optimal:dutch national flag algo 
//  time	O(n)
// Space	O(1)
// Passes	1 ✅
    public static void sortArr012(int[] arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                int t=arr[mid];
                arr[mid]=arr[low];
                arr[low]=t;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                int t=arr[mid];
                arr[mid]=arr[high];
                arr[high]=t;
                high--;

            }
        }
        for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
        }

    }

    public static void main(String[] args) {
        int arr[]={0,1,2,0,1,2,1,2,0,0,0,1};
        sortArr012(arr);
        // bubbleSort(arr);

    }
    
}
