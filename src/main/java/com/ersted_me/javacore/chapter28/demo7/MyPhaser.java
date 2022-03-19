package main.java.com.ersted_me.javacore.chapter28.demo7;

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    public MyPhaser(int parties, int numPhases) {
        super(parties);
        this.numPhases = numPhases - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Фаза " + phase + " завершена.");

        if (phase == numPhases || registeredParties == 0) return true;

        return false;
    }

}
