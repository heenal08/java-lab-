import java.io.*;

// -------- IPC PART --------
class Sender extends Thread {
    PipedWriter pw;

    Sender(PipedWriter pw) {
        this.pw = pw;
    }

    public void run() {
        try {
            pw.write("IPC Demonstration using Pipes");
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class Receiver extends Thread {
    PipedReader pr;

    Receiver(PipedReader pr) {
        this.pr = pr;
    }

    public void run() {
        try {
            int ch;
            System.out.print("IPC Output: ");
            while ((ch = pr.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
            pr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

// -------- DEADLOCK PART --------
class Deadlock {

    static Object resource1 = new Object();
    static Object resource2 = new Object();

    static void createDeadlock() {

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1 locked Resource 1");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource2) {
                    System.out.println("Thread 1 locked Resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2 locked Resource 2");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource1) {
                    System.out.println("Thread 2 locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

// -------- MAIN CLASS --------
public class IPCDeadlockDemo {

    public static void main(String[] args) throws IOException {

        // IPC Demonstration
        PipedWriter pw = new PipedWriter();
        PipedReader pr = new PipedReader(pw);

        Sender s = new Sender(pw);
        Receiver r = new Receiver(pr);

        s.start();
        r.start();

        // Deadlock Demonstration
        Deadlock.createDeadlock();
    }
}
