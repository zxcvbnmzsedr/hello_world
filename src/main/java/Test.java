public class Test {
    int a = 1;
    int b = 2;

    public void print() {
        int c = a + b;
        System.out.println("hello world");
        System.out.print("result: ");
        System.out.println(c);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.print();
    }
}
