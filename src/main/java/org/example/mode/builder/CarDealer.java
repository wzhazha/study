package org.example.mode.builder;

// 指导者类 - 汽车销售商
public class CarDealer {
  /**
   * 构建豪华汽车
   * @return 构建完成的豪华汽车对象
   */
  public Car buildLuxuryCar() {
    CarBuilder builder = new LuxuryCarBuilder();
    builder.setColor("Red");
    builder.setYear(2023);
    return builder.getResult();
  }

  /**
   * 构建经济型汽车
   * @return 构建完成的经济型汽车对象
   */
  public Car buildEconomyCar() {
    CarBuilder builder = new EconomyCarBuilder();
    builder.setColor("Blue");
    builder.setYear(2023);
    return builder.getResult();
  }
}
