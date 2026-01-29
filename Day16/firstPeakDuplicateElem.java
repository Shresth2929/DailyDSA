package Day16;

public class firstPeakDuplicateElem {

    public static boolean searchEl(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        
        if (arr[mid] == x)
            return true;

        // duplicates case
        if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
            low++;
            high--;
        }
        // left half  is sorted
        else if (arr[low] <= arr[mid]) {
            if (arr[low] <= x && x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // right half  is sorted
        else {
            if (arr[mid] < x && x <= arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return false;
}

    public static void main(String[] args){
        int[] arr={7,8,9,1,1,1,2,3,4,4,5,6,6,6};
        System.out.println(searchEl(arr, 6));

    }

    
}
