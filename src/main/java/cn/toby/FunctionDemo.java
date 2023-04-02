package cn.toby;


import java.util.function.*;

@FunctionalInterface
interface IDemoA {
    void doSomething();
}

public class FunctionDemo {

    void foo(IDemoA demo) {
        System.out.println("from function foo");
        demo.doSomething();
    }

    public static void main(String[] args) {
        var funcDemo = new FunctionDemo();
        funcDemo.foo(() -> System.out.println("do something..."));

        // Supplier 不需要参数，只返回结果
        Supplier<String> supplier = () -> "this is a supplier demo";
        System.out.println(supplier.get());

        // Consumer 只接收一个参数，不返回结果
        Consumer<String> consumer = i -> System.out.println("this is a consumer demo for " + i);
        consumer.accept("hello world");

        // Function 接收一个参数，返回一个结果
        Function<Integer, Integer> function = i -> i * i;
        System.out.println("function demo: " + function.apply(9));

        // BiFunction 接收 2 个参数，返回一个结果
        BiFunction<String, Integer, String> biFunc = (name, age) -> String.format("%s's age is %s.", name, age);
        System.out.println(biFunc.apply("toby", 19));

        // Predicate 接收一个参数，返回一个 bool 值
        Predicate<Integer> isOdd = i -> i % 2 == 0;
        System.out.println(isOdd.test(3));

    }
}
