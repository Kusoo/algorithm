package agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by l81022078 on 2017/8/23.
 */
public class Main implements InvocationHandler{
    private Object hello;

    public Main(Object hello){
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("into");
        Object result = method.invoke(hello, args);
        System.out.println("out");
        return result;
    }

    public static void main(String[] args) {
        IHello hello = new HelloImpl();
        InvocationHandler handler = new Main(hello);
        IHello proxy = (IHello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxy.sayHello();
    }
}
