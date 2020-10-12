package game;

import java.util.*;
import game.validation.InputData;

abstract public class Game {
    protected String namePlayer;

    protected static int moves = 0;

    protected List<ArrayList<Character>> grid = new ArrayList();

    public Game() {}

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    protected abstract void namePlayers();

    protected abstract void start();

    protected void initializingList() {
        for (int i = 0; i < 3; i++) {
            ArrayList<Character> arr1 = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                arr1.add('.');
            }
            grid.add(arr1);
        }
    }

    protected void view() {
        System.out.println("\t-------");
        int count = 1;
        for (List<Character> gridSymbol : grid) {
            System.out.print("\t");
            for (char Symbol : gridSymbol) {
                if (Symbol != '.') {
                    System.out.print("|" + "\u001B[32m" + Symbol + "\u001B[0m");
                } else {
                    System.out.print("|" + "\u001B[32m" + count + "\u001B[0m");
                }
                count++;
            }
            System.out.print("|\n");
        }
        System.out.println("\t-------");
    }

    protected void playerTurn(String Name) {
        boolean flag = true;
        System.out.println("\t\t" + Name + " walks");
        while (flag) {
            view();
            System.out.print("\tSelect the number where to put the cross:");
            switch (InputData.checkInt()) {
                case 1:
                    if (grid.get(0).get(0) == '.') {
                        grid.get(0).set(0, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 2:
                    if (grid.get(0).get(1) == '.') {
                        grid.get(0).set(1, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 3:
                    if (grid.get(0).get(2) == '.') {
                        grid.get(0).set(2, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 4:
                    if (grid.get(1).get(0) == '.') {
                        grid.get(1).set(0, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 5:
                    if (grid.get(1).get(1) == '.') {
                        grid.get(1).set(1, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 6:
                    if (grid.get(1).get(2) == '.') {
                        grid.get(1).set(2, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 7:
                    if (grid.get(2).get(0) == '.') {
                        grid.get(2).set(0, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 8:
                    if (grid.get(2).get(1) == '.') {
                        grid.get(2).set(1, 'x');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 9:
                    if (grid.get(2).get(2) == '.') {
                        grid.get(2).set(2, 'x');
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

    protected boolean toWin() {
        for (int i = 0; i < 3 - 2; i++) {
            for (int j = 0; j < 3 - 2; j++) {
                if ((grid.get(i).get(j) == 'x' && grid.get(i + 1).get(j + 1) == 'x' && grid.get(i + 2).get(j + 2) == 'x') ||
                        (grid.get(i).get(j) == 'o' && grid.get(i + 1).get(j + 1) == 'o' && grid.get(i + 2).get(j + 2) == 'o')) {
                    return true;
                }
            }
        }
        for (int i = 3 - 1; i > 1; i--) {
            for (int j = 0; j < 3 - 2; j++) {
                if ((grid.get(i).get(j) == 'x' && grid.get(i - 1).get(j + 1) == 'x' && grid.get(i - 2).get(j + 2) == 'x') ||
                        (grid.get(i).get(j) == 'o' && grid.get(i - 1).get(j + 1) == 'o' && grid.get(i - 2).get(j + 2) == 'o')) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - 2; j++) {
                if ((grid.get(i).get(j) == 'x' && grid.get(i).get(j + 1) == 'x' && grid.get(i).get(j + 2) == 'x') ||
                        (grid.get(i).get(j) == 'o' && grid.get(i).get(j + 1) == 'o' && grid.get(i).get(j + 2) == 'o'))
                    return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - 2; j++) {
                if ((grid.get(j).get(i) == 'x' && grid.get(j + 1).get(i) == 'x' && grid.get(j + 2).get(i) == 'x') ||
                        (grid.get(j).get(i) == 'o' && grid.get(j + 1).get(i) == 'o' && grid.get(j + 2).get(i) == 'o'))
                    return true;
            }
        }
        return false;
    }

    public static void help() {
        System.out.println("\n\n\n\t\t\t  The game was written by BSUIR STUDENT Titok Maxim");
        System.out.println("\n\t\t\t\t     Game rules");
        System.out.println("\t\t   Players take turns placing signs on the free squares of the field" +
                "\n\t\t   (one is always TIC-TAC-toe, the other is always TIC-TAC-toe)." +
                "\n\t\t   The first one who lined up 3 of his pieces vertically," +
                "\n\t\t   horizontally, or diagonally wins the game." +
                "\n\t\t   The first move is made by the player who puts crosses.");
        System.out.println("\n\t\t1. If a player can win immediately, they do so.");
        System.out.println("\n\t\t2. If a player can't win immediately, but his opponent does" +
                "\n\t\t   he could have won immediately by making a move to a certain square," +
                "\n\t\t   the player himself makes a move to this cell, preventing an immediate loss.");
        System.out.println("\n\t\t\t\t\tAbout the game");
        System.out.println("\t\t   TIC-TAC — toe is a logical game between two opponents on a square field." +
                "\n\t\t   One of the players plays \"crosses\", the second — \"zeros\".");
    }
}
