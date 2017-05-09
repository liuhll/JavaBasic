package com.straydog.learnjava.innerclass;

/**
 * Created by jyyc on 2017/5/9.
 */
public class InnerClassTest3 {

    public Destionation destionation(String str){
        //方法体内的局部内部类
        class PDestionation implements Destionation{

            private String lable;

            private PDestionation(String lable){

                this.lable = lable;
            }

            @Override
            public String readLabel() {
                return "PartInnerClass:" + lable;
            }
        }

        return new PDestionation(str);
    }

    private String internalTracking(boolean b){
        if(b){
            //定义在作用域内的局部内部类
            class TrackingSlip{
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("chenssy");
            String string = ts.getSlip();
            return string;
        }
        return "false";
    }

    public static void main(String[] args) {

        InnerClassTest3 ict3 = new InnerClassTest3();
        String lable = ict3.destionation("This is Test Pater InnerClass Method").readLabel();
        System.out.println(lable);

        String slip = ict3.internalTracking(true);
        System.out.println(slip);

    }
}

interface Destionation{
   String readLabel();
}
