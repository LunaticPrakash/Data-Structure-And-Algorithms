public class _5_Deadlock extends Thread {
    public static void main(String[] args) {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
