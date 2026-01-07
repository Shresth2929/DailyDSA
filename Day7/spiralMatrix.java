package Day7;

// optimal
    // time: O(n*m);
    // Space: O(1);

    import java.util.*;

public class SpiralMatrix {

    public static List<Integer> spiralMatrix(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;        
        int n = matrix[0].length;     

        // Initialize boundaries
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        // Jab tak boundaries cross nahi hoti
        while (top <= bottom && left <= right) {

            // 1. Traverse top row (left → right)
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;   // top boundary neeche lao

            // 2️ Traverse right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // right boundary left lao

            // 3️ Traverse bottom row (right → left)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // bottom boundary upar lao
            }

            // 4️ Traverse left column (bottom → top)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // left boundary right lao
            }
        }

        return result;
    }



       public static void main(String[] args) {
        int[][] arr={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        
    System.out.println(spiralMatrix(arr));
       }
    
}
