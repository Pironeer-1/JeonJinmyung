package CH04;

public class CH0404 {
    public static void main(String[] args){
        String[] numbers = {"one", "two", "three"};
        for(int i=0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }

        int[] marks = {90, 25, 67, 45, 80};
        for(int i=0; i<marks.length; i++){
            if(marks[i] >= 60){
                System.out.println((i+1) + "번 학생은 합격입니다.");
            }
            else {
                System.out.println((i+1) + "번 학생은 불합격입니다.");
            }
        }

        for(int i=0; i<marks.length; i++){
            if(marks[i] < 60){
                continue;
            }
            System.out.println((i+1) + "번 학생 축하합니다. 합격입니다.");
        }

        //이중 for문
        for (int i=2; i<10; i++){
            for (int j=1; j<10; j++){
                System.out.print(i*j + " ");
            }
            System.out.println("");
        }
    }
}
