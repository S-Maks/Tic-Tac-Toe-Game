package game.simple;

import game.Game;
import game.validation.InputData;

import java.util.Random;

public class SinglePlayerGame extends Game {
    public SinglePlayerGame() {
    }

    @Override
    protected void NamePlayers() {
        System.out.print("\tEnter player name: ");
        setNamePlayer(InputData.InputString());
    }

    @Override
    public void Start() {
        NamePlayers();
        initializingList();
        while (Moves < 9) {
            PlayerTurn(getNamePlayer());
            if (Winner()) {
                view();
                System.out.println("\t\tYou won!");
                break;
            }
            PlayerComputer();
            if (Winner()) {

                view();
                System.out.println("\t\tThe computer won!");
                break;
            }
        }
        Moves = 0;
    }

    protected void PlayerComputer() {
        if (Moves < 9) {
            System.out.println("The computer is running...");
            if (AlgorithmsWin()) {
                if (AlgorithmsUnWin()) {
                    while (true) {
                        Random rand = new Random();
                        int x;
                        int y;
                        x = rand.nextInt(3);
                        y = rand.nextInt(3);
                        if (Grid.get(x).get(y) == '.') {
                            Grid.get(x).set(y, 'o');
                            break;
                        }

                    }
                }
            }


            Moves++;
        } else {
            System.out.println("\t\tThe moves are over!");
            System.out.println("\t\t\tTie!");

        }
    }

    protected boolean AlgorithmsWin() {
        int size = 3;
        /*Checking the main diagonal*/
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(i).get(j) == '.' && Grid.get(i + 2).get(j + 2) == 'o' && Grid.get(i + 1).get(j + 1) == 'o') {//checking the empty first element

                    Grid.get(i).set(j, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'o' && Grid.get(i + 1).get(j + 1) == '.' && Grid.get(i + 2).get(j + 2) == 'o') {//checking the empty second element
                    Grid.get(i + 1).set(j + 1, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'o' && Grid.get(i + 1).get(j + 1) == 'o' && Grid.get(i + 2).get(j + 2) == '.') {//checking the empty third element
                    Grid.get(i + 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Checking the side diagonal*/

        for (int i = size - 1; i > 1; i--) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(i).get(j) == '.' && Grid.get(i - 1).get(j + 1) == 'o' && Grid.get(i - 2).get(j + 2) == 'o') {//checking the empty first element
                    Grid.get(i).set(j, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'o' && Grid.get(i - 1).get(j + 1) == '.' && Grid.get(i - 2).get(j + 2) == 'o') {//checking the empty second element
                    Grid.get(i - 1).set(j + 1, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'o' && Grid.get(i - 1).get(j + 1) == 'o' && Grid.get(i - 2).get(j + 2) == '.') {//checking the empty third element
                    Grid.get(i - 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Check the line*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(i).get(j) == '.' && Grid.get(i).get(j + 1) == 'o' && Grid.get(i).get(j + 2) == 'o') {//checking the empty first element
                    return false;
                }
                if (Grid.get(i).get(j) == 'o' && Grid.get(i).get(j + 1) == '.' && Grid.get(i).get(j + 2) == 'o') {//checking the empty second element

                    Grid.get(i).set(j + 1, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'o' && Grid.get(i).get(j + 1) == 'o' && Grid.get(i).get(j + 2) == '.') {//checking the empty third element
                    Grid.get(i).set(j + 2, 'o');
                    return false;
                }
            }
        }

        /*Checking columns*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(j).get(i) == '.' && Grid.get(j + 1).get(i) == 'o' && Grid.get(j + 2).get(i) == 'o') {//checking the empty first element
                    Grid.get(j).set(i, 'o');
                    return false;
                }
                if (Grid.get(j).get(i) == 'o' && Grid.get(j + 1).get(i) == '.' && Grid.get(j + 2).get(i) == 'o') {//checking the empty second element

                    Grid.get(j + 1).set(i, 'o');
                    return false;
                }
                if (Grid.get(j).get(i) == 'o' && Grid.get(j + 1).get(i) == 'o' && Grid.get(j + 2).get(i) == '.') {//checking the empty third element
                    Grid.get(j + 2).set(i, 'o');
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean AlgorithmsUnWin() {
        int size = 3;
        /*Checking the main diagonal*/
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(i).get(j) == '.' && Grid.get(i + 1).get(j + 1) == 'x' && Grid.get(i + 2).get(j + 2) == 'x') {//checking the empty first element
                    Grid.get(i).set(j, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'x' && Grid.get(i + 1).get(j + 1) == '.' && Grid.get(i + 2).get(j + 2) == 'x') {//checking the empty second element
                    Grid.get(i + 1).set(j + 1, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'x' && Grid.get(i + 1).get(j + 1) == 'x' && Grid.get(i + 2).get(j + 2) == '.') {//checking the empty third element
                    Grid.get(i + 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Checking the side diagonal*/

        for (int i = size - 1; i > 1; i--) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(i).get(j) == '.' && Grid.get(i - 1).get(j + 1) == 'x' && Grid.get(i - 2).get(j + 2) == 'x') {//checking the empty first element
                    Grid.get(i).set(j, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'x' && Grid.get(i - 1).get(j + 1) == '.' && Grid.get(i - 2).get(j + 2) == 'x') {//checking the empty second element
                    Grid.get(i - 1).set(j + 1, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'x' && Grid.get(i - 1).get(j + 1) == 'x' && Grid.get(i - 2).get(j + 2) == '.') {//checking the empty third element
                    Grid.get(i - 2).set(j + 2, 'o');
                    return false;
                }
            }
        }
        /*Check the line*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(i).get(j) == '.' && Grid.get(i).get(j + 1) == 'x' && Grid.get(i).get(j + 2) == 'x') {//checking the empty first element

                    Grid.get(i).set(j, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'x' && Grid.get(i).get(j + 1) == '.' && Grid.get(i).get(j + 2) == 'x') {//checking the empty second element
                    Grid.get(i).set(j + 1, 'o');
                    return false;
                }
                if (Grid.get(i).get(j) == 'x' && Grid.get(i).get(j + 1) == 'x' && Grid.get(i).get(j + 2) == '.') {//checking the empty third element
                    Grid.get(i).set(j + 2, 'o');
                    return false;
                }

            }
        }

        /*Checking columns*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 2; j++) {
                if (Grid.get(j).get(i) == '.' && Grid.get(j + 1).get(i) == 'x' && Grid.get(j + 2).get(i) == 'x') {//checking the empty first element
                    Grid.get(j).set(i, 'o');
                    return false;
                }
                if (Grid.get(j).get(i) == 'x' && Grid.get(j + 1).get(i) == '.' && Grid.get(j + 2).get(i) == 'x') {//checking the empty second element
                    Grid.get(j + 1).set(i, 'o');
                    return false;
                }
                if (Grid.get(j).get(i) == 'x' && Grid.get(j + 1).get(i) == 'x' && Grid.get(j + 2).get(i) == '.') {//checking the empty third element

                    Grid.get(j + 2).set(i, 'o');
                    return false;
                }
            }
        }
        return true;
    }
}
