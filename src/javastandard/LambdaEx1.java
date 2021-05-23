package javastandard;

public class LambdaEx1 {
    interface MyFunction{
        void run();
    }

    static void execute(MyFunction function) {
        function.run();
    }
    static MyFunction getFunction(){
        MyFunction f = () -> System.out.println("f3.fun()");
        return f;
    }
    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");
        MyFunction f2 =new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };
        MyFunction f3 = getFunction();

        f1.run();
        f2.run();
        f3.run();
        execute(f1);
        execute(()-> System.out.println("run()"));
    }
}
