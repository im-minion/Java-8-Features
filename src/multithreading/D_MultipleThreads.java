package multithreading;

public class D_MultipleThreads {
    public static void main(String[] args) {
        new NewThread2("first");
        new NewThread2("second");
        new NewThread2("third");
        try {       // wait for other threads to end -- here jugaad done ---waiting by sleep()
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");

    }
}

class NewThread2 implements Runnable {
    String name;
    Thread t;

    NewThread2(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New Thread : " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(this.name + " " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(this.name + "Interrupted");
        }
        System.out.println(this.name + " exiting.");
    }
}