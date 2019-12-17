package 自定义类加载器;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassLoaderTest {

    @Test
    public void test1() {
        try {
            MyClassLoader diskLoader = new MyClassLoader();
            MyClassLoader diskLoader1 = new MyClassLoader();

            //加载class文件
            Class clz = diskLoader.findClass("D:\\liubenlong\\a\\Hello.class");

            Constructor constructor = clz.getConstructor(String.class);
            Object obj = constructor.newInstance("tom");

            Method method = clz.getMethod("sayHello", null);
            //通过反射调用Test类的say方法
            method.invoke(obj, null);




            Class clz1 = diskLoader1.findClass("D:\\liubenlong\\b\\Hello.class");

            Constructor constructor1 = clz1.getConstructor(String.class);
            Object obj1 = constructor1.newInstance("cat");

            Method method1 = clz1.getMethod("sayHello", null);
            //通过反射调用Test类的say方法
            method1.invoke(obj1, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
