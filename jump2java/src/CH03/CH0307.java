package CH03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CH0307 {
    public static void main(String[] args){
        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        pitches.add(0, "133");
        pitches.add(1, "133");

        System.out.println(pitches.get(1));
        System.out.println(pitches.size());
        System.out.println(pitches.contains("142"));

        //remove
        System.out.println(pitches.remove("129"));
        System.out.println(pitches.remove(0));

        //제네릭스: 자료형 명확하게 하기 위해 사용
        ArrayList<String> pitches1 = new ArrayList<>();
        pitches1.add("138");
        pitches1.add("129");

        String one = pitches1.get(0); //형 변환 필요없음

        ArrayList<String> pitches2 = new ArrayList<>();
        pitches2.add("138");
        pitches2.add("129");
        pitches2.add("142");
        System.out.println(pitches2);

        //이미 문자열 배열이 있는 경우: asList메서드 사용
        String[] data = {"138", "129", "142"};
        ArrayList<String> pitches3 = new ArrayList<>(Arrays.asList(data));
        System.out.println(pitches3);

        //String 배열 대신 String 자료형을 여러개 전달하여 생성
        ArrayList<String> pitches4 = new ArrayList<>(Arrays.asList("138", "129", "142"));
        System.out.println(pitches4);

        //String.join: ArrayList의 각 요소를 ,로 구분해서 1개의 문자열로 만들기
        ArrayList<String> pitches5 = new ArrayList<>(Arrays.asList("138", "129", "142"));
        String result = "";
        for(int i=0; i<pitches5.size(); i++){
            result += pitches5.get(i);
            result += ",";
        }
        result = result.substring(0, result.length()-1);
        System.out.println(result);

        ArrayList<String> pitches6 = new ArrayList<>(Arrays.asList("138", "129", "142"));
        String result1 = String.join(",", pitches6);
        System.out.println(result1);

        String[] pitches7 = new String[]{"138", "129", "142"};
        String result2 = String.join(",", pitches7);
        System.out.println(result2);

        //리스트 정렬하기
        pitches3.sort(Comparator.naturalOrder());
        System.out.println(pitches3);
    }
}
