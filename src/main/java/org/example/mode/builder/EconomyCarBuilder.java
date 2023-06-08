package org.example.mode.builder;

// 具体建造者 - 经济型汽车建造者
public class EconomyCarBuilder implements CarBuilder{
  private Car car;

  public EconomyCarBuilder() {
    this.car = new Car("Toyota", "Corolla", "White", 2022);
  }

  @Override
  public void setBrand(String brand) {
    // 该建造者固定了品牌，无需设置
  }

  @Override
  public void setModel(String model) {
    // 该建造者固定了型号，无需设置
  }

  @Override
  public void setColor(String color) {
    this.car.setColor(color);
  }

  @Override
  public void setYear(int year) {
    this.car.setYear(year);
  }

  @Override
  public Car getResult() {
    return this.car;
  }
}
