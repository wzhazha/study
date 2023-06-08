package org.example.mode.state;
/**
 * 状态模式
 * 状态模式在具有复杂的对象状态转换逻辑的场景下非常有用
 * 例如订单状态、游戏角色状态等。
 * 它提供了一种结构化的方式来管理对象的状态和行为
 * 并且可以使代码更加灵活和可维护。
 */
public class StateMainTest {
    public static void main(String[] args) {
        Room room = new Room(101);//房间号
        room.checkIn();//入住  房间变成有人状态
        room.clean();//入住期间不能打扫
        room.checkOut();//结账退房 房间变为打扫状态
        room.checkIn();//打扫期间不能入住
        room.clean();//打扫 房间变为空闲状态
        room.checkIn();//入住...
    }
}
