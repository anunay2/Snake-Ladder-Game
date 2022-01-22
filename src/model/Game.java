package model;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
    private Queue<Player> players;
    private Die die;
    private Board board;


    public Game(int numOfPlayers, int numOfLadders, int numOfSnakes, int boardSize, int dieMax) {
        this.die = new Die(dieMax);
        this.board = new Board( boardSize );
        initBoard(numOfLadders, numOfSnakes);
        initPlayers(numOfPlayers);
    }

    private void initPlayers(int numOfPlayers) {
        players = new ArrayDeque<>();
        for(int i = 0; i < numOfPlayers; i++){
            Player player = new Player(i);
            players.add(player);
        }
    }

    private void initBoard(int numOfLadders, int numOfSnakes) {
        Set<String> slSet= new HashSet<>();
        Random random = new Random();
        List<Snake> snakeList = new ArrayList<>();
        List<Ladder> ladderList = new ArrayList<>();
        for(int i = 0; i < numOfSnakes ; i++){
            while(true){
                int snakeStart = random.nextInt(board.getSize()) + 1;
                int snakeEnd = random.nextInt(board.getSize()) + 1;
                if ( snakeEnd >= snakeStart || snakeEnd  == board.getSize()){
                    continue;
                }
                String startEndPair = String.valueOf(snakeStart) + snakeEnd;
                if(!slSet.contains(startEndPair)){
                    Snake snake = new Snake(snakeStart, snakeEnd);
                    snakeList.add(snake);
                    slSet.add(startEndPair);
                    break;
                }

            }
        }

        for(int i = 0; i < numOfLadders; i++){
            while(true){
                int ladderStart = random.nextInt(board.getSize()) + 1;
                int ladderEnd = random.nextInt(board.getSize()) + 1;
                if(ladderEnd <= ladderStart){
                    continue;
                }
                String startEndPair = String.valueOf(ladderStart) + ladderEnd;
                if(!slSet.contains(startEndPair)){
                    Ladder ladder = new Ladder(ladderStart, ladderEnd);
                    ladderList.add(ladder);
                    slSet.add(startEndPair);
                    break;
                }
            }
        }
        board.setLadderList(ladderList);
        board.setSnakeList(snakeList);

    }

    public void playGame() throws InterruptedException {
        while (true){
            TimeUnit.MILLISECONDS.sleep(200);
            Player player = players.poll();
            int val = die.roll();
            int newPosition = player.getPositionOnBoard() + val;
            if( newPosition > board.getSize()){
                players.offer(player);
            }else {
                player.setPositionOnBoard(getNewPosition(newPosition));
                if( player.getPositionOnBoard() == board.getSize() ){
                    player.setCurrentStatus(Status.WON);
                    System.out.println(player + " won");
                }
                else{
                    System.out.println(" Setting " + player + "'s position to " + player.getPositionOnBoard());
                    players.offer(player);
                }
            }
            if ( players.size() < 2  ){
                break;
            }
        }
    }

    private int getNewPosition(int newPosition) {
        for ( Snake snake : board.getSnakeList()) {
            if( snake.getStartPosition() == newPosition){
                System.out.println("Snake Bit");
                return snake.getEndPosition();
            }
        }

        for( Ladder ladder : board.getLadderList()) {
            if( ladder.getStartPosition() == newPosition ){
                System.out.println("Ladder climbed");
                return ladder.getEndPosition();
            }
        }
        return newPosition;
    }


}
