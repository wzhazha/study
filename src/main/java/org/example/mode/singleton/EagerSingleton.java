package org.example.mode.singleton;

//饿汉式单例模式
public class EagerSingleton {
  private static final EagerSingleton instance = new EagerSingleton();

  private EagerSingleton() {
    // 私有构造函数
  }

  public static EagerSingleton getInstance() {
    return instance;
  }
}
