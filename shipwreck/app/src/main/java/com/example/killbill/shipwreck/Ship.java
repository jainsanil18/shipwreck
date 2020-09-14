package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 04-09-2017.
 */

public class Ship {


private int y=GamePanel.height-450;

     boolean playing;
    private Bitmap image;
    private long dx;
    private float  x=GamePanel.width/2;
    private long start;
    private int xx;
    public Ship (Bitmap res)
    {
        image =res;
    }
    public void update()
    {
        if(playing)
        {if(dx<15) {
            x = x + 5+(5 * ((System.nanoTime() / 1000000000 - GamePanel.start1) * (System.nanoTime() / 1000000000 - GamePanel.start1)) / 10);
            dx = 5 * ((System.nanoTime() / 1000000000 - GamePanel.start1) * (System.nanoTime() / 1000000000 - GamePanel.start1)) / 10;
        }
        else
        {
            x=x+15;
        }
        }
        else{
dx=0;

        x=x-10;}
     xx=Math.round(x);
    }
    public void draw(Canvas canvas)
    {
canvas.drawBitmap(image,x,y,null);
    }
    public void setplaying(Boolean d) {
        playing = d;
    }
    public int getwX()
    {return xx;}

    public int getwY()
    {
        return y;
    }
    public int wy()
    {
        return (y+image.getHeight());
    }
    public int wx()
    {
        return (xx+image.getWidth());
    }
}
