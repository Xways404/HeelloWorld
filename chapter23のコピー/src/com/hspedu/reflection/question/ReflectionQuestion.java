package com.hspedu.reflection.question;

import com.hspedu.Cat;
import jdk.nashorn.internal.ir.CallNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //設定ファイルre.propertiesの指定情報に基づき、Catオブジェクトを作成してhiメソッドをコール
        //今まで　オブジェクトを新規作成new
//    Cat cat =new Cat();
//    cat.hi();

        //propertiesクラスで、設定ファイルを読み取れる
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classfullpath: " + classfullpath);
        System.out.println("method: " + method);

        //リフレクションで解決する
        // クラスをロードする Classクラス型のオブジェクトが戻される
        Class cls = Class.forName(classfullpath);
        //clsに通じてロードしたクラスのオブジェクトインスタンスをゲットできる
        Cat o = (Cat)cls.newInstance();
        //clsに通じてロードしたクラスのメソッドオブジェクト
        //リフレクションでは、メソッドをオブジェクトとして扱える
        Method method1 = cls.getMethod(method);
        //コール
        System.out.println("=========================");
        method1.invoke(o);// メソッド.invoke(オブジェクト)





    }
}
