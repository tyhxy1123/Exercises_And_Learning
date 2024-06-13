package com.javacode2020.lesson002.staticProxy;

public class ServiceProxy implements IService {
    private IService target;

    public IService getTarget() {
        return target;
    }

    public void setTarget(IService target) {
        this.target = target;
    }

    public ServiceProxy(IService target) {
        this.target=target;
    }

    @Override
    public void m1() {
        long startTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m1() method takes time: " + (endTime-startTime));
    }

    @Override
    public void m2() {
        long startTime = System.nanoTime();
        this.target.m2();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m2() method takes time: " + (endTime-startTime));
    }

    @Override
    public void m3() {
        long startTime = System.nanoTime();
        this.target.m3();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m3() method takes time: " + (endTime-startTime));
    }
}
