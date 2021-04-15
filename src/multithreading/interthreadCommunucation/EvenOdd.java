package multithreading.interthreadCommunucation;

public class EvenOdd {
    public static void main(String[] args) {
        Data d = new Data();
        new EvenThread(d);
        new OddThread(d);
    }
}

class Data {
    boolean isEven = true;
    int i = 0;
    int j = 1;

    public synchronized void setBoolean(boolean isEven) {
        this.isEven = isEven;
    }

    public synchronized boolean isEvenTurn() {
        return isEven;
    }

    public synchronized void evenPrint() {
        if (!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(i);
        i = i + 2;
        this.isEven = false;
        if (i <= 10) {
            notify();
        } else {
            System.exit(0);
        }

    }

    public synchronized void oddPrint() {
        if (isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(j);
        j = j + 2;
        this.isEven = true;
        if (j <= 100) {
            notify();
        } else {
            System.exit(0);
        }
    }
}

class EvenThread implements Runnable {
    Thread t;
    int i = 0;
    Data d;

    public EvenThread(Data d) {
        this.d = d;
        t = new Thread(this, "Even");
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            d.evenPrint();
        }
    }
}

class OddThread implements Runnable {
    Data d;
    Thread t;
    int i = 1;

    public OddThread(Data d) {
        t = new Thread(this, "OddThread");
        this.d = d;
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            d.oddPrint();
        }

    }
}
