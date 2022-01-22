package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Die {
    private List< Integer > numbersOnDie;
    private int currentNumber;

    public List< Integer > getNumbersOnDie() {
        return numbersOnDie;
    }

    public void setNumbersOnDie(List< Integer > numbersOnDie) {
        this.numbersOnDie = numbersOnDie;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Die(int dieMax) {
        this.currentNumber = 0;
        this.numbersOnDie = new ArrayList<>();
        for(int i=1; i <= dieMax; i++){
            numbersOnDie.add(Integer.valueOf(i));
        }
    }

    public int roll() {
        Random random = new Random();
        int randIndex = random.nextInt(numbersOnDie.size());
        currentNumber = numbersOnDie.get(randIndex).intValue();
        return currentNumber;
    }
}
