package com.game.battleship;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.battleship.model.Missle;
import com.game.battleship.model.Player;
import com.game.battleship.model.Ship;
import com.game.battleship.util.CommonUtil;
import com.game.battleship.util.FileUtil;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BattleshipApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BattleshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> inputData = FileUtil.readDataFromFile();

		int gridSize = Integer.parseInt(inputData.get(0));
		int shipsCount = Integer.parseInt(inputData.get(1));

		String p1ShipsPosition = inputData.get(2);
		String p2ShipsPosition = inputData.get(3);

		String[] p1Ships = p1ShipsPosition.split(":");
		String[] p2Ships = p2ShipsPosition.split(":");

		List<Ship> p1ShipList = new ArrayList<>();
		List<Ship> p2ShipList = new ArrayList<>();

		Map<Ship, Integer> p1ShipPositionsMap = new HashMap<>();
		Map<Ship, Integer> p2ShipPositionsMap = new HashMap<>();

		for (int i = 0; i < shipsCount; i++) {
			String[] p1XyData = p1Ships[i].split(",");
			int p1x = Integer.parseInt(p1XyData[0]);
			int p1y = Integer.parseInt(p1XyData[1]);
			Ship p1Ship = Ship.builder().name((i + 1) + "").playerName("p1").x(p1x).y(p1y).build();
			p1ShipList.add(p1Ship);
			p1ShipPositionsMap.put(p1Ship, i + 1);

			String[] p2XyData = p2Ships[i].split(",");
			int p2x = Integer.parseInt(p2XyData[0]);
			int p2y = Integer.parseInt(p2XyData[1]);
			Ship p2Ship = Ship.builder().name((i + 1) + "").playerName("p2").x(p2x).y(p2y).build();
			p2ShipList.add(p2Ship);
			p2ShipList.add(p2Ship);
			p2ShipPositionsMap.put(p2Ship, i + 1);
		}

		CommonUtil.printList(p1ShipList);
		CommonUtil.printList(p2ShipList);

		int misselsCount = Integer.parseInt(inputData.get(4));
		String p1MisslePosition = inputData.get(5);
		String p2MisslePosition = inputData.get(6);

		String[] p1Missles = p1MisslePosition.split(":");
		String[] p2Missles = p2MisslePosition.split(":");

		List<Missle> p1MisslesList = new ArrayList<>();
		List<Missle> p2MisslesList = new ArrayList<>();

		Map<Missle, Integer> p1MisslePositionsMap = new HashMap<>();
		Map<Missle, Integer> p2MisslePositionsMap = new HashMap<>();

		for (int i = 0; i < misselsCount; i++) {
			String[] p1XyData = p1Missles[i].split(",");
			int p1x = Integer.parseInt(p1XyData[0]);
			int p1y = Integer.parseInt(p1XyData[1]);
			Missle p1Missle = Missle.builder().name((i + 1) + "").playerName("p1").x(p1x).y(p1y).build();
			p1MisslesList.add(p1Missle);
			p1MisslePositionsMap.put(p1Missle, i + 1);

			String[] p2XyData = p2Missles[i].split(",");
			int p2x = Integer.parseInt(p2XyData[0]);
			int p2y = Integer.parseInt(p2XyData[1]);
			Missle p2Missle = Missle.builder().name((i + 1) + "").playerName("p2").x(p2x).y(p2y).build();
			p2MisslesList.add(p2Missle);
			p2MisslePositionsMap.put(p2Missle, i + 1);
		}
		CommonUtil.printList(p1MisslesList);
		CommonUtil.printList(p2MisslesList);

		Player player1 = CommonUtil.playerBuilder(gridSize, shipsCount, p1ShipList, p1ShipPositionsMap, misselsCount,
				p1MisslesList,
				p1MisslePositionsMap, "p1");

		Player player2 = CommonUtil.playerBuilder(gridSize, shipsCount, p2ShipList, p2ShipPositionsMap, misselsCount,
				p2MisslesList,
				p2MisslePositionsMap, "p2");

		System.out.println(player1 + "\n\n");
		System.out.println(player2);
	}
}