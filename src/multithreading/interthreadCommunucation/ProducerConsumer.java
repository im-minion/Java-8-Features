package multithreading.interthreadCommunucation;

/*
 * Java includes an elegant interprocess communication mechanism via the wait( ), notify( ), and notifyAll( ) methods
 * These methods are implemented as final methods in Object, so all classes have them.
 * All three methods can be called only from within a synchronized context.
 * wait( )      - tells the calling thread to give up the monitor and go to sleep until \
 *                 some other thread enters the same monitor and calls notify( ) or notifyAll( ).
 * notify( )    - wakes up a thread that called wait( ) on the same object.
 * notifyAll( ) - wakes up all the threads that called wait( ) on the same object. One of the threads will be granted access.
 *
 * These methods are declared within Object,
 * as shown here:   final void wait( ) throws InterruptedException
 *                  final void notify( )
 *                  final void notify All( )
 *
 * */
public class ProducerConsumer {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}

class Q {
    int n;
    boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) { // until value is not set we need to wait
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) { // wait if value is already set
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }

}

class Producer implements Runnable {
    Thread t;
    Q q;

    public Producer(Q q) {
        this.q = q;
        t = new Thread(this, "producerThread");
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Thread t;
    Q q;

    public Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "consumerThread");
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}