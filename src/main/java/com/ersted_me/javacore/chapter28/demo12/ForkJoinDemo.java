package main.java.com.ersted_me.javacore.chapter28.demo12;

import java.util.concurrent.ForkJoinPool;

class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[100_000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        System.out.println("Часть исходной последовательности:");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        fjp.invoke(task);

        System.out.println("Часть преобразованной последовательности " +
                "(с точностью до четырех знаков после десятичной точки):");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f", nums[i]);
        }
        System.out.println();
    }
}
