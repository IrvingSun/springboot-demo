package cn.sunway.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author sunw
 * @date 2023/8/22
 */
public class JavassistDemo2 {

    public static void main(String[] args) throws CannotCompileException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NotFoundException {
        URL resource = JavassistDemo2.class.getClassLoader().getResource("");
        String file = resource.getFile();
        System.out.println("文件存储路径："+file);

        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("cn.sunway.javassist.HelloJavassist");


        CtField intFiled1 = new CtField(CtClass.intType, "value", ctClass);
        intFiled1.setModifiers(Modifier.PRIVATE | Modifier.FINAL);
        ctClass.addField(intFiled1, "100");

        CtMethod helloMethod = new CtMethod(CtClass.voidType, "hello", new CtClass[]{CtClass.intType}, ctClass);
        helloMethod.setModifiers(Modifier.PUBLIC);
        helloMethod.setBody("System.out.println($1 + \"msg\");");

        ctClass.addMethod(helloMethod);
        //创建Class文件
        ctClass.writeFile(file);

        //调用Class文件并执行方法
        ClassPool pool = ClassPool.getDefault();
        pool.appendClassPath(file);
        CtClass helloJavassist = pool.get("cn.sunway.javassist.HelloJavassist");
        Object o = helloJavassist.toClass().newInstance();
        Method method = o.getClass().getMethod("hello", int.class);
        method.invoke(o, new Object[]{11});
    }
}
