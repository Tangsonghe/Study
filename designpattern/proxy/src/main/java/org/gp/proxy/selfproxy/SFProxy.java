package org.gp.proxy.selfproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 生成代码的工具类
 * @author: Spark_tang
 * @time: 2020/3/3 20:57
 */
public class SFProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(SFClassLoader classLoader, Class<?>[] interfaces, SFInvocationHandler handler) {

        // 动态生成java代码字符串
        String javaStr = generateSrcJava(interfaces);
        // 输出代码到磁盘
        String filePath = SFProxy.class.getResource("").getPath();
        File f = new File(filePath + "$Proxy0.java");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write(javaStr);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //3、把生成的$Proxy0.java文件编译成$Proxy0.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manage.getJavaFileObjects(f);

        JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
        task.call();
        try {
            manage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4、编译生成的.class文件加载到JVM中来
        Class proxyClass = null;
        try {
            proxyClass = classLoader.findClass("$Proxy0");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Constructor c = proxyClass.getConstructor(SFInvocationHandler.class);
            return c.newInstance(handler);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrcJava(Class<?>[] interfaces) {

        StringBuffer code = new StringBuffer();

        // 包目录
        code.append("package " + SFProxy.class.getPackage().getName() + ";" + ln);
        // 导入反射包
        code.append("import java.lang.reflect.*;" + ln);
        // 导入接口
        code.append("import " + interfaces[0].getName() + ";" + ln);
        // 定义类名
        code.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
            // 定义自己的invokcationHandler
            code.append("private SFInvocationHandler h;" + ln);
            // 构造函数
            code.append("public $Proxy0(SFInvocationHandler h) {" + ln);
            code.append("this.h = h;" + ln);
            code.append("}" + ln);

            // 方法
            for (Method m : interfaces[0].getMethods()) {
                // 获取参数
                Class<?>[] parameterTypes = m.getParameterTypes();

                StringBuffer methodParams = new StringBuffer();
                StringBuffer paramTypes = new StringBuffer();
                StringBuffer paramValues = new StringBuffer();
                for (Class clazz : parameterTypes) {
                    // 参数的类型 例如:java.lang.Integer
                    String paramType = clazz.getName();
                    // 参数对象名字 首字母小写 integer
                    String param = toLowerFirstName(clazz.getSimpleName());
                    methodParams.append(paramType + " " + param).append(",");
                    paramTypes.append(paramType).append(",");
                    paramValues.append(param).append(",");
                }

                String medParam = methodParams.substring(0, methodParams.length() - 1);
                String paramType = paramTypes.substring(0, paramTypes.length() - 1);
                String paramValue = paramValues.substring(0, paramValues.length() - 1);

                // 定义方法
                code.append("public " + m.getReturnType().getName() + " " + m.getName() + "("+ medParam +") {" + ln);
                    code.append("try{" + ln);
                        // 反射获得接口中的方法
                        code.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", " + "new Class[]{Class.forName(\""+ paramType + "\")});" + ln);
                        // 反射执行方法
                        code.append((hasReturn(m.getReturnType().getName()) ? "return " : "") + castRetuValue("this.h.invoke(this, m, new Object[]{"+paramValue+"});", m.getReturnType()) + ln);
                    code.append("} catch(Error _ex) { }" + ln);
                    code.append("catch(Throwable e) {" + ln);
                    code.append("System.out.println(e);" + ln);
                    code.append("}" + ln);
                    // 如果报错异常，返回值
                    code.append(returnDefaultVal(m.getReturnType()));
                code.append("}" + ln);

            }
        // 大括号结尾
        code.append("}");

        return code.toString();
    }

    private static String returnDefaultVal(Class<?> returnType) {
        if (returnType == void.class) {
            return "";
        }
        else {
            Object obj = typeMap.get(returnType);
            if (obj == null) {
                return "null";
            }
            else {
                return obj.toString();
            }
        }
    }

    private static Map<Class, Object> typeMap = new HashMap<>();
    static {
        typeMap.put(int.class, 0);
        typeMap.put(char.class, 0);
        typeMap.put(double.class, 0d);
        typeMap.put(float.class, 0f);
        typeMap.put(byte.class, 0);
        typeMap.put(long.class, 0l);
        typeMap.put(boolean.class, false);
    }

    private static Map<Class, Class> map = new HashMap<>();
    static {
        map.put(int.class, Integer.class);
        map.put(char.class, Character.class);
        map.put(double.class, Double.class);
        map.put(float.class, Float.class);
        map.put(byte.class, Byte.class);
        map.put(long.class, Long.class);
        map.put(boolean.class, Boolean.class);
    }

    private static String castRetuValue(String code, Class<?> returnType) {
        if (returnType != void.class) {
            Class clazz = map.get(returnType);
            if (clazz != null) {
                code = "("+ clazz.getName() +") code";
            }
            else {
                code = "("+ returnType.getName() +") code";
            }
        }

        return code;
    }

    private static boolean hasReturn(String name) {
        return !name.equals("void");
    }

    private static String toLowerFirstName(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
