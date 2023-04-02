package cn.toby;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // 常规方式创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("create thread in normal way");
            }
        }).start();

        // Lambda 方式创建线程
        new Thread(()-> System.out.println("create thread by lambda")).start();


    }
}