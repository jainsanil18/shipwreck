package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 28-08-2017.
 */

public class wave {
    private int dx;
    private long dxx;
    private int y,scale,newheight,newwidth;
    private Bitmap image;
    private boolean playing;
    private long x;
    public wave(Bitmap res)
    {
        scale=res.getHeight()/GamePanel.height;
        newheight=(res.getHeight()/scale);
        newwidth=GamePanel.width;
        image=Bitmap.createScaledBitmap(res,newwidth ,newheight,true);
    }
    public void update()
    { y = 0;
        if(playing) {

if(dxx<15) {
    x = x + dx - (5 * ((System.nanoTime() / 1000000000 - GamePanel.start1) * (System.nanoTime() / 1000000000 - GamePanel.start1)) / 10);

    dxx =dx- 5 * ((System.nanoTime() / 1000000000 - GamePanel.start1) * (System.nanoTime() / 1000000000 - GamePanel.start1)) / 10;
}
       else
                {x=x+dx-15;
                dxx=dx-15;}}
        else {x=x+dx;
        dxx=dx;}
        if(x<-GamePanel.width)
        {x=0;
        }


    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,x,y,null);
        if(x<0)
        {
            canvas.drawBitmap(image,x+GamePanel.width,y,null);
        }
    }

    public void setw (int dx){
        this.dx=dx;
    }
    public void setplayingw(boolean d)
    {
        playing=d;
    }
    public long setspeed()
    {
        return dxx;
    }}

