/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication1;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ZMQ-20
 */
public class JumpingBallGame extends GameCanvas implements Runnable{
     
    private  int coupleX;
    private int coupleY;
    private int dx = 1;
    private int dy = 1;
    private int rodDx =1;
    private int rodDy =1;
    public final int CENTER_X = getWidth()/2;
    public final int CENTER_Y = getHeight()/2;
    private int rodX = 10;
    private int rodY = 280;
    public int score =0;
    public int life =5;
    private volatile boolean exit = false;
    public int secondBallX = getWidth()/3+22;
    public int secondBallY = getHeight()/3+22;
    public int thirdBallX = (CENTER_X+secondBallX )/2;
    public int thirdBallY = (CENTER_Y+secondBallY)/2;
    public int sdx = 1;
    public int sdy = 1;
    public int tdx = 1;
    public int tdy = 1;
    public int sleepTime;
    public Random random;
    public int red,green,blue;
    public Image img;
   
    public Timer timer;
    public int time = 10;
    
    
    public void start()
    {
       
        try {
       
           img = Image.createImage("/Background.png");
           
            coupleX = CENTER_X;
            coupleY = CENTER_Y;
            sleepTime =0;
        } catch (Exception e) {
     }
        
        Thread th = new Thread(this);
       
        th.start();
    }
   
    public void run() {
        
    while (!exit) 
        {         
          update();
            
           rodKeyStates();
           
            try {
                exit_pause_States(getGraphics());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
           // background(getGraphics());
            updateGameScreen(getGraphics());
            
            increaseSpeed(score);
            
            changeColor();
            
            collisionDetection();
            
            meassage(getGraphics());
         
            repaint();
            try {
                Thread.currentThread().sleep(sleepTime);
            } catch (Exception e) {
            }
        }
        
    }
//GEN-LINE:|fields|0|
        public JumpingBallGame()
        {
           
            super(true);
           random = new Random(); 
            
        }

        public void stop() {
            
      exit = true;
      
   }
        public void update() 
          {   
              {
                    if(coupleY >= 265 || coupleY <= 0)
                    {    
                    dy=-dy;
                    }
                   if(coupleX >= 218 || coupleX <= 0)
                   {
                       dx=-dx;
                   }
                   coupleY=coupleY-dy;
                   coupleX=coupleX-dx;
              }
             {
                    if(secondBallY >= 265 || secondBallY <= 0)
                     {    
                     sdy=-sdy;
                     }
                    if(secondBallX >= 218 || secondBallX <= 0)
                    {
                        sdx=-sdx;
                    }
                    secondBallY=secondBallY-sdy;
                    secondBallX=secondBallX-sdx;
             }
             {
                 if(thirdBallY >= 265 || thirdBallY <= 0)
                     {    
                     tdy=-tdy;
                     }
                    if(thirdBallX >= 218 || thirdBallX <= 0)
                    {
                        tdx=-tdx;
                    }
                    thirdBallY=thirdBallY-tdy;
                    thirdBallX=thirdBallX-tdx;
             }
         } 

  
    private void updateGameScreen(Graphics g) {
       
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, getWidth(), getHeight());
      
        
        g.setColor(red, green, blue);
        g.fillArc(coupleX, coupleY, 15, 15, 0, 360);
        
        g.setColor(red, green, blue);       
        g.fillArc(secondBallX, secondBallY,15, 15, 0, 360);
        
        g.setColor(red, green, blue);
        g.fillArc(thirdBallX, thirdBallY,15, 15, 0, 360);
        g.setColor(0xBDBDBD);
        g.fillRect(rodX, rodY, 60, 8);
        g.setColor(0x212121);
        g.drawRect(rodX, rodY, 60, 8);
        g.setColor(0, 255, 0);
        g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE));
        g.drawString("Score :"+score, 230, 5, Graphics.RIGHT|Graphics.TOP);
        g.setColor(255, 0, 0);
        g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE));
        g.drawString("Life :"+life, 1, 5, Graphics.LEFT|Graphics.TOP);
       
        
        flushGraphics();
      
    }
    
    public void collisionDetection() {
        if(coupleY >=265)
        {
            score += 100;
        }
        if((coupleX < rodX-30 && coupleY ==265 ) || coupleX >rodX+60 && coupleY ==265)
        {
            life = life -1;
            score = score -100;
            
        }
           
    }
     public void meassage(Graphics g1)
         {
             
            if(life<1)
            {
                life =0;
                g1.setColor(255, 255, 255);
                g1.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
                    g1.drawString("Game Over & Your Score is: "+score, getWidth()/2, getHeight()/2, Graphics.HCENTER|Graphics.BOTTOM);
                 
                   stop();                  
            }
         }
     
     public void background(Graphics g)
     {
       //  g.drawImage(img, 120, 160, Graphics.HCENTER|Graphics.VCENTER);
     }
     
    private void rodKeyStates() {
        int keyState = getKeyStates();
          if((keyState & LEFT_PRESSED) != 0 ) {
              
                          rodX = Math.max(-1,rodX - rodDx);
                          
                        }
                        else if((keyState & RIGHT_PRESSED) != 0) {
                          
                            rodX =Math.min(182, rodX + rodDx);
                         
                           
                         
                        }
    }

    private void exit_pause_States(Graphics graphics) throws InterruptedException {
        int exitKey = getKeyStates();
        
        if((exitKey & FIRE_PRESSED)!=0)
        {
           
            graphics.setColor(255, 0, 0);
            graphics.drawString("Wait for 10 seconds : ", getWidth()/2, getHeight()/2, Graphics.HCENTER|Graphics.TOP);
            Thread.sleep(10000);
            
           
       }
         
    }

    private void increaseSpeed(int sc) {
            if(sc >=500)
            {
                sleepTime -=50;
                
            }
            else if(sc>=1000)
            {
                sleepTime -=100;
            }
            else if(sc>=1500)
            {
                sleepTime -=150;
            }
            else if(sc>=2000)
            {
                sleepTime -=200;
            }
    }

    public void changeColor() {
        red = (random.nextInt()>>>1 )% 256;
        green = (random.nextInt()>>>1 )% 256;
        blue =(random.nextInt()>>>1 )% 256;
    }


//GEN-LINE:|methods|0|
}
