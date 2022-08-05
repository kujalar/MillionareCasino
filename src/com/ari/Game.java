package com.ari;

import java.util.Random;

public class Game {
    private Random random;
    private final long cashTarget;
    private final boolean debug;

    private long cashEarned;
    private long looseStreak;
    private long maxLooseStreak;
    private long winStreak;
    private long maxWinStreak;
    private long rounds;
    private long bet;
    private long maxBet;

    public Game(final long cashTarget, boolean debug) {
        this.cashTarget = cashTarget;
        this.debug = debug;
    }

    private void initGame(){
        cashEarned = 0;
        looseStreak = 0;
        winStreak = 0;
        maxLooseStreak = looseStreak;
        maxWinStreak = winStreak;
        rounds = 0;
        bet = 1;
        maxBet = bet;
        random = new Random();
    }

    public void executeOneGame() {
        System.out.print("executeOneGame with target "+cashTarget);
        initGame();

        boolean run = true;
        while(run) {
            rounds++;
            if(debug) System.out.print(" betting "+bet);
            if((random.nextInt(6)+1)<3) {
                if(debug) System.out.print(" win the bet.");
                cashEarned += bet;
                looseStreak = 0;
                winStreak++;
                bet = 1;
                if(winStreak>maxWinStreak) {
                    maxWinStreak = winStreak;
                }
            } else {
                if(debug) System.out.print(" lost the bet.");
                looseStreak++;
                cashEarned -= bet;
                bet = bet*2;
                if(bet>maxBet) {
                    maxBet = bet;
                }
                if(looseStreak>maxLooseStreak) {
                    maxLooseStreak = looseStreak;
                }
                winStreak = 0;
            }

            if(cashEarned>= cashTarget) {
                run = false;
                System.out.print(" Game Won in "+rounds+" rounds, with maxLooseStreak of "+maxLooseStreak+ " and maxWinStreak of "+maxWinStreak);
                if(debug) System.out.print(" cashTotal = "+cashEarned);
                System.out.println(".");
            } else {
                if(debug) System.out.println(" cashTotal = "+cashEarned);
            }
        }
    }
}
