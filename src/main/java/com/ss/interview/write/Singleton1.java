package com.ss.interview.write;

/**
 * @author Senn
 * @create 2022/3/21 20:58
 */
public class Singleton1 {

    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance2();
        Singleton1 instance2 = Singleton1.getInstance2();
        System.out.println(instance1 == instance2);
        System.out.println(instance1 == null);

    }

    private static final Singleton1 SINGLETON_1 = new Singleton1();

    public static Singleton1 getInstance() {
        return SINGLETON_1;
    }

    public static Singleton1 getInstance1() {
        return Holder.INSTANCE.singleton1;
    }

    public static Singleton1 getInstance2() {
        return INSTANCE.singleton1;
    }

    enum Holder {
        INSTANCE;
        Singleton1 singleton1;

        Holder() {
            this.singleton1 = new Singleton1();
        }
    }

    private static class INSTANCE{
        private static final Singleton1 singleton1 = new Singleton1();
    }
}
