// To compile, javac -cp ".lift/algs4.jar" RandomWord.java
// Execute wtih algs4.jar in the same directory as RandomWord.java
// java -cp "./algs.jar" RandomWord.java
// Get-Content animals8.txt | java -cp "./algs4.jar" RandomWord.java

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int counter = 0;
        String champion = "";
        
        while (!StdIn.isEmpty()) {
            String current = StdIn.readString();
            counter++;

            if (StdRandom.bernoulli((double) 1 / counter)) {
                champion = current;
            }
        }
        StdOut.println(champion);
    }   
}
