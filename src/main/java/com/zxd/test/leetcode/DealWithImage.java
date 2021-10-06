package com.zxd.test.leetcode;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName DealWithImage
 * @Description TODO
 * @Author xiaodong.zou
 * @Date 2021/10/6 19:24
 * @Version 1.0
 */
public class DealWithImage {

    //翻转照片
    public static void main_reverse(String[] args) throws IOException {

    }

    public static void main(String[] args) throws IOException {
        pixelImage(1);
        pixelImage(2);
        pixelImage(4);
        pixelImage(8);
        pixelImage(12);
        pixelImage(16);
        pixelImage(20);
        pixelImage(24);
        pixelImage(28);
        pixelImage(32);
    }

    //像素画照片
    public static void pixelImage(int x) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("D://IMG_4817.JPG"));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        start:
        for(int i=0;i<width;i=i+x){
            for(int j=0;j<height;j=j+x){
                Map<Integer,Integer> valueToNums = new HashMap<>(x*x*2);
                for(int m=i;m<i+x;m++){
                    for(int n=j;n<j+x;n++){
                        if(m<width && n<height){
                            valueToNums.put(bufferedImage.getRGB(m,n),valueToNums.getOrDefault(bufferedImage.getRGB(m,n),0)+1);
                        }
                    }
                }
                List<Map.Entry<Integer,Integer>> list = new ArrayList<>(valueToNums.entrySet());
                Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
                for(int m=i;m<i+x;m++){
                    for(int n=j;n<j+x;n++){
                        if(m<width && n<height){
                            bufferedImage.setRGB(m,n,list.get(0).getKey());
                        }
                    }
                }
            }
        }
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = it.next();
        File f = new File("D://test_"+x+".JPG");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bufferedImage);
        ios.flush();
        ios.close();
    }

    //翻转照片
    public static void reverseImage() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("D://IMG_4817.JPG"));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        start:
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                int m = width-i-1;
                int n = height-j-1;
                if(i<m || j<n){
                    int rgb = bufferedImage.getRGB(i,j);
                    bufferedImage.setRGB(i,j,bufferedImage.getRGB(m,n));
                    bufferedImage.setRGB(m,n,rgb);
                }else {
                    break start;
                }

            }
        }
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = it.next();
        File f = new File("D://test02.JPG");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bufferedImage);
        ios.flush();
        ios.close();
    }
}
