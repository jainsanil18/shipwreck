 package com.example.killbill.shipwreck;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

import static android.graphics.Rect.intersects;

/**
 * Created by killbill on 05-07-2017.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    private MainThread thread;
    private background bb;
    private wave b;
    private ArrayList<cannon> c;
    private ArrayList<obstacle> ro;
    private Rect r;
    private boolean puff=false;
private ArrayList<cannonball> can;
    private button1 but;
    private Ship sh;
    private ArrayList<smoke> sm;
    int yy=0;
    private long start,startob;
 public static long start1;
    public static long start2;
public static  int smheight,smwidth;
    public static long speedset;
    // DisplayMetrics display=new DisplayMetrics();
    //((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(display);

   public static final int width= Resources.getSystem().getDisplayMetrics().widthPixels;
   public static final int height= Resources.getSystem().getDisplayMetrics().heightPixels;
    //final int height=display.heightPixels;

    public GamePanel(Context context)
    {
        super(context);


        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        while(retry)
        {
            try{thread.setRunning(false);
                thread.join();

            }catch(InterruptedException e){e.printStackTrace();}
            retry = false;
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

bb=new background(BitmapFactory.decodeResource(getResources(),R.drawable.untitled31));
        b=new wave(BitmapFactory.decodeResource(getResources(),R.drawable.waves));
        c=new ArrayList<cannon>();
        sh=new Ship(BitmapFactory.decodeResource(getResources(),R.drawable.ship));
//c=new cannon(BitmapFactory.decodeResource(getResources(),R.drawable.balll));
        sm=new ArrayList<smoke>();
       but=new button1(BitmapFactory.decodeResource(getResources(),R.drawable.button_1));

        can=new ArrayList<cannonball>();
        ro=new ArrayList<obstacle>();
        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();
        bb.set(-5);
        b.setw(-10);

      start=System.nanoTime();
startob=System.nanoTime();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int count=event.getPointerCount();

       for ( int i = 0; i < count; i++) {
           int x = (int) event.getX(i);
           int y = (int) event.getY(i);


           int actionPerformed = event.getActionMasked();

           switch (actionPerformed) {
               case MotionEvent.ACTION_DOWN:

                   if (x > (width - 600) && y > (height - 600)) {
                       puff = true;
                       smheight = sh.wy();
                       smwidth = sh.wx();
                       can.add (new cannonball(BitmapFactory.decodeResource(getResources(),R.drawable.balll)));}
                   
                       sh.setplaying(true);
                   b.setplayingw(true);
                   start1 = System.nanoTime() / 1000000000;


                   break;


               case MotionEvent.ACTION_UP:
                   sh.setplaying(false);
                   start2 = System.nanoTime() / 1000000000;

                   b.setplayingw(false);
                   break;

               case MotionEvent.ACTION_POINTER_DOWN:


                   if (x > (width - 600) && y > (height - 600)) {
                       puff = true;
                       smheight = sh.wy();
                       smwidth = sh.wx();
                      can.add (new cannonball(BitmapFactory.decodeResource(getResources(),R.drawable.balll)));


                   }
                   break;

               case MotionEvent.ACTION_POINTER_UP:
                   puff = false;

                   break;

           }
       }               return true;

    }

    public void update()
    {
        bb.update();
        Rect d=new Rect(sh.getwX(),sh.getwY(),sh.wx(),sh.wy());
       // if(puff) sm.update();}
        sh.update();
        b.update();
        but.update();

if((System.nanoTime()-start)/1000000>3000)
{ c.add(new cannon(BitmapFactory.decodeResource(getResources(),R.drawable.balll)));
    start=System.nanoTime();

}
if((System.nanoTime()-startob)/1000000>10000)
{
    ro.add(new obstacle(BitmapFactory.decodeResource(getResources(),R.drawable.rock)));
    startob=System.nanoTime();
}

        speedset=b.setspeed();

for(int i=0;i<c.size();i++)

{
    r=new Rect(c.get(i).getX(),c.get(i).getY(),c.get(i).ix(),c.get(i).iy());

    c.get(i).update();
if(intersects(d,r)|| c.get(i).getX()>width|| c.get(i).getY()>height)
{
    c.remove(i);
}
}
        for(int k=0;k<ro.size();k++)
        {
        ro.get(k).update();}
        for (int j=0;j<can.size();j++)
        {can.get(j).update();}
            for(int k=0;k<ro.size();k++)
            {
            Rect ob=new Rect(ro.get(k).getobX(),ro.get(k).getobY(),ro.get(k).obx(),ro.get(k).oby());
for (int j=0;j<can.size();j++)
{ Rect bullet=new Rect(can.get(j).getXX(),can.get(j).getYY(),can.get(j).cobx(),can.get(j).coby());

    if(can.get(j).getXX()>width)
    {
        can.remove(j);
    }
    if(intersects(ob,bullet))
    {
        can.remove(j);

  sm.add (new smoke(BitmapFactory.decodeResource(getResources(),R.drawable.smoke24),BitmapFactory.decodeResource(getResources(),R.drawable.smoke25),BitmapFactory.decodeResource(getResources(),R.drawable.smoke26)));
        sm.get(k).getit(ro.get(k).getobX());
        ro.remove(k);
    }

}}
        for(int g=0;g<sm.size();g++)
        {
            sm.get(g).update();
            if(sm.get(g).end())
            {
                sm.remove(g);
            }


        }
}
    @Override
    public void draw(Canvas canvas)
    {
        /*final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFactorY = getHeight()/HEIGHT;
        if(canvas!=null) {
            final int savedState = canvas.save();*/
if(yy==0) {
    bb.draw(canvas);
}
       // if(puff) {sm.draw(canvas)}
sh.draw(canvas);

        for(cannon sp:c) {
            sp.draw(canvas);
        }
        for(obstacle obst:ro)
        {
            obst.draw(canvas);
        }
        b.draw(canvas);
        for(smoke smo:sm)
        {
            smo.draw(canvas);
        }
        for(cannonball ss:can)
        {
            ss.draw(canvas);
        }
        but.draw(canvas);
         // canvas.restoreToCount(savedState);

        }
    }


