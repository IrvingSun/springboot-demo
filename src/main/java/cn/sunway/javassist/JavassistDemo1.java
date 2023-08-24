package cn.sunway.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;

import java.io.IOException;

/**
 * @author sunw
 * @date 2023/8/22
 */
public class JavassistDemo1 {

    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("cn.sunway.javassist.TestClass");
        ctClass.writeFile("./");
    }
}
