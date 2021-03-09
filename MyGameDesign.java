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

/**
 * @author ZMQ-20
 */
public class MyGameDesign extends GameCanvas implements Runnable{
    private Image coupleImg;
    private  int coupleX;
    private int coupleY;
    private int dx = 1;
    private int dy = 1;
    public final int CENTER_X = getWidth()/2;
    public final int CENTER_Y = getHeight()/2;
   
    public MyGameDesign()
    {
        super(true);
    }

    public void start()
    {
        try {
           coupleImg = Image.createImage("/im2.png");
           coupleX = CENTER_X;
           coupleY = CENTER_Y;
      
        } catch (IOException e) { System.err.println("Error Occured :"+e);
        }
        
        Thread runner = new Thread(this);
        runner.start();
    }
    
        public void run()
        {
            
               while(true)
               {
                   verifyGameState();
                   
                   checkUserInput();
                   
                   updateGameScreen(getGraphics());
                   
                   try {
                       Thread.currentThread().sleep(1);
                   } catch (Exception e) {
                   }
               }
        }
//GEN-LINE:|fields|0|

//GEN-LINE:|methods|0|
            private void verifyGameState()
            {
                
            }
            private void checkUserInput()
            {
                int keyState = getKeyStates();
                
                calculatemove(keyState);
                
             
            }
            
            private void updateGameScreen(Graphics g)
            {
                g.setColor(0xffffff);
                g.fillRect(0, 0, getWidth(), getHeight());
                
               g.drawImage(coupleImg,coupleX, coupleY, Graphics.HCENTER|Graphics.BOTTOM);

                flushGraphics();
            }
    
            private void calculatemove(int keyState)
            {

                        if((keyState & LEFT_PRESSED) != 0 ) {
                            coupleX = Math.max(95,coupleX - dx);
                          System.out.println("x- "+coupleX);
                        }
                        else if((keyState & RIGHT_PRESSED) != 0) {
                           coupleX =Math.min(145, coupleX + dx);
                            System.out.println("x+ "+coupleX);
                        }
                            else if((keyState & UP_PRESSED)!=0 ){

                          coupleY = Math.max(145,coupleY - dy);
                          System.out.println("y -"+coupleY);

                          } else if((keyState & DOWN_PRESSED)!=0 ) {

                          coupleY =Math.min(345, coupleY + dy);
                           System.out.println("Y+"+coupleY);
                        }
                }
      }
              

            
                    

