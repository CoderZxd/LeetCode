package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/fizz-buzz/
 * @Author zouxiaodong
 * @Date 2021/10/13 11:27
 */
//412. Fizz Buzz
//        写一个程序，输出从 1 到 n 数字的字符串表示。
//
//        1. 如果 n 是3的倍数，输出“Fizz”；
//
//        2. 如果 n 是5的倍数，输出“Buzz”；
//
//        3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
//
//        示例：
//
//        n = 15,
//
//        返回:
//        [
//        "1",
//        "2",
//        "Fizz",
//        "4",
//        "Buzz",
//        "Fizz",
//        "7",
//        "8",
//        "Fizz",
//        "Buzz",
//        "11",
//        "Fizz",
//        "13",
//        "14",
//        "FizzBuzz"
//        ]
public class FizzBuzz_412 {

    public static void main(String[] args) {
        FizzBuzz_412 fizzBuzz_412 = new FizzBuzz_412();
        List<String> strings = fizzBuzz_412.fizzBuzz(15);
        System.out.println(strings);
    }

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}
