package org.example.mode.builder;

/**
 * 建造者模式
 * 建造者模式的主要目的是将复杂对象的构建过程抽象出来，
 * 使得客户端可以灵活地配置和构建对象，同时隐藏了对象的构建细节。
 * 这种模式有助于降低构建过程的复杂性，提供了更好的可读性和可维护性。
 * 实际没用过
 */
public class ClientMain {
  public static void main(String[] args) {
    // 构建豪华汽车
    CarDealer dealer = new CarDealer();
    Car luxuryCar = dealer.buildLuxuryCar();
    System.out.println("Luxury Car: " + luxuryCar.getBrand() + " " + luxuryCar.getModel() + " " +
        luxuryCar.getColor() + " " + luxuryCar.getYear());
    // 构建豪华汽车
    Car economyCar = dealer.buildEconomyCar();
    System.out.println("Economy Car: " + economyCar.getBrand() + " " + economyCar.getModel() + " " +
        economyCar.getColor() + " " + economyCar.getYear());
  }
}
