package com.example.killbill.shipwreck;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by killbill on 27-09-2017.
 */

public class button1 {

    private Bitmap image;
    private int x=GamePanel.width-300;
    private int y =GamePanel.height-300;

    public  button1 (Bitmap res)
    {
        image=res;
    }
public void update()
{


}
public void draw(Canvas canvas)
{
   canvas.drawBitmap (image,x,y,null);
}



}
