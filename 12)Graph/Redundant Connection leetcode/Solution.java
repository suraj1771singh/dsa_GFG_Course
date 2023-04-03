//using disjoint set DS

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans=new int[2];
        int n= edges.length;
        int [] parent= new int[n+1];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        for(int [] edge: edges){
            int x= find(edge[0],parent);
            int y= find(edge[1],parent);
            if(x==y) {
                ans=edge;
            }else{
                parent[x]=y;
            }
        }
        return ans;
    }
    public int find(int x, int[]parent){
        if(parent[x]==x) return x;
        return find(parent[x],parent);
    }
}