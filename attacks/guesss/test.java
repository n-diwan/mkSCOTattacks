package attacks.guesss;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        int numTrials = 500; // Change this to the desired number of trials
        int m = 7;
        int k = 2;

        Sequence givenSequence = generateValidSequence(m, k);
        System.out.println("Given Sequence: " + givenSequence.toString());

        int successfulGuesses = runSimulation(numTrials, givenSequence, m, k);
        double probability = (double) successfulGuesses / numTrials;

        System.out.println("Probability of passing the test: " + probability);
    }

    public static Sequence generateValidSequence(int m, int k) {
        int[] sequence = generateRandomSequence(m * k, m);
        return new Sequence(m, k, sequence);
    }

    public static int[] generateRandomSequence(int length, int maxValue) {
        int[] sequence = new int[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int num = rand.nextInt(maxValue) + 1;
            sequence[i] = num;
        }

        return sequence;
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
