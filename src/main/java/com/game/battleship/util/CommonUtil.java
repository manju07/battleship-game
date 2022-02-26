package com.game.battleship.util;

import java.util.List;
import java.util.Map;

import com.game.battleship.model.Missle;
import com.game.battleship.model.Player;
import com.game.battleship.model.Ship;

public class CommonUtil {
    public static void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n\n");
    }

    public static Player playerBuilder(int gridSize, int shipsCount, List<Ship> p2ShipList,
            Map<Ship, Integer> p2ShipPositionsMap,
            int misselsCount, List<Missle> p2MisslesList, Map<Missle, Integer> p2MisslePositionsMap, String playerName) {
        return Player.builder().name(playerName).gridSize(gridSize).misselsCount(misselsCount)
                .shipsCount(shipsCount)
                .misslePositions(p2MisslePositionsMap).shipsPositions(p2ShipPositionsMap).shipsList(p2ShipList)
                .misslesList(p2MisslesList).build();
    }
}
