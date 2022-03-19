package main.java.com.ersted_me.javacore.chapter28.demo11;

class AtomThread implements Runnable {
    String name;

    public AtomThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        for(int i =0; i<=3;i++)
            System.out.println("Поток " + name + " получено: " + Shared.ai.getAndSet(i));
    }
}
