package org.example.mode.state;

public class Room {
    private final int roomNumber;
    private final RoomState emptyState;
    private final RoomState cleaningState;
    private final RoomState occupiedState;

    private RoomState roomState;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        emptyState = new EmptyState(this);
        cleaningState = new CleaningState(this);
        occupiedState = new OccupiedState(this);

        roomState = emptyState;
    }

    public void checkIn() {
        roomState.checkin();
    }

    public void checkOut() {
        roomState.checkout();
    }

    public void clean() {
        roomState.clean();
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomState getEmptyState() {
        return emptyState;
    }

    public RoomState getCleaningState() {
        return cleaningState;
    }

    public RoomState getOccupiedState() {
        return occupiedState;
    }

    public String toString() {
        return "Room " + roomNumber + " is " + roomState.toString();
    }
}
