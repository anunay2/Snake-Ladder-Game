package model;

public class Snake implements  Props{
    int startPosition;

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    int endPosition;

    public Snake(int snakeStart, int snakeEnd) {
        this.startPosition = snakeStart;
        this.endPosition = snakeEnd;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}
