package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

/**
 * Created by killbill on 29-08-2017.
 */

public class cannon {


    Random r=new Random();
private Bitmap image3;
    private int x,yy;
    private float y=-100;
private int dy;
    private int dx=3;
private long start=System.nanoTime()/1000000000;

public cannon (Bitmap res)
{
    image3=res;
    x=r.nextInt(1900);
    dy=r.nextInt(4)+5;
    if(x>GamePanel.width/2)
    {
        dx=-3;
    }
    if(x<=GamePanel.width/2)
    {
    dx=3;}
}
public void  update( )

{x=x+dx;
       y=y -(dy*(start-(System.nanoTime()/1000000000)));
yy=Math.round(y);
}
public void draw(Canvas canvas)
{
    canvas.drawBitmap(image3,x,y,null);

}
public int getX()
{return x;}

public int getY()
{
    return yy;
}
public int iy()
{
    return (yy+image3.getHeight());
}
public int ix()
{
    return (x+image3.getWidth());
}
}
//332