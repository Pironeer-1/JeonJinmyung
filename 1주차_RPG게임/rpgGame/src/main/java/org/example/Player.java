package org.example;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private int hp = 50; // 초기 체력
    private int ad = 10; //초기 공격력
    private int ap = 5; //초기 마법력

    //사용자가 입력한 점수에 따라 플레이어의 스테이터스 포인트를 설정하는 메서드
    public void statusSet(final int point){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        //[게임 진행] 체력, 공격력, 마법력을 입력받고 , 주어진 포인트와 일치하는지 확인 후 변경된 스탯 적용해 출력
        Scanner scanner = new Scanner(System.in);

        while (true){
            try{
                System.out.println("체력, 공격력, 마법력을 입력하세요:");
                int hpInput = scanner.nextInt();
                int adInput = scanner.nextInt();
                int apInput = scanner.nextInt();

                if (hpInput + adInput + apInput == point){
                    this.hp += hpInput * 3;
                    this.ad += adInput;
                    this.ap += apInput;

                    System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
                    break;
                }
                else {
                    System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            }
            catch (Exception e){
                System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
                scanner.nextLine();
            }
        }

    }

    //[게임 진행] 각 행동에 따라 (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복)에 따른 동작 처리
    public void decreaseHp(final int damage){
        this.hp = Math.max(this.hp - damage, 0);
    }

    public void checkStatus(final Enemy enemy){ //플레이어와 적의 현재 상태 출력
        System.out.println("현재 유저: 체력 " + this.hp + ", 공격력 " + this.ad + ", 마법력 " + this.ap);
        System.out.println("적: 체력 " + enemy.getHp() + ", 공격력 " + enemy.getAd() + ", 방어력 " + enemy.getAdDefence() + ", 마법방어력 " + enemy.getApDefence());

        int damage = this.ad - enemy.getAdDefence();
        enemy.decreaseHp(damage);
        System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.\n");
    }

    public void basicAttack(final Enemy enemy){
        Random random = new Random();
        int critical_point = random.nextInt(10) + 1;
        int damage = this.ad - enemy.getAdDefence();

        if (critical_point > 2){
            enemy.decreaseHp(damage);
            System.out.println("일반 공격으로 " + damage + "의 데미지를 주었습니다.");
        }
        else {
            damage *= 2;
            enemy.decreaseHp(damage);
            System.out.println("치명타가 적용되어 " + damage + "의 데미지를 주었습니다.");
        }
    }

    public void magicAttack(final Enemy enemy){
        int damage = this.ap * 2 - enemy.getApDefence();
        enemy.decreaseHp(damage);
        System.out.println("마법 공격으로 " + damage + "의 데미지를 주었습니다.");
    }

    public void healSelf(){
        Random random = new Random();
        int heal_point = random.nextInt(6) + 5;
        this.hp += heal_point;
        System.out.println("체력을 회복합니다. 현재 hp는 " + this.hp + "입니다.");
    }

    public void attack(final Enemy enemy, final int player_index){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println((player_index + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
                String input_key = scanner.nextLine();

                if ("exit".equals(input_key)) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }

                int action = Integer.parseInt(input_key);

                switch (action) {
                    case 1:
                        this.checkStatus(enemy);
                        break;
                    case 2:
                        this.basicAttack(enemy);
                        break;
                    case 3:
                        this.magicAttack(enemy);
                        break;
                    case 4:
                        this.healSelf();
                        break;
                    default:
                        System.out.println("1~4 사이의 정수를 입력해주세요.");
                }
                break;
            }
            catch (NumberFormatException e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }

    }
    public int getHp() {
        return this.hp;
    }

}
