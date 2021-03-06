package com.ivanmagda;

class FunctionWorker implements Runnable {

    private final Function function;
    private final FunctionResult functionResult;

    private final double a;
    private final double b;
    private final double h;

    FunctionWorker(Function function, FunctionResult functionResult, double a, double b, double h) {
        this.function = function;
        this.functionResult = functionResult;
        this.a = a;
        this.b = b;
        this.h = h;
    }

    private void calculate() {
        double result = 0;
        for (double x = a; x < b; x += h) {
            result += 0.5 * (function.func(x) + function.func(x + h)) * h;
        }
        functionResult.appendValue(result);
    }

    @Override
    public void run() {
        calculate();
        functionResult.workerDone();
    }

}
