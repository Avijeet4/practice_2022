package com.avijeet.practice_2022.epam.carrom.service;

import com.avijeet.practice_2022.epam.carrom.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayCarom {
    private Random random = new Random();
    private List<Player> players = new ArrayList<>();

    private int startGame() {
        int playerNumber = 0;

        while (true) {
            Player activePLayer = players.get(playerNumber);
            while (getResult()) {
                activePLayer.incrementScore();
                if (activePLayer.getScore() == 10) {
                    break;
                }
            }
            if (activePLayer.getScore() == 10) {
                break;
            }
            playerNumber++;
            playerNumber = playerNumber % players.size();
        }
        return playerNumber;
    }

    private void createGame(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player(i+1, 0));
        }
    }

    private boolean getResult() {
        return random.nextBoolean();
    }

    public List<Player> play() {
        createGame(4);
        int winner = startGame();
        System.out.println(String.format("Winner: %s", winner+1));
        System.out.println(players);
        return players;
    }

    public static void main(String[] args) {
        PlayCarom playCarom = new PlayCarom();
        playCarom.play();
    }
}
