package com.straydog.learnjava.exception;

/**
 * Created by Hongliang.Liu on 2017/5/7.
 */
public class ChainExceptionTest {

    public static void main(String[] args) {

        ChainExceptionTest cet = new ChainExceptionTest();
        try {
            cet.test2();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void test1() throws MyException {
        throw new MyException("这个是我自定义的异常");
    }


    private void test2(){
        try {
            test1();
        } catch (MyException e) {
//            RuntimeException newExce = new RuntimeException("封装捕获到的异常类为运行时异常");
//            re.initCause(e);

            RuntimeException newExce = new RuntimeException(e);
            throw newExce;
        }
    }

}
