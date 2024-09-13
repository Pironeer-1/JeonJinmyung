package CH05;

class Bouncer {
    void barkAnimal(Barkable animal) {
        animal.bark();
    }
}
public class CH0508 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer= new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}
