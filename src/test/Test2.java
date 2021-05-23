package test;

public class Test2 {
    interface MyFunction{
        public abstract int max(int a, int b);
    }
    public static void main(String[] args) {
        MyFunction f1 = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a >= b ? a : b;
            }
        };

        MyFunction f2 = (int a, int b) -> a > b ? a : b;
        int big1 = f1.max(1, 5);
        int big2 = f2.max(1, 5);

        System.out.println("big1 = " + big1);
        System.out.println("big2 = " + big2);


    }
}
