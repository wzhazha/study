package org.example.mode.builder;

// 抽象建造者接口
public interface CarBuilder {
  void setBrand(String brand);
  void setModel(String model);
  void setColor(String color);
  void setYear(int year);
  Car getResult();
}
