// Could just use the previous problem as a package.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Successor {
    private int[] id;
    private int count;          
    private int integers;
    private boolean[] removed;

    // No element is removed in the beginning
    public Successor(int n) {
        integers = n;
        removed = new boolean[n];
        for (int i=0; i<n; i++) {
            removed[i] = false;
        }
    }

    public void findLargest(int n) {
        count = n;
        id = new int[n];
        for (int i=0; i<n; i++) {
            id[i] = i;
        }
    }
    
    // Return the number of sets
    public int count() {
        return count;
    }

    // Find the root
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    // Check if the two elements are in the same set
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j)
            return;
        
        // If root j is bigger, it becomes i's root
        else if (i < j)
            id[i] = j;
        
        else 
            id[j] = i;
        
        // One less set to union
        count--;
    }

    public void remove(int x) {

        // When x is removed, if element next to it is also removed, union the them
        removed[x] = true;
        if (x > 0 && removed[x-1]) {
            union(x, x-1);
        }
        else if (x < integers && removed[x+1]) {
            union(x, x+1);
        }
    }

    public int successor(int x) {
        
        // Check if x is in the array
        if (x > integers-1) {
            StdOut.println("Element out of bound");
        }
        
        // If x is removed
        if (removed[x]) {
            // and the element greater than x has been removed
            if(find(x)+1 > integers-1) {
                StdOut.println("x and the element greater than x have all been removed");
                return -1;
            }
            // Return successor
            else {
                return find(x) + 1;
            }
        }
        
        // x is not removed; return itself
        else {
            return x;
        }
    }

    public static void main(String[] args) {
        // From previous problem to union components into one
        int n = StdIn.readInt();
        CanonicalElement uf = new CanonicalElement(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q))
                continue;
            uf.union(p, q);
        }

        Successor successor = new Successor(10);
        successor.remove(5);
        StdOut.println(successor.successor(5));
    }
}

