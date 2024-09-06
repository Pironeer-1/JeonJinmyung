package CH03;

public class CH0311 {
    public static void main(String[] args) {
        String num = "123";
        int n = Integer.parseInt(num);
        System.out.println(n);

        int n2 = 123;
        String num2 = "" + n2;
        System.out.println(num2);

        int n3 = 123;
        String num3 = String.valueOf(n3);
        String num4 = Integer.toString(n3);
        System.out.println(num3);
        System.out.println(num4);

        String num5 = "123.456";
        double d = Double.parseDouble(num5);
        System.out.println(d);

        int n1 = 123;
        double d1 = n1;
        System.out.println(d1);

        double d2 = 123.456;
        int n4 = (int) d2;
        System.out.println(n4);
    }
}
