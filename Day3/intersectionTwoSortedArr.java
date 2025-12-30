
package Day3;
import java.util.*;

public class intersectionTwoSortedArr {
    public static ArrayList<Integer> intersection(int arr1[], int arr2[]){
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0; 
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if(!ans.isEmpty() && ans.get(ans.size()-1)==arr1[i]){
                i++;
                continue;
            }
            if(arr1[i]==arr2[j]){
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }else{
                j++;
            }
        }
        return ans;

    }



     public static void main(String[] args) {

        int arr1[] = {1, 2, 2, 3, 4, 5};
        int arr2[] = {2, 2, 3, 5, 6};

        ArrayList<Integer> result = intersection(arr1, arr2);

        System.out.println(result);
    }
    
}
