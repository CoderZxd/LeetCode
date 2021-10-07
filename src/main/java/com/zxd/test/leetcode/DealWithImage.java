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
        pixelImage(6,8);
        pixelImage(12,16);
        pixelImage(24,32);
    }

    //像素画照片
    public static void pixelImage(int x,int y) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("D://IMG_4817.JPG"));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        System.out.println("=======>像素为:"+width+"*"+height);
        start:
        for(int i=0;i<width;i=i+x){
            for(int j=0;j<height;j=j+y){
                Map<Integer,Integer> valueToNums = new HashMap<>(x*y*2);
                for(int m=i;m<i+x;m++){
                    for(int n=j;n<j+y;n++){
                        if(m<width && n<height){
                            valueToNums.put(bufferedImage.getRGB(m,n),valueToNums.getOrDefault(bufferedImage.getRGB(m,n),0)+1);
                        }
                    }
                }
                List<Map.Entry<Integer,Integer>> list = new ArrayList<>(valueToNums.entrySet());
                Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
                for(int m=i;m<i+x;m++){
                    for(int n=j;n<j+y;n++){
                        if(m<width && n<height){
//                            Integer rgb = list.get(0).getKey();
//                            int value = (0xff000000 & rgb) >>> 24;
//                            int red =  (0x00ff0000 & rgb) >> 16;
//                            int green = (0x0000ff00 & rgb) >> 8;
//                            int blue =  (0x000000ff & rgb);
//                            System.out.println(String.format("value:%d,red:%d,green:%d,blue:%d",value,red,green,blue));
                            bufferedImage.setRGB(m,n,list.get(0).getKey());
                        }
                    }
                }
            }
        }
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = it.next();
        File f = new File("D://test_"+x+"_"+y+".JPG");
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
