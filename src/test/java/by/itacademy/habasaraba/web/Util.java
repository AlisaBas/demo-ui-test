package by.itacademy.habasaraba.web;

public class Util {
    public static void waitThreadFor(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
