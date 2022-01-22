package model;

public class Ladder implements Props {
    int startPosition;
    int endPosition;

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public Ladder(int ladderStart, int ladderEnd) {
        this.startPosition = ladderStart;
        this.endPosition = ladderEnd;
    }
}
