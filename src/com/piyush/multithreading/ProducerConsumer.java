package com.piyush.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

    private Queue<Integer> queue = new LinkedList<>();
    private int LIMIT = 10;
    private Random random = new Random();

    public void produce() throws InterruptedException {
        synchronized (this) {
            while(true) {
                if(queue.size() == LIMIT) {
                    System.out.println("Waiting for consumer to consume... " );
                    wait();
                }
                else {
                    queue.add(random.nextInt(11));
                    notify();
                }
                Thread.sleep(300);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if(queue.isEmpty()) {
                    System.out.println("Waiting for producer to produce... ");
                    wait();
                }
                else {
                    System.out.println("removed " + queue.remove());
                    notify();
                }
                Thread.sleep(300);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        ProducerConsumer pc = new ProducerConsumer();

        System.out.println("To stop the application enter any key....");

        Thread.sleep(200);



        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // to stop this producer consumer program
        t2.setDaemon(true);
        t1.setDaemon(true);

        t1.start();
        t2.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        System.out.println("Bye Bye");


    }

}


