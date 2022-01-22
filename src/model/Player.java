package model;

public class Player {
    int userId;
    int positionOnBoard;
    Status currentStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userId=" + userId +
                ", positionOnBoard=" + positionOnBoard +
                ", currentStatus=" + currentStatus +
                '}';
    }

    public Player(int i) {
        this.userId = i;
        this.positionOnBoard = 1;
        this.currentStatus = Status.PROGRESS;
    }
}
