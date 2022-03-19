package main.java.com.ersted_me.javacore.chapter28.demo13;

import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {
    int seqThreshold;
    double[] data;
    int start, end;

    public Transform(int seqThreshold, double[] data, int start, int end) {
        this.seqThreshold = seqThreshold;
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Transform(start, data, middle, seqThreshold),
                    new Transform(middle,data,end,seqThreshold));
        }
    }
}
