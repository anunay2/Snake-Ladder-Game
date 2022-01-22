package model;

import java.util.List;

public class Board {
    int size;
    List<Snake> snakeList;
    List<Ladder> ladderList;

    public Board(int boardSize) {
        this.size = boardSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List< Snake > getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(List< Snake > snakeList) {
        this.snakeList = snakeList;
    }

    public List< Ladder > getLadderList() {
        return ladderList;
    }

    public void setLadderList(List< Ladder > ladderList) {
        this.ladderList = ladderList;
    }
}
