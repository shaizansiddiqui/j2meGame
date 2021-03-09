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
public class textsCanvas extends MIDlet {
    private Display display;
    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The textCanvas constructor.
     */
    public textsCanvas() {
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
//        
        Canvas canvas = new CanvasLine();
        display = Display.getDisplay(this);
        display.setCurrent(canvas);
                
     
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
    
}

    class CanvasLine extends Canvas
    {
           

    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        
        
        
        g.setColor(255, 162, 117);
        g.fillRect(0, 0, width, height);
        
        g.setColor(60, 200, 200);
            g.fillTriangle(getWidth() / 4, 100, 90, 180, 180, 90);
            
            g.setColor(255, 255, 255);
            g.fillArc(50, 50, 50, 50, 30, 90);
//        g.setColor(0, 0, 255);
//        g.drawLine(0, height/2, width - 1, height/2);
//        
//        g.setStrokeStyle(Graphics.DOTTED);
//        
//        g.setColor(0xFFFF00);
//        g.drawLine(0, height/4, width - 1, height/4);
//        
//        g.setColor(0,0,255);
//        g.setStrokeStyle(Graphics.SOLID);
//        g.drawLine(0, 0, width - 1, height - 1);
//        
//        g.setColor(255, 162, 117);
//        g.fillRect(0, 0, width, height);
//        
//        g.setColor(0, 0, 255);
//        
//        g.drawString("Shaizan siddiqui", 0, 0, Graphics.TOP|Graphics.LEFT);
//        
//        Font font = g.getFont();
//        g.drawString("MCA", 0,font.getHeight(), Graphics.TOP|Graphics.LEFT);
//        
//        g.drawString("Aligarian", width, height, Graphics.BOTTOM|Graphics.RIGHT);
//        
//        String str = "ZMQ";
//        font = Font.getFont(Font.FACE_PROPORTIONAL,Font.STYLE_UNDERLINED,Font.SIZE_LARGE);
//        g.setFont(font);
//        g.drawString(str, 0, height/2, Graphics.LEFT|Graphics.BASELINE);
//        
//        int x = font.stringWidth(str);
//        g.setColor(0, 0, 255);
//        g.setFont(Font.getFont(Font.FACE_PROPORTIONAL,Font.STYLE_BOLD|Font.STYLE_ITALIC,Font.SIZE_MEDIUM));
//        g.drawString("Delhi, India", x, height/2, Graphics.LEFT|Graphics.BASELINE);
//        
//        
    }
    }
