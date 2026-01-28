package Day15;

import java.util.Arrays;

public class floorCeilSortedArr {

    // tc : O(log2 n)

    public static int[] findFloorCeil(int[] arr, int x){
        int n=arr.length;
        int floor=-1;
        int ceil=-1;
        int low=0;
        int high=n-1;

        while(low<= high){
            int mid=(low +high)/2;

            if(arr[mid] == x){
                floor=arr[mid];
                ceil=arr[mid];
                break;

                
            }
            else if (arr[mid] > x){
                ceil=arr[mid];
                high=mid-1;
                

            }else{
                floor=arr[mid];
                low=mid+1;
            }

        }
        return new int[]{floor,ceil};

    }
    
    public static void main(String[] args) {
        int arr[]= {3, 4, 7, 8, 10};

        System.out.println(Arrays.toString(findFloorCeil(arr, 5)));
        System.out.println(Arrays.toString(findFloorCeil(arr, 8)));
        System.out.println(Arrays.toString(findFloorCeil(arr, 1)));
        System.out.println(Arrays.toString(findFloorCeil(arr, 12)));
        

    }
}
