/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication1;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author ZMQ-20
 */
public class canvasPractice extends MIDlet {
    
    private boolean midletPaused = false;
    private Display display;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The canvasPractice constructor.
     */
    public canvasPractice() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
//        if (midletPaused) {
//            resumeMIDlet();
//        } else {
//            initialize();
//            startMIDlet();
//        }
//        midletPaused = false;
            Canvas cn =  new myCanvas();
            display =  Display.getDisplay(this);
            
            display.setCurrent(cn);
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    private class myCanvas extends Canvas {
        private String key = "[PRESS KEY]";
        private Image image;
        
        public myCanvas() {
            try
            {
                image = Image.createImage(100,100);
                Graphics g = image.getGraphics();
                g.setColor(110,110,110);
                g.fillArc(10, 10, 50, 50, 120, 120);  
            }catch(Exception e)
            {
                Alert alert = new Alert("Failure","Error Occured",null,null);
                alert.setTimeout(alert.getDefaultTimeout());
                display.setCurrent(alert);
            }
        }

        protected void paint(Graphics g) {
            g.setColor(0, 0, 255);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(255, 0, 0);
            g.drawRect(getWidth()/4, 0, getWidth()/2, getHeight()/4);
            
            g.setStrokeStyle(Graphics.DOTTED);
            g.drawRect(getWidth()/4 + 4, 4, getWidth()/2 - 8, getHeight()/4 -8);
            
            g.setStrokeStyle(Graphics.SOLID);
            g.drawRoundRect(getWidth()/4, getHeight()/2, getWidth()/2, getHeight()/4, 16, 8);
            
            g.setColor(150, 100, 0);
            g.drawLine(0,0, getWidth()-1, getHeight()-1);
            g.drawLine(getWidth()-1, 0, 0, getHeight()-1);
            
            g.setColor(255, 255, 255);
            g.drawString("TOP LEFT", 0, 0, Graphics.TOP|Graphics.LEFT);
            g.drawString("TOP RIGHT", getWidth(), 0, Graphics.TOP|Graphics.RIGHT);
            g.drawString("BOTTOM LEFT", 0, getHeight(), Graphics.BOTTOM|Graphics.LEFT);
            g.drawString("BOTTOM RIGHT", getWidth(), getHeight(), Graphics.BOTTOM|Graphics.RIGHT);
            
            g.setColor(0, 255, 0);
            g.drawString("ZMQ", getWidth()/2,5, Graphics.HCENTER|Graphics.TOP);
         //  int k = Integer.parseInt(key);
           // System.out.println("Game Action :"+getGameAction(k));
            int w = getWidth();
            int h = getHeight();
            int x = w/2;
            int y = h/2;
            
            g.drawString(key, x, y, Graphics.BASELINE|Graphics.HCENTER);
            
            if(image!=null)
            {
//                g.setColor(255, 255, 0);
//                g.fillRect(0, 0, w, h);
                g.translate(45, 45);
                g.drawImage(image, 0, 0, Graphics.VCENTER|Graphics.HCENTER);
            }
        }
            protected void keyPressed(int keyCode)
            {
                int gameAction = getGameAction(keyCode);
                
                switch(gameAction)
                {
                    case UP:
                        System.out.println("key value "+getKeyName(keyCode));
                    key = "[UP]";
                    break;
                    
                    case DOWN:
                    key = "[DOWN]";
                    break;
                    case LEFT:
                    key = "[LEFT]";
                    break;
                    case RIGHT:
                    key = "[RIGHT]";
                    break;
                    case FIRE:
                    key = "[FIRE]";
                    break;
                    case GAME_A:
                    key = "[LEFT_UP]";
                    break;
                    case GAME_B:
                    key = "[RIGHT_UP]";
                    break;
                    case GAME_C:
                    key = "[LEFT_DOWN]";
                    break;
                    case GAME_D:
                    key = "[RIGHT_DOWN]";
                    break;
                    default:
                    key = "";
                    break;
                    }
                    repaint();
                }
                
            }
            
         //   g.drawLine(getWidth()/2, 20, 80, 20);
            
        
    }
    

