package CH05;

public class CH0503 {

    int a; //객체 변수
    int sum(int a, int b) {
        return a + b;
    }

    String say() {
        return "Hi";
    }

    void sum2(int a, int b) {
        System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
    }

    void say2() {
        System.out.println("Hi");
    }

    void sayNick(String nick) {
        if ("바보".equals(nick)) {
            return;
        }
        System.out.println("나의 별명은 "+nick+" 입니다.");
    }

    int varTest(int a) {
        a++;
        return a;
    }

    void varTest(CH0503 sample){
        sample.a++;
    }

    public static void main(String[] args) {
        int a3 = 1;

        int a = 3;
        int b = 4;

        CH0503 sample = new CH0503();
        int c = sample.sum(a, b);

        System.out.println(c);

        String a2 = sample.say();
        System.out.println(a2);

        sample.sum2(3, 4);

        sample.say2();

        sample.sayNick("야호");
        sample.sayNick("바보");

        a3 = sample.varTest(a3);
        System.out.println(a3);

        sample.a = 1;
        sample.varTest(sample);
        System.out.println(sample.a);
    }
}
