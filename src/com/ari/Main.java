package com.ari;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(1000, false);
        for(int i=0;i<10;i++) {
            game.executeOneGame();
        }
    }
}
