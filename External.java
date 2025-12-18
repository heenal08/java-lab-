package SEE;

import CIE.Personal;

public class External extends Personal {
    public int[] seeMarks;

    public External(String usn, String name, int sem) {
        super(usn, name, sem);
        seeMarks = new int[5];
    }

    public void setSEE(int[] marks) {
        for (int i = 0; i < 5; i++) {
            seeMarks[i] = marks[i];
        }
    }
}
