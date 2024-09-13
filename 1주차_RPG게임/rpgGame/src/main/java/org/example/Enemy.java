package org.example;

import java.util.Random;

public class Enemy {
    private final int max_hp;
    private int hp;
    private final int ad = 25;
    private final int adDefence = 7;
    private final int apDefence = 7;

    public Enemy(final int listNum) {
        this.max_hp = 100 * listNum;
        this.hp = 100 * listNum;
    }

    public void decreaseHp(final int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    public void basicAttack(final Player player, final int player_index) {
        player.decreaseHp(this.ad);
        System.out.println((player_index + 1) + "번 유저에게 " + this.ad + "의 데미지. 적의 공격으로 현재 남은 체력은 " + player.getHp() + "입니다.");
    }

    public void healSelf() {
        int healing_amount = 7;
        if (this.hp + healing_amount > this.max_hp) {
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.\n");
        }
        else {
            this.hp += healing_amount;
            System.out.println("적의 회복으로 현재 적의 체력은 " + this.hp + "입니다.\n");
        }
    }

    public void attack(final Player player, final int player_index) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.\n");

        Random random = new Random();
        int enemy_action = random.nextInt(10) + 1;

        if (enemy_action == 1) {
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.\n");
        }
        else if (enemy_action <= 8) {
            this.basicAttack(player, player_index);
        }
        else {
            this.healSelf();
        }
    }

    public int getHp() {
        return this.hp;
    }

    public int getAd() {
        return this.ad;
    }

    public int getAdDefence() {
        return this.adDefence;
    }

    public int getApDefence() {
        return this.apDefence;
    }
}
