package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 27-09-2017.
 */

public class smoke {
    private int  y=GamePanel.height-450, i = 0,scale1=250;
    private Bitmap image, image1, image2,img;
   private int x;
    public smoke(Bitmap res, Bitmap res1, Bitmap res2) {
        image=res;
        image1=res1;
        image2=res2;


    }

    public void update() {


    if(i<=30) {

        img = image;

        }
    if(i>30 && i<60) {
        img = image1;
        }
if(i>60) {img = image2;

    }



        i++;
    x = x + Math.round(GamePanel.speedset);
}


    public void draw(Canvas canvas) {
        canvas.drawBitmap(img, x, y, null);
    }

    public boolean end() {

if(i==120)
    return true;
        else
            return false;
    }
    public void getit(int x)
    {
        this.x=x;
    }


}

