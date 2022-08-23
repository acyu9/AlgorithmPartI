import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class SocialNetworkConnectivity {
    public static void main(String[] args) {
        
        // Initializes an empty union-find data structure with n elements 0 through n-1.
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);

        // Timestamp format is date time

        while (!StdIn.isEmpty()) {
            // Use Std because reading from a log file
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            String date = StdIn.readString();
            String time = StdIn.readString();

            // Check if their roots are equal. 
            if (uf.find(p) != uf.find(q)) {
                //If not, update smaller tree's root to bigger tree's
                uf.union(p, q);
            }
            
            // When all components are connected, there is 1 component/count
            if (uf.count() == 1) {
                StdOut.println(date + "" + time);
            }

            // Alternatively, could check uf.size = N for all connections made
        }
    }
}

// This is m log n because the algorithm needs to go through every timestamp, m
// Every union "cuts" the work in half so it's log n (like CS50's phonebook example)