package CH04;

import java.util.ArrayList;
import java.util.Arrays;

public class CH0405 {
    public static void main(String[] args){
        String[] numbers = {"one", "two", "three"};
        for (String number:numbers){
            System.out.println(number);
        }

        ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        for (String number : numbers2){
            System.out.println(number);
        }
    }
}
