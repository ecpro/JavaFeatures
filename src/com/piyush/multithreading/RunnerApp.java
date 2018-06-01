package com.piyush.multithreading;

public class RunnerApp {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Runner1 implements Runnable {

    public void runner() {
        for(int i = 0; i < 100; i++) {
            System.out.println("RUNNER 1 " + i);
        }
    }

    @Override
    public void run() {
        runner();
    }
}

class Runner2 implements Runnable {

    public void runner() {
        for(int i  = 0; i < 100; i++) {
            System.out.println("RUNNER 2 " + i);
        }
    }

    @Override
    public void run() {
        runner();
    }
}