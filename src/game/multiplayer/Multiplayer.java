package game.multiplayer;

import game.Game;
import game.validation.InputData;

public class Multiplayer extends Game {
    private String secondPlayerName;

    public Multiplayer() {}

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    @Override
    protected void namePlayers() {
        System.out.print("\tEnter the name of the first player: ");
        setNamePlayer(InputData.InputString());
        System.out.print("\tEnter the name of the second player: ");
        setSecondPlayerName(InputData.InputString());
    }

    @Override
    public void start() {
        namePlayers();
        initializingList();
        while (moves < 9) {
            super.playerTurn(getNamePlayer());
            if (toWin()) {
                view();
                System.out.println("\t\t" + getNamePlayer() + " won!");
                break;
            }
            playerTurn(getSecondPlayerName());
            if (toWin()) {
                view();
                System.out.println("\t\t" + getSecondPlayerName() + " won!");
                break;
            }
        }
        moves = 0;
    }

    @Override
    protected void playerTurn(String name) {
        boolean flag = true;
        System.out.println("\t\t" + name + " walks");
        while (flag) {
            view();
            System.out.print("\tSelect the number where to put the cross:");
            switch (InputData.checkInt()) {
                case 1:
                    if (grid.get(0).get(0) == '.') {
                        grid.get(0).set(0, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 2:
                    if (grid.get(0).get(1) == '.') {
                        grid.get(0).set(1, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 3:
                    if (grid.get(0).get(2) == '.') {
                        grid.get(0).set(2, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 4:
                    if (grid.get(1).get(0) == '.') {
                        grid.get(1).set(0, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 5:
                    if (grid.get(1).get(1) == '.') {
                        grid.get(1).set(1, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 6:
                    if (grid.get(1).get(2) == '.') {
                        grid.get(1).set(2, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 7:
                    if (grid.get(2).get(0) == '.') {
                        grid.get(2).set(0, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 8:
                    if (grid.get(2).get(1) == '.') {
                        grid.get(2).set(1, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 9:
                    if (grid.get(2).get(2) == '.') {
                        grid.get(2).set(2, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                default:
                    System.out.print("Value is taken or not found!");
                    break;
            }
        }
        moves++;
    }
}
