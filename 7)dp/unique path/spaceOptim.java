// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
       int mod=1000000007;
       long [] prev= new long [n];
       Arrays.fill(prev,0);
       prev[0]=1;
       for( int i=0; i<m; i++){
           long [] temp= new long[n];
           for( int j=0; j<n; j++){
               temp[j]=prev[j];
               if(j>0) temp[j]+=temp[j-1];
               temp[j]=temp[j]%mod;
           }
           prev=temp;
       }
       return prev[n-1];
    }
}

// Time complexity : o(n*m)
// space complexity : O(n)