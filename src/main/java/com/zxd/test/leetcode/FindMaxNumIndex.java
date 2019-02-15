package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: 一个数组元素先递增后递减，可能包含重复元素(e.g.:[1,2,3,3,3,4,7,9,5,5,5,5,2])，使用尽量少的时间复杂度找出max number的index
 * @Version 1.0
 * @create 2019-02-15 0:52
 **/
public class FindMaxNumIndex {
    public static void main(String[] args){
        int[] arr = new int[]{1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,7,7,7,7,7,7,7,7,9,8,8,8,8,8,8,5,5,5,5,2,2,2,2,2,2,2};
//        int[] arr = new int[]{1,2,3,3,3,4,7,9,5,5,5,5,2};
//        int[] arr = new int[]{1,2,3,4,7,9,5,2};
        System.out.println(findMax(arr));
        System.out.println(findMaxByCompare(arr));
    }
    public static int findMax(int[] arr){
        int end = arr.length-1;
        int start = 0;
        while (start <= end){
            int mid = (start+end)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }else if((arr[mid] >= arr[mid-1] && arr[mid] < arr[mid+1]) || (arr[mid] > arr[mid-1] && arr[mid] <= arr[mid+1])){
                start = mid +1;
            }else if((arr[mid] < arr[mid-1] && arr[mid] >= arr[mid+1]) || (arr[mid] <= arr[mid-1] && arr[mid] > arr[mid+1])){
                end = mid -1;
            }else if(arr[mid] == arr[mid-1] && arr[mid] == arr[mid+1]){
                for(int i=1;;i++){
                    if(mid-1-i>=0 && mid+1+i<=end){
                        if(arr[mid-1-i] > arr[mid+1+i] ){
                            end = mid -1;
                            break;
                        }else if(arr[mid-1-i] < arr[mid+1+i]){
                            start = mid +1;
                            break;
                        }
                    }else if(mid-1-i>=0){
                        if(arr[mid-1-i] > arr[mid+i] ){
                            end = mid -1;
                            break;
                        }else if(arr[mid-1-i] < arr[mid+i]){
                            start = mid +1;
                            break;
                        }
                    }else if(mid+1+i<=end){
                        if(arr[mid-i] > arr[mid+1+i] ){
                            end = mid -1;
                            break;
                        }else if(arr[mid-i] < arr[mid+1+i]){
                            start = mid +1;
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }


    /**
     * @FileName FindMaxNumIndex.java
     * @ClassName FindMaxNumIndex
     * @MethodName findMaxByCompare
     * @Desc 比对交换查找,校验使用
     * @author zouxiaodong
     * @date 2019/2/15 15:06
     * @Params [arr]
     * @return int
     */
    public static int findMaxByCompare(int[] arr){
        int maxIndex = -1;
        int maxVal = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
