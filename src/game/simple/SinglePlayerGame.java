package game.simple;

import game.Game;
import game.validation.InputData;
import java.util.Random;

public class SinglePlayerGame extends Game {
    public SinglePlayerGame() {
    }

    @Override
    protected void namePlayers() {
        System.out.print("\tEnter player name: ");
        setNamePlayer(InputData.InputString());
    }

    @Override
    public void start() {
        namePlayers();
        initializingList();
        while (moves < 9) {
            playerTurn(getNamePlayer());
            if (toWin()) {
                view();
                System.out.println("\t\tYou won!");
                break;
            }
            playComputer();
            if (toWin()) {
                view();
                System.out.println("\t\tThe computer won!");
                break;
            }
        }
        moves = 0;
    }

    protected void playComputer() {
        if (moves < 9) {
            System.out.println("The computer is running...");
            if (toWinAlgorithms()) {
                if (toUnWinAlgorithms()) {
                    while (true) {
                        Random rand = new Random();
                        int x;
                        int y;
                        x = rand.nextInt(3);
                        y = rand.nextInt(3);
                        if (grid.get(x).get(y) == '.') {
                            grid.get(x).set(y, 'o');
                            break;
                        }
                    }
                }
            }
            moves++;
        } else {
            System.out.println("\t\tThe moves are over!");
            System.out.println("\t\t\tTie!");
        }
    }

    protected boolean toWinAlgorithms() {
        int size = 3;
        /*Checking the main diagonal*/
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(i).get(j) == '.' && grid.get(i + 2).get(j + 2) == 'o' && grid.get(i + 1).get(j + 1) == 'o') {//checking the empty first element
                    grid.get(i).set(j, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'o' && grid.get(i + 1).get(j + 1) == '.' && grid.get(i + 2).get(j + 2) == 'o') {//checking the empty second element
                    grid.get(i + 1).set(j + 1, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'o' && grid.get(i + 1).get(j + 1) == 'o' && grid.get(i + 2).get(j + 2) == '.') {//checking the empty third element
                    grid.get(i + 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Checking the side diagonal*/
        for (int i = size - 1; i > 1; i--) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(i).get(j) == '.' && grid.get(i - 1).get(j + 1) == 'o' && grid.get(i - 2).get(j + 2) == 'o') {//checking the empty first element
                    grid.get(i).set(j, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'o' && grid.get(i - 1).get(j + 1) == '.' && grid.get(i - 2).get(j + 2) == 'o') {//checking the empty second element
                    grid.get(i - 1).set(j + 1, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'o' && grid.get(i - 1).get(j + 1) == 'o' && grid.get(i - 2).get(j + 2) == '.') {//checking the empty third element
                    grid.get(i - 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Check the line*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(i).get(j) == '.' && grid.get(i).get(j + 1) == 'o' && grid.get(i).get(j + 2) == 'o') {//checking the empty first element
                    return false;
                }
                if (grid.get(i).get(j) == 'o' && grid.get(i).get(j + 1) == '.' && grid.get(i).get(j + 2) == 'o') {//checking the empty second element
                    grid.get(i).set(j + 1, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'o' && grid.get(i).get(j + 1) == 'o' && grid.get(i).get(j + 2) == '.') {//checking the empty third element
                    grid.get(i).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Checking columns*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(j).get(i) == '.' && grid.get(j + 1).get(i) == 'o' && grid.get(j + 2).get(i) == 'o') {//checking the empty first element
                    grid.get(j).set(i, 'o');
                    return false;
                }
                if (grid.get(j).get(i) == 'o' && grid.get(j + 1).get(i) == '.' && grid.get(j + 2).get(i) == 'o') {//checking the empty second element
                    grid.get(j + 1).set(i, 'o');
                    return false;
                }
                if (grid.get(j).get(i) == 'o' && grid.get(j + 1).get(i) == 'o' && grid.get(j + 2).get(i) == '.') {//checking the empty third element
                    grid.get(j + 2).set(i, 'o');
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean toUnWinAlgorithms() {
        int size = 3;
        /*Checking the main diagonal*/
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(i).get(j) == '.' && grid.get(i + 1).get(j + 1) == 'x' && grid.get(i + 2).get(j + 2) == 'x') {//checking the empty first element
                    grid.get(i).set(j, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'x' && grid.get(i + 1).get(j + 1) == '.' && grid.get(i + 2).get(j + 2) == 'x') {//checking the empty second element
                    grid.get(i + 1).set(j + 1, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'x' && grid.get(i + 1).get(j + 1) == 'x' && grid.get(i + 2).get(j + 2) == '.') {//checking the empty third element
                    grid.get(i + 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Checking the side diagonal*/
        for (int i = size - 1; i > 1; i--) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(i).get(j) == '.' && grid.get(i - 1).get(j + 1) == 'x' && grid.get(i - 2).get(j + 2) == 'x') {//checking the empty first element
                    grid.get(i).set(j, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'x' && grid.get(i - 1).get(j + 1) == '.' && grid.get(i - 2).get(j + 2) == 'x') {//checking the empty second element
                    grid.get(i - 1).set(j + 1, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'x' && grid.get(i - 1).get(j + 1) == 'x' && grid.get(i - 2).get(j + 2) == '.') {//checking the empty third element
                    grid.get(i - 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Check the line*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(i).get(j) == '.' && grid.get(i).get(j + 1) == 'x' && grid.get(i).get(j + 2) == 'x') {//checking the empty first element
                    grid.get(i).set(j, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'x' && grid.get(i).get(j + 1) == '.' && grid.get(i).get(j + 2) == 'x') {//checking the empty second element
                    grid.get(i).set(j + 1, 'o');
                    return false;
                }
                if (grid.get(i).get(j) == 'x' && grid.get(i).get(j + 1) == 'x' && grid.get(i).get(j + 2) == '.') {//checking the empty third element
                    grid.get(i).set(j + 2, 'o');
                    return false;
                }

            }
        }
        /*Checking columns*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (grid.get(j).get(i) == '.' && grid.get(j + 1).get(i) == 'x' && grid.get(j + 2).get(i) == 'x') {//checking the empty first element
                    grid.get(j).set(i, 'o');
                    return false;
                }
                if (grid.get(j).get(i) == 'x' && grid.get(j + 1).get(i) == '.' && grid.get(j + 2).get(i) == 'x') {//checking the empty second element
                    grid.get(j + 1).set(i, 'o');
                    return false;
                }
                if (grid.get(j).get(i) == 'x' && grid.get(j + 1).get(i) == 'x' && grid.get(j + 2).get(i) == '.') {//checking the empty third element
                    grid.get(j + 2).set(i, 'o');
                    return false;
                }
            }
        }
        return true;
    }
}
