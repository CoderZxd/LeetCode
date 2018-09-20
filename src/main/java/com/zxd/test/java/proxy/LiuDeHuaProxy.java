package com.zxd.test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Project LeetCode
 * @Package com.zxd.test.java.proxy
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 14:38 2018/9/20.
 */
public class LiuDeHuaProxy {

    private Person ldh = new LiuDeHua();

    public Person getProxy(){
        return (Person) Proxy.newProxyInstance(LiuDeHuaProxy.class.getClassLoader(), ldh.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sing")){
                    System.out.println("我是他的经纪人，要找他唱歌得先给十万块钱！！");
                }
                if(method.getName().equals("dance")){
                    System.out.println("我是他的经纪人，要找他跳舞得先给二十万块钱！！");
                }
                return method.invoke(ldh,args);
            }
        });
    }

    /**
     * test code
     * @param args
     */
    public static void main(String[] args){
        LiuDeHuaProxy proxy = new LiuDeHuaProxy();
        Person ldh = proxy.getProxy();
        System.out.println(ldh.sing("冰雨"));
        System.out.println(ldh.dance("江南style"));
    }
}
