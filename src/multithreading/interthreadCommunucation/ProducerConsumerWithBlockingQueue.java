package multithreading.interthreadCommunucation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerWithBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<>(4);

        ConsumerGuy consumer = new ConsumerGuy(bqueue);

        ProducerGuy producer = new ProducerGuy(bqueue);

        Thread cThread = new Thread(consumer);

        Thread pThread = new Thread(producer);

        pThread.start();
        cThread.start();
    }
}

class ConsumerGuy implements Runnable {

    BlockingQueue<Integer> bqueue;
    int taken = -1;
    public ConsumerGuy(BlockingQueue<Integer> bqueue) {
        this.bqueue = bqueue;
    }

    @Override
    public void run() {
        while (taken != 4) {
            try {
                taken = bqueue.take();
                System.out.println("Consumed : " + taken);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ProducerGuy implements Runnable {
    BlockingQueue<Integer> bqueue;

    public ProducerGuy(BlockingQueue<Integer> bqueue) {
        this.bqueue = bqueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            try {
                bqueue.put(i);
                System.out.println("Produced : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}