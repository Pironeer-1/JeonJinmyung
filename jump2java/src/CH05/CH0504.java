package CH05;

class Updater {
    void update(Counter counter){
        counter.count++;
    }
}

class Counter{
    int count = 0;
}
public class CH0504 {
    public static void main(String[] args){
        Counter myCounter = new Counter();
        System.out.println("before update:" + myCounter.count);

        Updater myUpdater = new Updater();
        myUpdater.update(myCounter);
        System.out.println("after update:"+myCounter.count);
    }
}
