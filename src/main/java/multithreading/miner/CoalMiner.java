package multithreading.miner;

import static java.lang.Thread.sleep;

public class CoalMiner implements Runnable {

    static boolean shouldTheJobBeFinished = false;

    int workerId;

    public CoalMiner(int workerId) {
        this.workerId = workerId;
    }

    public void atWork() {
        int leftCapasity = CoalMine.getCapasityAndDecreaseByTen();

        try {
            sleep(10);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        if (leftCapasity == 0) {
            shouldTheJobBeFinished = true;
            return;
        }
        System.out.println("How much left = " + leftCapasity + " miner's id " + workerId);
    }

    @Override
    public void run() {
        long startTimer = System.currentTimeMillis();
        while (!shouldTheJobBeFinished) {
            atWork();
        }
        long endTimer = System.currentTimeMillis();
        long finishedTime = endTimer - startTimer;
        System.out.println("The miner: " + workerId + " finished the job by timer: " + finishedTime + "ms");
    }
}
