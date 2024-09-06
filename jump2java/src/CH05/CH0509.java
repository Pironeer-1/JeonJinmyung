package CH05;

abstract class Predator2 extends Animal {
    abstract String getFood();

    void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}
public class CH0509 {
}
