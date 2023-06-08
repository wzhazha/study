package org.example.mode.singleton;

/**
 *单例模式
 * 懒汉式
 * 在懒汉式中，单例对象的实例在第一次使用时才会被创建。
 * 线程安全是通过使用synchronized关键字来实现的，确保在多线程环境下只有一个线程能够创建实例。
 * 饿汉式
 * 在饿汉式中，单例对象的实例在类加载时就会被创建，
 * 因此在任何情况下都能保证单例对象的存在。这种实现方式没有线程安全问题，
 * 但可能会在应用启动时就创建对象，可能造成不必要的资源浪费。
 */
public class SingletonMain {
  public static void main(String[] args) {
    LazySingleton lazySingleton1 = LazySingleton.getInstance();
    LazySingleton lazySingleton2 = LazySingleton.getInstance();
    System.out.println("懒汉式创建的第一个对象：" + lazySingleton1);
    System.out.println("懒汉式创建的第二个对象：" + lazySingleton2);
    System.out.println(lazySingleton1 == lazySingleton2);

    EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
    EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
    System.out.println("饿汉式创建的第一个对象：" + eagerSingleton1);
    System.out.println("饿汉式创建的第二个对象：" + eagerSingleton2);
    System.out.println(eagerSingleton1 == eagerSingleton2);

  }
}
