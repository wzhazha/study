package org.example.mode.singleton;

//懒汉式单例模式
public class LazySingleton {
  private static LazySingleton instance;

  private LazySingleton() {
    // 私有构造函数
  }

  public static synchronized LazySingleton getInstance() {
    if (instance == null) {
      instance = new LazySingleton();
    }
    return instance;
  }
}