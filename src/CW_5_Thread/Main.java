package CW_5_Thread;

import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new  Thread(consumer).start();
    }
}
