package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 11-07-2017.
 */

public class background {
    private Bitmap image1;
    private int y,scale ,newheight,newwidth;
private int dx;
    private int x=0;
    public background(Bitmap res) {

          scale=res.getHeight()/GamePanel.height;
         newheight=(res.getHeight()/scale);
             newwidth=GamePanel.width;
         image1=Bitmap.createScaledBitmap(res,newwidth ,newheight,true);
    }

    public void update() {
        y = 0;
        //x+=dx;
       // if(x<-GamePanel.width)
        x=0;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image1, x, y, null);
/*if(x<0)
{
canvas.drawBitmap(image1,x+GamePanel.width,y,null);
}*/
    }
public void set(int dx){
    this.dx=dx;
}
}