package org.example.mode.state;

public class CleaningState implements RoomState{
    private final Room room;

    public CleaningState(Room room) {
        this.room = room;
    }

    public void checkin() {
        System.out.println("Room " + room.getRoomNumber() + " is currently being cleaned.");
    }

    public void checkout() {
        System.out.println("Room " + room.getRoomNumber() + " cannot be checked out while cleaning.");
    }

    public void clean() {
        System.out.println("Room " + room.getRoomNumber() + " has been cleaned.");
        room.setRoomState(room.getEmptyState());
    }

    public String toString() {
        return "Cleaning";
    }
}
