package CH04;

import java.util.ArrayList;

public class CH0401 {
    public static void main(String[] args){
        int x = 3;
        int y = 2;
        System.out.println(x > y);
        System.out.println(x < y);
        System.out.println(x == y);
        System.out.println(x != y);

        int money = 2000;
        if (money >= 3000) {
            System.out.println("택시를 타고 가라");
        }else {
            System.out.println("걸어가라");
        }

        boolean hasCard = true;
        if (money>=3000 || hasCard) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }

        //contains 메서드
        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("handphone");
        pocket.add("money");

        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라");
        }else {
            System.out.println("걸어가라");
        }

        //else if
        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라");
        }else {
            if (hasCard) {
                System.out.println("택시를 타고 가라");
            }else {
                System.out.println("걸어가라");
            }
        }

        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라");
        }else if(hasCard) {
            System.out.println("택시를 타고 가라");
        }else {
            System.out.println("걸어가라");
        }
    }
}
