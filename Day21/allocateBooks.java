package Day21;

public class allocateBooks {
    // goiven arr with no of pages  and m no of students allocate such that 
    // 1. each student gets atleast 1 book
    // 2. each book should be allocated to only one student 
    // 3. book allocation should be in contiguous manner 

    

    // Brute Force
    // Time: O(n log n + n*(sum-max))
    // Space: O(1)

    public static int allocateBooksBrute(int[] arr, int m) {

        if (m > arr.length) return -1;

        int max = 0, sum = 0;

        for (int pages : arr) {
            max = Math.max(max, pages);
            sum += pages;
        }

        for (int pages = max; pages <= sum; pages++) {

            if (canAllocate(arr, m, pages)) {
                return pages;
            }
        }

        return -1;
    }

    private static boolean canAllocate(int[] arr, int m, int maxPages) {

        int students = 1;
        int pages = 0;

        for (int book : arr) {

            if (pages + book > maxPages) {
                students++;
                pages = book;
            } else {
                pages += book;
            }
        }

        return students <= m;
    }


        // Optimal Approach
    // Time: O(n log(sum))
    // Space: O(1)

    public static int allocateBooksOptimal(int[] arr, int m) {

        if (m > arr.length) return -1;

        int max = 0, sum = 0;

        for (int pages : arr) {
            max = Math.max(max, pages);
            sum += pages;
        }

        int low = max;
        int high = sum;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canAllocate(arr, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    public static void main(String[] args) {
        int[] arr={25,46,28,49,24};
        int m=4;
        System.out.println(allocateBooksBrute(arr, m));
        System.out.println(allocateBooksOptimal(arr, m));

    }


    
    
}
