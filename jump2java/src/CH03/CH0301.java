public class CH0301 {
    public static void main(String[] args){
        int a = 10;
        int b = 5;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);

        System.out.println(7 % 3);
        System.out.println(3 % 7);

        /* 증감 연산 */
        int i = 0;
        int j = 10;
        i++;
        j--;

        System.out.println(i);
        System.out.println(j);

        /*
        i++: 값을 참조한 후에 증가
        ++i: 값을 참조하기 전에 증가
         */
        i = 0;
        System.out.println(i++); //0
        System.out.println(i); //1

        i = 0;
        System.out.println(++i); //1
        System.out.println(i); //1
    }
}
