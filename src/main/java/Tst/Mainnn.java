package Tst;

import java.io.IOException;

public class Mainnn {

    public static void main(String[] args) throws IOException {
        OObj x = new OObj(454,null);
        OObj xxx = x.withName("asjhdsa");
        System.out.println(x.getId());
        System.out.println(x.getName());
        System.out.println(xxx.getName());

        OObj xx = new OObj(0,null).withId(78).withName("jdsa");


        System.out.println(xx.getId());
        System.out.println(xx.getName());

    }


}
