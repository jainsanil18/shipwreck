package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 29-09-2017.
 */

public class cannonball {
    private Bitmap image;
    private int scale1,scale2;
    private int x=GamePanel.smwidth-45;
    private int y=GamePanel.smheight-90;
    public cannonball(Bitmap res)
    {  scale1=30;
        scale2=30;

        image=Bitmap.createScaledBitmap(res,scale1,scale2,true);


    }
    public void update()
    { if(x<GamePanel.width)
    {
        x=x+15;
    }

    }
  public void draw(Canvas canvas)
  {
      canvas.drawBitmap(image,x,y,null);
  }
  public int getXX()
  {
      return x;
  }
    public int getYY()
    {
        return y;
    }
    public int coby()
    {
        return (y+image.getHeight());
    }
    public int cobx()
    {
        return (x+image.getWidth());
    }



}
