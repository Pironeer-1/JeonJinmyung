package CH03;

import java.util.Arrays;
import java.util.HashSet;

public class CH0309 {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set);

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8,9));

        //교집합
        HashSet<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        System.out.println(intersection);

        //합집합
        HashSet<Integer> union = new HashSet<>(s1);
        union.addAll(s2);
        System.out.println(union);

        //차집합
        HashSet<Integer> substract = new HashSet<>(s1);
        substract.removeAll(s2);
        System.out.println(substract);

        //add
        HashSet<String> set1 = new HashSet<>();
        set1.add("Jump");
        set1.add("To");
        set1.add("Java");
        System.out.println(set1);

        //addAll
        set1.addAll(Arrays.asList("Go", "Fighting"));
        System.out.println(set1);

        //remove
        set1.remove("To");
        System.out.println(set1);
    }
}
