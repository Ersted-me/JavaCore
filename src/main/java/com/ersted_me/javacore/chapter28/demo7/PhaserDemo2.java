package main.java.com.ersted_me.javacore.chapter28.demo7;

class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser(1,4);

        System.out.println("Запуск потоков\n");

        new MyThread(phaser,"A");
        new MyThread(phaser,"B");
        new MyThread(phaser, "C");

        while (!phaser.isTerminated()){
            phaser.arriveAndAwaitAdvance();
        }
        System.out.println("Синхронизация фаз завершена.");
    }
}
