import java.util.Arrays;

public class CH0304 {
    public static void main(String[] args){
        //equals
        String a = "hello";
        String b = "java";
        String c = "hello";
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        // ==은 2개의 자료형이 같은 객체인지를 판별
        a = "hello";
        b = new String("hello");
        System.out.println(a.equals(b));
        System.out.println(a == b);

        //indexOf: 특정 문자열이 시작되는 인덱스 값 리턴
        a = "Hello Java";
        System.out.println((a.indexOf("Java")));

        //contains: 문자열에서 특정 문자열이 포함되어 있는지 여부 리턴
        a = "Hello Java";
        System.out.println(a.contains("Java"));

        //charAt: 문자열에서 특정 위치의 문자를 리턴
        a = "Hello Java";
        System.out.println(a.charAt(6));

        //replaceAll: 특정 문자열을 다른 문자열로 바꿈
        a = "Hello Java";
        System.out.println(a.replaceAll("Java", "World"));

        //substring: 문자열에서 특정 문자열을 뽑아낼 때 사용
        a = "Hello Java";
        System.out.println(a.substring(0, 4));

        //toUpperCase: 문자열을 모두 대문자로 변경
        a = "Hello Java";
        System.out.println(a.toUpperCase());

        //split: 문자열을 특정한 구분자로 나누어 문자열 배열로 리턴
        a = "a:b:c:d";
        String[] result = a.split(":");
        System.out.println(Arrays.toString(result));

        //문자열 포매팅
        System.out.println(String.format("I eat %d apples", 3));
        System.out.println(String.format("I eat %s apples.", "five"));

        int number = 3;
        System.out.println(String.format("I eat %d apples.", number));

        number = 10;
        String day = "three";
        System.out.println(String.format("I ate %d apples. so I was sick for %s days.", number, day));

        System.out.println(String.format("I have %s apples",  3));
        System.out.println(String.format("rate is %s", 3.234));

        //문자열 포맷 코드 응용
        System.out.println(String.format("%10s", "hi"));
        System.out.println(String.format("%-10sjane.", "hi"));
        System.out.println(String.format("%.4f", 3.42134234));
        System.out.println(String.format("%10.4f", 3.42134234));

        //System.out.printf
        //String.format은 문자열을 리턴, System.out.printf는 문자열을 출력
        System.out.printf("I eat %d apples.", 3);

    }
}
