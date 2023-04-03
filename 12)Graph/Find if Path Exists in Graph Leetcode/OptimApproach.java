
//---------OPTIMIZED solution
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] used = new boolean[n];
        used[start] = true;
        boolean newusedfound = true;
        while (!used[end] && newusedfound) {
            newusedfound = false;
            for (int[] edge : edges) {
                if (used[edge[0]]) {
                    if (!used[edge[1]])
                        newusedfound = used[edge[1]] = true;
                } else if (used[edge[1]])
                    newusedfound = used[edge[0]] = true;
            }
        }
        return used[end];
    }
}

// The code below runs in 2ms as of Auguts 28, 2021. Leetcode run times change
// on multiple
// SUBMITs of the same code, so this code has also run as slow as 4ms. Run times
// can also
// change when more test cases are added to the SUBMIT in the future.

// This is simple brute force code. It starts at the start node, marking the
// start node as
// "used". Then make a pass through the edges array, marking any nodes connected
// to the start
// node as "used". Keep making iterative passes through the edges array, marking
// any "unused"
// node connected to a "used" node as now being "used". This will eventually
// create a group of
// "used" nodes that contains all of the nodes with a path to the start node. In
// the iterative
// passes, if we ever mark the end node as used, then a path exists from start
// to end nodes,
// and we return true. If we make an iterative pass through the edges array, but
// we don't
// find any nodes to mark as "used", then the entire group of nodes with a path
// connecting
// to the start node have been found but this group does not include the end
// node, so return false.

// Any fancier method I tried for this problem had slower run time. I tried
// union find, BFS,
// and enhancing this brute-force code, but they were all slower run-time. I
// even tried
// brute-force for smaller number of nodes, combined with fancier methods for
// larger
// number of nodes. The original brute-force code always had a faster average
// run-time.

// This is essentially a BFS solution, but not a very optimized algorithm. In
// the worst
// case of 200_000 nodes all connected in a single linear path from start to
// end, this
// is an O(n^2) algorithm, with n=200_000. This algorithm is a crude BFS because
// it
// starts at the start node. Then, on the first pass through the entire edges
// array,
// it finds all nodes 1 hop from the start node and marks them as "used". On the
// second pass through the entire edges array, it finds all nodes 2 hops from
// the
// start node. And each pass through the edges array, it expands out another hop
// from the start node.