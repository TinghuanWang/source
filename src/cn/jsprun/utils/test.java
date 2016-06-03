package cn.jsprun.utils;

/**
 * Created by 123456 on 2016/1/25.
 */
public class test {
    public static void main(String [] args){
        String arg0 ="123456";
        Md5Token md5 = Md5Token.getInstance();
        String pwd = md5.getLongToken(md5.getLongToken(arg0));
        System.out.printf(pwd);
    }
}
