class Thread6 extends Thread {
    public void run() {
        System.out.println(this.getId() + " is running.");
        try {
            Thread.sleep(1000);
            System.out.println("Wait finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class _4_Thread_Methods {
    public static void main(String[] args) {
        Thread6 t1 = new Thread6();
        Thread6 t2 = new Thread6();

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
