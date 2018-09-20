package com.zxd.test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-09-20 0:24
 **/
public class ProxyTest {
    public static void main(String[] args){
        Object[] elements = new Object[1000];
        for(int i=0;i<elements.length;i++){
            Integer integer = i+1;
            InvocationHandler invocationHandler = new TraceHandler(integer);
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},invocationHandler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length)+1;
        int result = Arrays.binarySearch(elements,key);
        if(result>=0){
            System.out.println(elements[result]);
        }
    }

}

class TraceHandler implements InvocationHandler{

    private Object target;

    public TraceHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("."+method.getName()+"(");
        if(null != args){
            for(int i=0;i<args.length;i++){
                System.out.print(args[i]);
                if(i<args.length-1){
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target,args);
    }
}