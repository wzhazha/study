package org.example.mode.state;

public class EmptyState implements RoomState{
    private final Room room;

    public EmptyState(Room room) {
        this.room = room;
    }

    public void checkin() {
        System.out.println("Room " + room.getRoomNumber() + " has been occupied.");
        room.setRoomState(room.getOccupiedState());
    }

    public void checkout() {
        System.out.println("Room " + room.getRoomNumber() + " is already empty.");
    }

    public void clean() {
        System.out.println("Room " + room.getRoomNumber() + " is already clean.");
    }

    public String toString() {
        return "Empty";
    }
}
