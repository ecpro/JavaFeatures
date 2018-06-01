package com.piyush.multithreading;

public class DeadlockExample {

    public static void main(String[] args) throws Exception {

        B b = new B();
        A a = new A();
        b.setA(a);
        a.setB(b);

        Runnable rA = () -> {a.a1();};
        Runnable rB = () -> {b.b1();};

        Thread t1 = new Thread(rA);
        Thread t2 = new Thread(rB);

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}

class A {

    private B b;

    public synchronized void a1(){
        System.out.println("Method a1 of A has been called");
        b.b1();
        System.out.println("Method b1 of B has been called from a1"); // code will never reach here because of deadlock
    }

    public void setB(B b) {
        this.b = b;
    }
}

class B {

    private A a;

    public synchronized void b1() {
        System.out.println("Method b1 of B has been called");
        a.a1();
        System.out.println("Method a1 of A has been called from b1"); // code will never reach here because of deadlock
    }

    public void setA(A a) {
        this.a = a;
    }

}


