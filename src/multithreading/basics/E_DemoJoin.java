package multithreading.basics;

/*
 * Two ways exist to determine whether a thread has finished. First, you can call isAlive( ) on the thread.
 * This method is defined by Thread, and its general form is
 *
 * shown here: final boolean isAlive( )
 *
 * The isAlive( ) method returns true if the thread upon which it is called is still running. It returns false otherwise.
 * While isAlive( ) is occasionally useful, the method that you will more commonly use to wait for a thread to finish is called join( ),
 *
 * shown here: final void join( ) throws InterruptedException
 *
 * This method waits until the thread on which it is called terminates.
 * Its name comes from the concept of the calling thread waiting until the specified thread joins it.
 * Additional forms of join( ) allow you to specify a maximum amount of time that you want to wait for the specified thread to terminate.
 * */


public class E_DemoJoin {
    public static void main(String[] args) {
        NewThread2 obj1 = new NewThread2("first");
        NewThread2 obj2 = new NewThread2("second");
        NewThread2 obj3 = new NewThread2("third");

        System.out.println("Thread One is alive: " + obj1.t.isAlive());
        System.out.println("Thread Two is alive: " + obj2.t.isAlive());
        System.out.println("Thread Three is alive: " + obj3.t.isAlive());

        try {       // wait for other threads to end -- here waiting by join()
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
            System.out.println("Thread One is alive: " + obj1.t.isAlive());
            System.out.println("Thread Two is alive: " + obj2.t.isAlive());
            System.out.println("Thread Three is alive: " + obj3.t.isAlive());

            Thread.sleep(1000); //sleep main thread to analyse
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}
