package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 29-09-2017.
 */

public class obstacle {
    private int scale1,scale2,xx;
    private Bitmap image;
    private float x=2300;
    private int y=GamePanel.height-450;

    public obstacle(Bitmap res) {
        scale1=300;
        scale2=300;

        image=Bitmap.createScaledBitmap(res,scale1,scale2,true);
    }

    public void update()
    {
        x = x +GamePanel.speedset;
xx=Math.round(x);
    }
    public void draw(Canvas canvas)
    {
canvas.drawBitmap(image,x,y,null);
    }
    public int getobX()
    {return xx;}

    public int getobY()
    {
        return y;
    }
    public int oby()
    {
        return (y+image.getHeight());
    }
    public int obx()
    {
        return (xx+image.getWidth());
    }
}
