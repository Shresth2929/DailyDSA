package Day9;

public class pascalTriangle {

    // it has three types:
    // 1; given rows and cols find element at that place 
    // 2; print any nth row
    //  3 given n print whole pascal tri
    // formula nCr = n! / (r! * (n-r)!)


    // 1:
    // optiaml:
    // time: O(r) space: O (1)

    public static int pascalElement(int n,int r){
        long a=1;
        for(int i=0;i<r;i++){
            a=a*(n-i);
            a=a/(i+1);

        }
        return (int)a;
        
    }

    // 2:
    // time: O(n) space: O(1)

  public static void printNthRow(int n) {
        long res = 1;
        System.out.print(res + " ");

        for (int i = 1; i < n; i++) {
            res = res * (n - i);
            res = res / i;
            System.out.print(res + " ");
        }
    }

    // 3:
    // brtue : using formula
    // time: O(n3) space: O(1)
    // public static void printPascalTri(int n){
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<=i;j++){
    //             System.out.println(pascalElement(i, j)+" ");
    //         }System.out.println();
    //     }
    // }

    // better : 
    // time: O(n2)
    // space: O(n2)

    // public static void printPascalTri(int n){
    //     int[][] t=new int[n][n];
    //     for(int i=0;i<n;i++){
    //         t[i][0]=t[i][i]=1;

    //         for(int j=1;j<i;j++){
    //             t[i][j]=t[i-1][j-1]+t[i-1][j];
    //         }

    //     }
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<=i;j++){
    //             System.out.print(t[i][j]+" ");

    //         }System.out.println();
    //     }
    // }

    // optimal
    // time: O(n2)
    
    public static void printPascalTri(int n){
        for(int i=0;i<=n;i++){
            long a=1;
            System.out.println(a+" ");
            for(int j=1;j<i;j++){
                a= a*(i-j);
                a=a/j;
            System.out.println(a+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println(pascalElement(5,2 ));
        System.out.println();
        printNthRow(4);
        System.out.println();
        printPascalTri(3);

        
    }

    
}
