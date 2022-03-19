package main.java.com.ersted_me.javacore.chapter28.demo13;

import java.util.concurrent.ForkJoinPool;

class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if (args.length != 2) {
            System.out.println("Использование: FJExperiment параллелизм порог.");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        long beginT, endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[1_000_000];

        for (int i=0;i<nums.length;i++)
            nums[i] = (double) i;

        Transform task = new Transform(threshold, nums, 0, nums.length);

        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();

        System.out.println("Уровень параллелизма: " + pLevel);
        System.out.println("Порог последовательной обработки: " + threshold);
        System.out.println("Истекшее время: " + (endT - beginT) + " нс.");
        System.out.println();
    }
}
