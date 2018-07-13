package multithreading.miner;

import static java.lang.Thread.sleep;

public class CoalMine {

    private static Integer capasity = 1000;

    public static synchronized Integer getCapasityAndDecreaseByTen() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return capasity -= 10;
    }
}
