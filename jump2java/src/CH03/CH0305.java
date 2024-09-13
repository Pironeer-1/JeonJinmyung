public class CH0305 {
    public static void main(String[] args){
        //StringBuffer: 문자열을 추가하거나 변경할 때 주로 사용하는 자료형
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String result = sb.toString();
        System.out.println(result);

        //String 자료형 사용: + 연산 있을 때 마다 새로운 객체 생성
        /*
        String 자료형은 값이 한 번 생성되면 변경할 수 없다.
        또 다른 String 객체를 생성하여 리턴함.
        vs
        StringBuffer는 생성된 값 수정 가능 but 더 무거움
         */
        String result1 = "";
        result1 += "hello";
        result1 += " ";
        result1 += "jump to java";
        System.out.println(result1);

        //StringBuilder
        StringBuilder sb1 = new StringBuilder();
        sb1.append("hello");
        sb1.append(" ");
        sb1.append("jump to java");
        String result2 = sb1.toString();
        System.out.println(result2);

        //insert: 특정 위치에 원하는 문자열 삽입
        StringBuffer sb2 = new StringBuffer();
        sb2.append("jump to java");
        sb2.insert(0, "hello ");
        System.out.println(sb2.toString());

        //substring
        System.out.println(sb2.substring(0, 4));



    }
}
