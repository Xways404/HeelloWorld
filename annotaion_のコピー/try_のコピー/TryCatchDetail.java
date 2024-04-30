package com.hspedu.try_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TryCatchDetail {
    public static void main(String[] args) {
        //例外が発生した場合、その後のコードが実行されず、Catchブロックに入る
        //例外が発生しなかった場合、Tryのブロックを正常に実行し続き、Catchが無視される
        //例外が発生してもしなくても、とあるコードを実行したければ、Finallyを導入
        try {
            String str = "java";
            int a = Integer.parseInt(str);
            System.out.println(a);
        } catch (NumberFormatException e) {
            System.out.println("Exception info" + e.getMessage());
        } finally {
            System.out.println("finally going");
        }
        System.out.println("programing still");
    }
}

