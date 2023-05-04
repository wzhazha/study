package org.example.mode.state;

public class OccupiedState implements RoomState{
    private final Room room;

    public OccupiedState(Room room) {
        this.room = room;
    }

    public void checkin() {
        System.out.println("Room " + room.getRoomNumber() + " is already occupied.");
    }

    public void checkout() {
        System.out.println("Room " + room.getRoomNumber() + " has been checked out.");
        room.setRoomState(room.getCleaningState());
    }

    public void clean() {
        System.out.println("Room " + room.getRoomNumber() + " cannot be cleaned while occupied.");
    }

    public String toString() {
        return "Occupied";
    }
}
