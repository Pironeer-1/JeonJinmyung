package CH05;

class Dog extends Animal {
    void sleep() {
        System.out.println(this.name+" zzz");
    }

}

class HouseDog extends Dog {
    //CH0506 생성자 추가
    HouseDog(String name) {
        this.setName(name);
    }

    HouseDog(int type) {
        if (type == 1) {
            this.setName("yorkshire");
        } else if (type == 2) {
            this.setName("bulldog");
        }
    }
    void sleep() {
        System.out.println(this.name + " zzz in house");
    }

    void sleep(int hour) {
        System.out.println(this.name+" zzz in house for " + hour + " hours");
    }
}
public class CH0505 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("poppy");
        System.out.println(dog.name);
        dog.sleep();

        HouseDog houseDog = new HouseDog("happy");
        houseDog.setName("happy");
        houseDog.sleep();
        houseDog.sleep(3);
    }
}
