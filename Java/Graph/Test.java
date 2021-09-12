class num {
    static int a = 10;
    int b = 20;

    void display() {
        System.out.println("a = " + a + ", " + "b = " + b);
    }
}

public class Test {
    public static void main(String[] args) {
        num obj1 = new num();
        num obj2 = new num();
        System.out.println("obj1.display() => ");
        obj1.display();
        System.out.println("obj2.display() => ");
        obj2.display();

        obj2.b = 40; // will not change for obj1
        obj2.a = 20; // will change for obj1  btw it should be accessed like num.a = 20;

        System.out.println("obj1.display() => ");
        obj1.display();

        System.out.println("obj2.display() => ");
        obj2.display();
    }
}
