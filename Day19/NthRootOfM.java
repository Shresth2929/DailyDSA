package Day19;

public class NthRootOfM {
    // if n=3   m=27 find 3rd root of 27 which is 3

    // brute
    // time: O(m × n)
    // space: O(1)
    public static int nthRoot(int m, int n){

        for(int i=1; i<m;i++){
            long val= power(i,n);
            if(val==m) return i;
            if(val >m) break;
        }
        return -1;
    }

    public static long power(int base , int pow){
        long r=1;
        for(int i=0;i<pow ;i++){
            r *=base;
        }
        return r;
    }  



    // optimal
    // time: O(log m × n)
    // space: O(1)

    public static int nthRootOptimal(int m, int n){

        int low=1;
        int high=m;

        while( low <=high){

            int mid=(low+high)/2;

            long val= poww(mid, n, m); 

            if(val == m){
                return  mid;
            }else if(val <m){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return -1;

    }

    public static long poww(int base, int exp, int limit){
        long r=1;
        for(int i=1;i<=exp;i++){
            r *= base;
            if(r>limit) return r;
        }
        return r;

    }


    public static void main(String[] args){
        System.out.println(nthRoot(27, 3));


        System.out.println(nthRootOptimal(27, 3));

    }
    
}
