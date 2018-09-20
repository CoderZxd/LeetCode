package com.zxd.test.java;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.java.proxy
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-09-21 0:16
 **/
public class SimpleFrameTest {
    public static void main(String[] args){
        SimpleFrame simpleFrame = new SimpleFrame();
        simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        simpleFrame.setTitle("Test");
        simpleFrame.setVisible(true);
    }
}

class SimpleFrame extends JFrame{

    public SimpleFrame(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;
        setSize(screenWidth,screenHeight);
//        setLocationByPlatform(true);
        setLocation(0,0);
        setTitle("Test JFrame");
        Image image = new ImageIcon("D:/link.png").getImage();
        setIconImage(image);
        add(new ImageComponent());
    }
}

class ImageComponent extends JComponent{

    private Image image;

    public ImageComponent(){
        image = new ImageIcon("D:/3.png").getImage();
    }

    public void paintComponent(Graphics g){
        if(image == null){
            return;
        }
        int width = image.getWidth(this);
        int height = image.getWidth(this);
        g.drawImage(image,0,0,null);
        for(int i=0;i*width<=getWidth();i++){
            for(int j=0;j*height<=getHeight();j++){
                if(i+j>0){
                    g.copyArea(0,0,width,height,i*width,j*height);
                }
            }
        }
    }

}
