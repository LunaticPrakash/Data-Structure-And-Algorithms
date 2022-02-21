abstract class Bank {
    public void deposit(int m) {
        System.out.println("Some common logic");
    }

    public void withdraw(int m) {
        System.out.println("Some commn logic");
    }

    public abstract void calROI(int m);

    // wihtout abstract both are right
    // abstract static void f(){
    //     System.out.println();
    // }   wromg

    /// final abstract  static void f(){
        //     System.out.println();
        // }   wromg
}

class Axis extends Bank {
    @Override
    public void calROI(int m) {
        System.out.println("Axis Bank calROI() logic");
    }
}

class Paytm extends Bank {

    @Override
    public void calROI(int m) {
        System.out.println("Paytm Bank calROI() logic");
    }
}

public class abstract_example {

    public static void main(String[] args) {
        Bank axis = new Axis();
        Bank paytm = new Paytm();

        axis.deposit(100);
        paytm.deposit(100);

        axis.calROI(100);
        paytm.calROI(100);
    }
}