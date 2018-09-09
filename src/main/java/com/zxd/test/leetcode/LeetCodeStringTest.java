package com.zxd.test.leetcode;

/**
 * @Project war-fx-glt2stage-demo
 * @Package com.zxd.test.leetcode
 * @Author：zouxiaodong
 * @Description:
 * @Date:Created in 2:36 2018/9/7.
 */
public class LeetCodeStringTest {

//    反转字符串
//    编写一个函数，其作用是将输入的字符串反转过来。
//
//    示例 1:
//
//    输入: "hello"
//    输出: "olleh"
//    示例 2:
//
//    输入: "A man, a plan, a canal: Panama"
//    输出: "amanaP :lanac a ,nalp a ,nam A"
    public static String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        String[] array = s.split("");
//        char[] sss = s.toCharArray();
        int length = array.length;
        for(int i=0;i<length;i++){
            int j = length-1-i;
            if(j>i){
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


//    颠倒整数
//    给定一个 32 位有符号整数，将整数中的数字进行反转。
//
//    示例 1:
//    输入: 123
//    输出: 321

//    示例 2:
//    输入: -123
//    输出: -321

//    示例 3:
//    输入: 120
//    输出: 21
//    注意:
//
//    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
    public static int reverse(int x) {
        String prefix = "";
        String s = String.valueOf(x);
        if(s.startsWith("-")){
            prefix = "-";
            s = s.substring(1);
        }
        StringBuffer sb = new StringBuffer();
        String[] array = s.split("");
        int length = array.length;
        for(int i=0;i<length;i++){
            int j = length-1-i;
            if(j>i){
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            sb.append(array[i]);
        }
        s = sb.toString();
        if(s.length()>1 && s.startsWith("0")){
            s = s.substring(1);
        }
        String result = prefix+s;
        if(Long.parseLong(result)> Integer.MAX_VALUE || Long.parseLong(result) < Integer.MIN_VALUE){
            return 0;
        }
        return Integer.parseInt(result);
    }

//    字符串中的第一个唯一字符
//    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//    案例:
//
//    s = "leetcode"
//    返回 0.
//
//    s = "loveleetcode",
//    返回 2.
//
//
//    注意事项：您可以假定该字符串只包含小写字母。
    public static int firstUniqChar(String s) {
        int length = s.length();
        if(length == 1){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1 && !"1".equals(String.valueOf(s.charAt(i)))){
                return i;
            }else if(i!=s.length()-1 && "1".equals(String.valueOf(s.charAt(i)))){
                continue;
            }else if(i==s.length()-1){
                return -1;
            }
            char c = s.charAt(i);
            String temp = s.substring(i+1);
            if(temp.indexOf(c) < 0){
                return i;
            }else{
                s = s.replaceAll(String.valueOf(c),"1");
            }
        }
        return -1;
    }

    public static void main(String[] args){
//        String ss = "A man, a plan, a canal: Panama";
//        reverseString(ss);
//        System.out.println(reverse(0));
        System.out.println(firstUniqChar("leetcode"));
    }
}
