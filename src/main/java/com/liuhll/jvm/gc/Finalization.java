package com.liuhll.jvm.gc;

public class Finalization {
    public  static Finalization finalization;

    @Override
    protected void finalize(){ // 不建议使用这个方法
        System.out.println("finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();
        System.out.println("First print: " + f);

        f = null;
        System.gc();

        try {
            Thread.currentThread().sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Second print: " + f);
        System.out.println(f.finalization);
    }
}
