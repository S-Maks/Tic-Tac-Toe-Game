package game;

import game.multiplayer.Multiplayer;
import game.simple.SinglePlayerGame;
import game.validation.InputData;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\t\tGame selection");
            System.out.println("\t1 - Simple player");
            System.out.println("\t2 - Multiplayer");
            System.out.println("\t3 - Rules of the game");
            System.out.println("\t0 - Exit");
            switch (InputData.CheckInt()) {
                case 1:
                    new SinglePlayerGame().Start();
                    break;
                case 2:
                    new Multiplayer().Start();
                    break;
                case 3: Game.Help();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("");
                    break;
            }
        }


    }
}
