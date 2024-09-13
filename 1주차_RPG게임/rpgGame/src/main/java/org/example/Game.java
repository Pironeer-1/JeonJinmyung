package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final int status_point = 13;
    private final List<Player> player_list = new ArrayList<>();
    private Enemy enemy;

    public void setPlayers() {
        Scanner scanner = new Scanner(System.in);
        int list_num;
        while (true) {
            try {
                System.out.println("플레이어 인원을 정하세요:");
                list_num = Integer.parseInt(scanner.nextLine());
                if (list_num > 0) {
                    break;
                }
                else {
                    System.out.println("플레이어 인원은 1 이상이어야 합니다.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }

        for (int i = 0; i < list_num; i++) {
            Player player = new Player();
            player.statusSet(this.status_point);
            this.player_list.add(player);
        }
    }

    public void setEnemy() {
        this.enemy = new Enemy(this.player_list.size());
    }

    public boolean turnCheck() {
        this.player_list.removeIf(player -> player.getHp() == 0);
        return !this.player_list.isEmpty() && this.enemy.getHp() > 0;
    }

    public Player selectTargetPlayer() {
        Random random = new Random();
        return this.player_list.get(random.nextInt(this.player_list.size()));
    }

    public void game() {
        this.setPlayers();
        this.setEnemy();

        while (this.turnCheck()) {
            for (int i = 0; i < this.player_list.size(); i++) {
                this.player_list.get(i).attack(this.enemy, i);
                if (this.enemy.getHp() == 0) {
                    break;
                }
            }

            if (this.turnCheck()) {
                Player targetPlayer = this.selectTargetPlayer();
                int targetIndex = this.player_list.indexOf(targetPlayer);
                this.enemy.attack(targetPlayer, targetIndex);
            } else {
                break;
            }
        }

        if (this.enemy.getHp() <= 0) {
            System.out.println("축하합니다! 승리하셨습니다!");
        } else {
            System.out.println("아쉽지만 패배하셨습니다.");
        }
    }
}
