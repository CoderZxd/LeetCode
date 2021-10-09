package com.zxd.test.leetcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @ClassName DealWithImage
 * @Description https://www.cnblogs.com/dw3306/p/14527155.html
 *              http://www.vue5.com/java_dip/java_buffered_image.html
 * @Author xiaodong.zou
 * @Date 2021/10/6 19:24
 * @Version 1.0
 */
public class DealWithImage {

    public static void main(String[] args) throws IOException {
//        addCircleImage("D://dog_box.jpg",new int[]{2037,986},100,50,new int[]{255,0,0});
//        addBoxImage("D://dog_box.jpg",new int[]{100,50},new int[]{500,300},40,new int[]{255,0,0});
//        boxImage("D://dog.jpg",10,new int[]{255,255,0});
//        pixelImage("D://dog_box_add_circle.jpg",40,32);
        grayImage("D://dog.jpg");
//        binaryImage("D://dog_40_32.jpg");
//        reverseImage("D://dog_40_32_gray.jpg");
//        reverseImage("D://wallpaper.jpg");
//        grayImageUseAPI("D://dog_40_32.jpg");
//        graphics2D("D://dog.jpg");
    }

    public static void graphics2D(String imagePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        //图片裁剪
        BufferedImage subimage = bufferedImage.getSubimage(500,500,1000,1000);
        String imagePathNew = path+"_sub."+formatName;
        ImageIO.write(subimage, getFormatName(imagePath), new File(imagePathNew));
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.RED);
        //画一条直线
        graphics2D.drawLine(500,500,1500,1500);
        //画折线
        graphics2D.drawPolyline(new int[]{100,500,300},new int[]{100,600,200},3);
        //写字符串
        Font font = new Font("Arial",Font.BOLD,50);
        graphics2D.setFont(font);
        graphics2D.drawString("Hello world",2000,2000);
        //精准定位
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        int height = fontMetrics.getHeight();
        int width = fontMetrics.stringWidth("Hello world");
        graphics2D.drawString("I am zouxiaodong",2000,2000+height);
        //消除字体锯齿
        //消除边缘抗锯齿
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //文本抗锯齿
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //画矩形
        graphics2D.drawRect(700,700,100,200);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.fillRect(1000,500,100,200);
        graphics2D.drawRoundRect(200,200,100,200,40,80);
        //画三维矩形
        graphics2D.draw3DRect(400,400,100,200,true);
        graphics2D.setColor(Color.GREEN);
        graphics2D.fill3DRect(2000,2000,100,200,true);
        //画圆弧
        graphics2D.drawArc(100,40,90,50,180,180);
        graphics2D.setColor(Color.yellow);
        //填充缺右上角的四分之三的椭圆
        graphics2D.fillArc(10,100,40,40,0,-270);
        graphics2D.setColor(Color.green);
        //填充缺左下角的四分之三的椭圆
        graphics2D.fillArc(60,110,110,60,-90,-270);
        //画多边形
        graphics2D.setColor(Color.BLUE);
        int px1[]={50,90,10,50};//首末点相重,才能画多边形
        int py1[]={10,50,50,10};
        int px2[]={140,180,170,180,140,100,110,140};
        int py2[]={5,25,35,45,65,35,25,5};
        graphics2D.setColor(Color.blue);
        graphics2D.fillPolygon(px1,py1,4);
        graphics2D.setColor(Color.red);
        graphics2D.drawPolygon(px2,py2,8);
        //添加图片
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        graphics2D.drawImage(ImageIO.read(new File("D://dog_sub.jpg")),op,500,500);
        //限定作图显示区域
        graphics2D.clipRect(0,0,100,50);
        graphics2D.clipRect(50,25,100,50);
        String imageP = path+"_draw."+formatName;
        ImageIO.write(bufferedImage, getFormatName(imagePath), new File(imageP));
    }

    /**
     * @Author zouxiaodong
     * @Description 给图片加特定颜色和宽度的边框
     * @Date 2021/10/08 15:48
     * @Param [imagePath, boxWidth, colors]
     * @return void
     **/
    public static void boxImage(String imagePath,int boxWidth,int[] colors) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        System.out.println("=======>像素为:"+width+"*"+height);
        start:
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(i<boxWidth || j<boxWidth || i+boxWidth>width || j+boxWidth>height){
                    bufferedImage.setRGB(i,j,colorToRGB(255,colors[0],colors[1],colors[2]));
                }
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_box."+formatName;
        ImageIO.write(bufferedImage, getFormatName(imagePath), new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 指定像素作为中心点画圆
     * @Date 2021/10/08 17:19
     * @Param [imagePath, middlePoint, maxRadius,minRadius,colors]
     * @return void
     **/
    public static void addCircleImage(String imagePath,int[] middlePoint,int maxRadius,int minRadius,int[] colors) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        System.out.println("=======>像素为:"+width+"*"+height);
        start:
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if((middlePoint[0]-i)*(middlePoint[0]-i)+(middlePoint[1]-j)*(middlePoint[1]-j) <= maxRadius*maxRadius &&
                        (middlePoint[0]-i)*(middlePoint[0]-i)+(middlePoint[1]-j)*(middlePoint[1]-j) >= minRadius*minRadius){
                    bufferedImage.setRGB(i,j,colorToRGB(255,colors[0],colors[1],colors[2]));
                }
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_add_circle."+formatName;
        ImageIO.write(bufferedImage, getFormatName(imagePath), new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 在图片的指定坐标画指定宽度的边框
     * @Date 2021/10/08 16:53
     * @Param [imagePath, startPoint, endPoint, boxWidth, colors]
     * @return void
     **/
    public static void addBoxImage(String imagePath,int[] startPoint,int[] endPoint,int boxWidth,int[] colors) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        System.out.println("=======>像素为:"+width+"*"+height);
        start:
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(isPixelInBorder(startPoint,endPoint,boxWidth,i,j)){
                    bufferedImage.setRGB(i,j,colorToRGB(255,colors[0],colors[1],colors[2]));
                }
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_pixel_box."+formatName;
        ImageIO.write(bufferedImage, getFormatName(imagePath), new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 判断像素(x,y)是否在起始像素startPoint和结束像素endPoint,边框宽度为boxWidth的边框上
     * @Date 2021/10/08 16:56
     * @Param [startPoint, endPoint, boxWidth, x, y]
     * @return boolean
     **/
    private static boolean isPixelInBorder(int[] startPoint, int[] endPoint, int boxWidth, int x, int y){
        int[] ld = new int[2];
        int[] ul = new int[2];
        int[] um = new int[2];
        int[] ur = new int[2];
        int[] rm = new int[2];
        int[] rr = new int[2];
        ld[0] = startPoint[0];
        ld[1] = startPoint[1] + boxWidth;
        ul[0] = startPoint[0];
        ul[1] = endPoint[1] - boxWidth;
        um[0] = startPoint[0] + boxWidth;
        um[1] = endPoint[1] - boxWidth;
        ur[0] = endPoint[0];
        ur[1] = endPoint[1] - boxWidth;
        rm[0] = endPoint[0] - boxWidth;
        rm[1] = startPoint[1] + boxWidth;
        rr[0] = endPoint[0];
        rr[1] = startPoint[1] + boxWidth;
        if(x>= ul[0] && x<=endPoint[0] && y>=ul[1] && y<=endPoint[1] ||
                x>= ld[0] && x<=um[0] && y>=ld[1] && y<=um[1] ||
                x>= startPoint[0] && x<=rr[0] && y>=startPoint[1] && y<=rr[1] ||
                x>= rm[0] && x<=ur[0] && y>=rm[1] && y<=ur[1]){
            return true;
        }
        return false;
    }

    /**
     * @Author zouxiaodong
     * @Description 照片像素化
     * @Date 2021/10/08 10:40
     * @Param [x, y]
     * @return void
     **/
    public static void pixelImage(String imagePath,int x,int y) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
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
//                            int red =  (0xff0000 & rgb) >> 16;
//                            int green = (0xff00 & rgb) >> 8;
//                            int blue =  (0xff & rgb);
//                            System.out.println(String.format("value:%d,red:%d,green:%d,blue:%d",value,red,green,blue));
                            bufferedImage.setRGB(m,n,list.get(0).getKey());
                        }
                    }
                }
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_"+x+"_"+y+"."+formatName;
        ImageIO.write(bufferedImage, getFormatName(imagePath), new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 翻转照片
     * @Date 2021/10/08 10:40
     * @Param []
     * @return void
     **/
    public static void reverseImage(String imagePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        start:
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                int m = width-i-1;
                int n = height-j-1;
                if(i<=m){
                    int rgb = bufferedImage.getRGB(i,j);
                    bufferedImage.setRGB(i,j,bufferedImage.getRGB(m,n));
                    bufferedImage.setRGB(m,n,rgb);
                }else {
                    break start;
                }
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_reverse."+formatName;
        ImageIO.write(bufferedImage,formatName, new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 灰度化
     * @Date 2021/10/08 10:53
     * @Param [imagePath]
     * @return java.awt.image.BufferedImage
     **/
    public static void grayImage(String imagePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage grayImage = new BufferedImage(width,height,bufferedImage.getType());
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
//                int rgb = bufferedImage.getRGB(i,j);
//                int red = (rgb >> 16) & 0xff;
//                int green = (rgb >> 8) & 0xff;
//                int blue = rgb & 0xff;
                Color color = new Color(bufferedImage.getRGB(i,j));
                int gray = (int)(0.3*color.getRed()+0.59*color.getGreen()+0.11*color.getBlue());
                int pixelRgb = colorToRGB(255,gray,gray,gray);
                grayImage.setRGB(i,j,pixelRgb);
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_gray."+formatName;
        ImageIO.write(grayImage, formatName, new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 调用API进行图片灰度处理
     * @Date 2021/10/08 14:20
     * @Param [imagePath]
     * @return void
     **/
    public static void grayImageUseAPI(String imagePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        bufferedImage = op.filter(bufferedImage, null);
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_gray_api."+formatName;
        ImageIO.write(bufferedImage, formatName, new File(imagePathNew));
    }

    /**
     * @Author zouxiaodong
     * @Description 颜色分量转换为RGB值
     * @Date 2021/10/08 10:52
     * @Param [alpha, red, green, blue]
     * @return int
     **/
    private static int colorToRGB(int alpha,int red,int green,int blue){
        int pixel = 0;
        pixel += alpha;
        pixel = pixel << 8;
        pixel += red;
        pixel = pixel << 8;
        pixel += green;
        pixel = pixel << 8;
        pixel += blue;
        return  pixel;
    }

    /**
     * @Author zouxiaodong
     * @Description 黑白处理
     * @Date 2021/10/08 13:37
     * @Param [imagePath]
     * @return void
     **/
    public static void binaryImage(String imagePath) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int black = new Color(0,0,0).getRGB();
        int white = new Color(255,255,255).getRGB();
        BufferedImage binaryImage = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_BINARY);
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                int rgb = bufferedImage.getRGB(i,j);
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;
                int avg = (red+green+blue)/3;
                //阈值,白底黑字还是黑底白字,大多数情况建议白底黑字
                if(avg<192){
                    binaryImage.setRGB(i,j,black);
                }else{
                    binaryImage.setRGB(i,j,white);
                }
            }
        }
        String formatName = getFormatName(imagePath);
        String path = imagePath.replaceAll("\\." + formatName, "");
        String imagePathNew = path+"_binary."+formatName;
        ImageIO.write(binaryImage,formatName, new File(imagePathNew));
    }

    private static String getFormatName(String imagePath){
        String[] strings = imagePath.split("\\.");
        return strings[strings.length-1];
    }
}
