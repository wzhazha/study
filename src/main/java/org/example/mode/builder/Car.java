package org.example.mode.builder;

// 产品类 - 汽车
public class Car {
  private String brand;
  private String model;
  private String color;
  private int year;

  public Car(String brand, String model, String color, int year) {
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public int getYear() {
    return year;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
