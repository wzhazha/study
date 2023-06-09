package org.example.mode.factory;
/**
 * 工厂模式
 * 工厂模式可以提供一个统一的接口来创建对象,隐藏了对象的创建细节
 * 使得客户端代码更加简洁、灵活和可扩展。
 */
public class FactoryMainTest {
    public static void main(String[] args) {
        // 创建ShapeFactory对象，通过它来创建Shape对象
        ShapeFactory factory = new ShapeFactory();

        // 创建一个Circle对象
        Shape circle = factory.createShape("Circle");
        circle.draw(); // 输出：画了一个圆形

        // 创建一个Square对象
        Shape square = factory.createShape("Square");
        square.draw(); // 输出：画了一个正方形

        // 创建一个Rectangle对象
        Shape rectangle = factory.createShape("Rectangle");
        rectangle.draw(); // 输出：画了一个长方形
    }
}
