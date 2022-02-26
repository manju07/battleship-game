package com.game.battleship.service;

import com.game.battleship.model.Player;


class Fire {

    public void fire1() {
    }

    public  void fire2() {
    }

}

/**
 * 
 * @author Manjunath Asundi
 */
public class PlayGame {
    public static void startGame(Player p1, Player p2) {
        Fire s1 = new Fire();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {

            }
        });
        t1.start();
        t2.start();
    }
}
