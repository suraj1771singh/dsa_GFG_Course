// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String B = read.readLine();
            String G = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.binToGrey(B));
            System.out.println(ob.greyToBin(G));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static char xor_of(char a,char b){
        return (a!=b)?  '1' : '0';
    }
    static char flip_bit(char a){
        return (a=='1')? '0':'1';
    }
    static String binToGrey(String B) {
      String grey="";
      grey+=B.charAt(0);
      for(int i=1; i<B.length();i++){
          grey=grey+xor_of(B.charAt(i),B.charAt(i-1));
          
      }
      return grey;
        
    }
    static String greyToBin(String G) {
       String bin="";
       bin+=G.charAt(0);
       char prev_bit=bin.charAt(0);
       for(int i=1; i<G.length();i++){
           
            bin=bin+ xor_of(prev_bit, G.charAt(i));
            prev_bit=bin.charAt(bin.length()-1);
       }
       return bin;
    }
};