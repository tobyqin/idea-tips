package cn.toby;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {
        String[] arr = {"apple", "box", "cat", "dog"};
//
//        // 通过 Collection 创建
//        Arrays.stream(arr).forEach(System.out::println);
//
//        // 通过 Arrays 创建
//        Arrays.asList(arr).stream().forEach(System.out::println);
//
//        // 通过 Stream 类中的 of 静态方法创建
//        Stream.of(arr).forEach(System.out::println);
//
//        // 通过迭代创建
//        Stream.iterate(1, i-> i+1).limit(10).forEach(System.out::println);
//
//        // 通过生成创建
//        Stream.generate(()->new Random().nextInt(100)).limit(5).forEach(System.out::println);

        Stream.of(arr).filter(i-> i.contains("o"))
                .limit(1)
                .flatMap(i-> Stream.of(i.split("")))
                .sorted(Comparator.reverseOrder())
                .map(i-> i.replace('o', '0'))
                .forEach(System.out::print);
    }
}
