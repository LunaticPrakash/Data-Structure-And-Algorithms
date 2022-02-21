class Counter {
    int count = 0;

    public synchronized void increment() {

        count++;
        // synchronized(this){
        // count++;
        // }
    }
}

public class synchronized_example {
    public static void main(String[] args) throws InterruptedException{

        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)  //c = 1005  ; c = 1006

                    c.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {  //c = 1000 ; c = 1005

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    c.increment();
            }
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}
