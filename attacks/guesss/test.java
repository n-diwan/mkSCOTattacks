package attacks.guesss;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        int numTrials = 500; // Change this to the desired number of trials
        int m = 5;
        int k = 2;

        Sequence givenSequence = generateValidSequence(m, k);
        System.out.println("Given Sequence: " + givenSequence.toString());

        int successfulGuesses = runSimulation(numTrials, givenSequence, m, k);
        double probability = (double) successfulGuesses / numTrials;

        System.out.println("Probability of passing the test: " + probability);
    }

    public static Sequence generateValidSequence(int m, int k) {
        int[][] sequence = generateRandomSequence(m, k);

        return new Sequence(sequence);
    }

    public static int[][] generateRandomSequence(int m, int k) {
        int[][] sequence = new int[m][k]; // make sure each sequence has no repeat numbers

        for (int j = 0; j < k; j++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int value;
                do {
                    value = (int) (Math.random() * m) + 1;
                } while (temp.contains(value));
                temp.add(value);
                sequence[i][j] = value;
            }
        }

        return sequence;
    }

    public static boolean compareArrays(int index, int number, int[] check) {
        for (int i = 0; i < index; i++) {
            if (check[index] == check[i]) {
                return false;
            }
        }
        return true;
    }

    public static int runSimulation(int numTrials, Sequence givenSequence, int m, int k) {
        int successfulGuesses = 0;

        for (int trial = 0; trial < numTrials; trial++) {
            Sequence testSequence = generateValidSequence(m, k);

            boolean pass = givenSequence.pass(testSequence);

            System.out.println("Test: " + testSequence.toString() +
                    " - Given: " + givenSequence.toString() +
                    " - Pass: " + (pass ? "Y" : "N"));

            if (pass) {
                successfulGuesses++;
            }
        }

        return successfulGuesses;
    }
}
