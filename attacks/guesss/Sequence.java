package attacks.guesss;

public class Sequence {
    public int[][] SequenceList;
    public int m;
    public int k;

    public Sequence(int[][] given) {

        this.SequenceList = given;
        m = given.length;
        k = given[0].length;
    }

    public int getValue(int i, int j) {
        return SequenceList[i][j];
    }

    public boolean pass(Sequence other) {
        boolean[] temp = new boolean[k]; // go through every row to see if there's at least one false
        boolean[] finalCheck = new boolean[m];
        for (int i = 0; i < m; i++) // go through each column
        {

            for (int j = 0; j < k; j++) {
                if (other.getValue(i, j) == this.getValue(i, j)) {
                    temp[j] = true;
                } else {
                    temp[j] = false;
                }
            }
            finalCheck[i] = false;
            for (int j = 0; j < k; j++) {
                if (temp[j] == true) {
                    finalCheck[i] = true;
                }
            }
        }
        boolean finalAnswer = true;
        for (int i = 0; i < m; i++) {
            if (finalCheck[i] == false) {
                finalAnswer = false;
            }
        }
        return finalAnswer;

    }

    private String helpertoString(int k) {
        String s = "[";
        for (int i = 0; i < m - 1; i++) {
            s += SequenceList[i][k] + ", ";
        }
        s += SequenceList[m - 1][k] + "]";
        return s;
    }

    public String toString() {
        String s = "";
        for (int j = 0; j < k; j++) {
            s += helpertoString(j) + ", ";
        }
        return s;
    }
}
