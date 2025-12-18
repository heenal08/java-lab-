package CIE;

public class Internals {
    public int[] internalMarks;

    public Internals() {
        internalMarks = new int[5];
    }

    public void setInternals(int[] marks) {
        for (int i = 0; i < 5; i++) {
            internalMarks[i] = marks[i];
        }
    }
}
