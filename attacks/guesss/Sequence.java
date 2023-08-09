package attacks.guesss;

public class Sequence {
    public int[] SequenceList;
    public int m;
    public int k;

    public Sequence(int m, int k, int[] SequenceList) {
        this.m = m;
        this.k = k;
        this.SequenceList = SequenceList;
    }

    public int getValue(int i) {
        return SequenceList[i];
    }

    public boolean pass(Sequence other) {
        boolean[] result = new boolean[m];
        boolean[] dummyTest = new boolean[k];

        for (int j = 0; j < m; j++) {
            for (int i = j; i < SequenceList.length; i += m) {
                if (other.getValue(i) == this.getValue(i)) {
                    dummyTest[i / m] = true;
                }
            }
            boolean test = false;
            for (boolean dummy : dummyTest) {
                if (dummy) {
                    test = true;
                    break;
                }
            }
            result[j] = test;
        }

        boolean pass = true;
        for (boolean res : result) {
            if (!res) {
                pass = false;
                break;
            }
        }
        return pass;
    }

    private String helpertoString(int p) {
        StringBuilder s = new StringBuilder();
        for (int i = p * m; i < m * (p + 1) - 1; i++) {
            s.append(SequenceList[i]).append(", ");
        }
        s.append(SequenceList[m * (p + 1) - 1]);
        return s.toString();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            s.append("[").append(helpertoString(i)).append("] ");
        }
        s.append("[").append(helpertoString(k - 1)).append("]");
        return s.toString();
    }
}
