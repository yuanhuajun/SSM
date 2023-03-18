package com.proxy;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 19:02
 * @Description
 */


public class CalculatorStaticProxy implements Calculator{
    private  Calculator target;

    public CalculatorStaticProxy(Calculator target)  {
        this.target = target;
    }


    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);

        int result = target.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
