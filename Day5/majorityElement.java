package Day5;

import java.util.HashMap;

public class majorityElement {
    // brute force 
    // Time 0(n2) 
    // Space 0(1)
    // public static int majorityElement(int[] arr){
    //     for(int j=0;j<arr.length;j++){
    //     int c=0;
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[j]==arr[i]){
    //             c++;
    //         }

    //     }
    //     if(c>(arr.length/2)){
    //         return arr[j];
    //     }
    // }
    //     return -1;
    // }


    // better :hashing 
    // Time 0(n) 
    // Space 0(n) 
        //     public static int majorityElement(int[] arr){
        //         // HashMap banaya: key = element, value = us element ki frequency
        //         HashMap<Integer, Integer> map = new HashMap<>();

        //     // Array ke har element par loop chala rahe hain
        //     for (int i : arr){
        //         // i element ka count badha rahe hain
        //         // agar i pehle map me nahi hai → 0 se start
        //         // agar pehle se hai → purana count + 1
        //     map.put(i, map.getOrDefault(i, 0) + 1);

        //              // Check: kya current element ki frequency
        //             // array ke size ka half se zyada ho gayi?
        //     if (map.get(i) > (arr.length / 2)) {

        //         // Agar haan → wahi majority element hai
        //         return i;
        //     }
        // }

        // // Agar koi bhi element majority nahi nikla
        //     return -1;

        //     }


    // optimal : Moore's voting algorithm
    //  Time 0(n) 
    // Space 0(1) 

    public static int majorityElement(int [] arr){
       // Candidate ko store karne ke liye variable
            int candidate = 0;

            // Count variable jo vote balance maintain karega
            int count = 0;

            // ===================== STEP 1: Find Candidate =====================
            for (int i : arr) {

                // Agar count 0 ho gaya, to naya candidate choose karo
                if (count == 0) {
                    candidate = i;
                }

                // Agar current element candidate ke equal hai
                if (i == candidate) {
                    count++;          // vote mil gaya → count badhao
                } else {
                    count--;          // vote cancel → count ghatao
                }
            }

            // ===================== STEP 2: Verify Candidate =====================

            // Count reset kar rahe hain actual frequency check karne ke liye
            count = 0;

            // Poora array traverse karke candidate ka actual count nikaalna
            for (int j : arr) {
                if (j == candidate) {
                    count++;
                }
            }

            // Check: kya candidate majority condition satisfy karta hai?
            if (count > arr.length / 2) {
                return candidate;     // Haan → majority element mil gaya
            }

            // Agar majority element exist hi nahi karta
            return -1;

                }



    public static void main(String[] args){
        int arr[]={2,2,3,3,1,2,2};
        System.out.println(majorityElement(arr));

    }
    
}
