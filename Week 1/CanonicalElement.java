/**
 * Every element is its own set in the beginning. 
 * When connecting 2 elements, put the bigger element as root.
 * At the end, the root of the one, final component is the biggest number
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CanonicalElement {
    
    private int[] id;
    private int count;          // Number of components

    // Need this constructor for instance in main
    public CanonicalElement(int n) {
    }

    // Initialize an empty union-find data structure with n elements
    public void findLargest(int n) {
        // Each element is its own set so n is also the number of components in the beginning
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

    public static void main(String[] args) {
        int n = StdIn.readInt();
        CanonicalElement uf = new CanonicalElement(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q))
                continue;
            uf.union(p, q);
        }

        // Print out the largest element which is the root
        StdOut.println(uf.find(n));
    }
}
