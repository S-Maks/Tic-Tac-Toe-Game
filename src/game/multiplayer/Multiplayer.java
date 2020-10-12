package game.multiplayer;

import game.Game;
import game.validation.InputData;

public class Multiplayer extends Game {
    private String SecondPlayerName;

    public Multiplayer() {
    }


    public String getSecondPlayerName() {
        return SecondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        SecondPlayerName = secondPlayerName;
    }

    @Override
    protected void NamePlayers() {
        System.out.print("\tEnter the name of the first player: ");
        setNamePlayer(InputData.InputString());
        System.out.print("\tEnter the name of the second player: ");
        setSecondPlayerName(InputData.InputString());
    }

    @Override
    public void Start() {
        NamePlayers();
        initializingList();

        while (Moves < 9) {
            super.PlayerTurn(getNamePlayer());
            if (Winner()) {

                view();
                System.out.println("\t\t" + getNamePlayer() + " won!");
                break;
            }
            PlayerTurn(getSecondPlayerName());
            if (Winner()) {
                view();
                System.out.println("\t\t" + getSecondPlayerName() + " won!");
                break;
            }
        }
        Moves = 0;
    }

    @Override
    protected void PlayerTurn(String Name) {
        boolean flag = true;
        System.out.println("\t\t" + Name + " walks");
        while (flag) {
            view();
            System.out.print("\tSelect the number where to put the cross:");
            switch (InputData.CheckInt()) {
                case 1:
                    if (Grid.get(0).get(0) == '.') {
                        Grid.get(0).set(0, 'o');
                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 2:
                    if (Grid.get(0).get(1) == '.') {
                        Grid.get(0).set(1, 'o');

                        flag = false;
                    } else {
                        System.out.println("Value not available!");
                    }
                    break;
                case 3:
                    if (Grid.get(0).get(2) == '.') {
                        Grid.get(0).set(2, 'o');
                        flag = false;
                    } else {

                        System.out.println("Value not available!");
                    }
                    break;
                case 4:
                    if (Grid.get(1).get(0) == '.') {
                        Grid.get(1).set(0, 'o');
                        flag = false;
                    } else {

                        System.out.println("Value not available!");
                    }
                    break;
                case 5:
                    if (Grid.get(1).get(1) == '.') {
                        Grid.get(1).set(1, 'o');
                        flag = false;
                    } else {

                        System.out.println("Value not available!");
                    }
                    break;
                case 6:
                    if (Grid.get(1).get(2) == '.') {
                        Grid.get(1).set(2, 'o');
                        flag = false;
                    } else {

                        System.out.println("Value not available!");
                    }
                    break;
                case 7:
                    if (Grid.get(2).get(0) == '.') {
                        Grid.get(2).set(0, 'o');
                        flag = false;
                    } else {

                        System.out.println("Value not available!");
                    }
                    break;
                case 8:
                    if (Grid.get(2).get(1) == '.') {
                        Grid.get(2).set(1, 'o');
                        flag = false;
                    } else {

                        System.out.println("Value not available!");
                    }
                    break;
                case 9:
                    if (Grid.get(2).get(2) == '.') {
                        Grid.get(2).set(2, 'o');
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
        Moves++;
    }
}
