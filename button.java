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
public class button extends MIDlet implements CommandListener{
    
    private boolean midletPaused = false;
    private Command OK, HELP, ITEM, SCREEN, EXIT, STOP, CANCEL,BACK;
    private Form form;
    private Display display;
    private Ticker ticker;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
//</editor-fold>//GEN-END:|fields|0|
    /**
     * The button constructor.
     */
    public button() {
        
        form = new Form("Command Form");
        SCREEN  = new Command("SCREEN", Command.SCREEN,1); 
        BACK = new Command("BACK", Command.BACK,2);
        OK = new Command("OK", Command.OK,3);
        HELP = new Command("HELP",Command.HELP,4);
        ITEM = new Command("ITEM", Command.HELP,5);
        EXIT = new Command("EXIT", Command.EXIT,6);
        STOP = new Command("STOP", Command.STOP,7);
        CANCEL = new Command("CANCEL", Command.CANCEL,8);
        ticker = new Ticker("MY NAME IS SHAIZAN I AM AN ALIGARIAN");
        form.setTicker(ticker);
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
}//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {
//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
}//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {
//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
}//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {
//GEN-END:|5-switchDisplayable|0|5-preSwitch
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
       display = Display.getDisplay(this);
       form.addCommand(OK);
       form.addCommand(SCREEN);
       form.addCommand(BACK);
       form.addCommand(CANCEL);
       form.addCommand(HELP);
       form.addCommand(HELP);
       form.addCommand(EXIT);
       form.addCommand(ITEM);
       form.setCommandListener(this);
       display.setCurrent(form);
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
        notifyDestroyed();
    }
    
    public void commandAction(Command c, Displayable d)
    {
        String label = c.getLabel();
        if(label.equals("BACK"))
        {
            back();
        }
        else if(label.equals("OK"))
        {
            ok();
        }
        else if(label.equals("CANCEL"))
        {
            cancel();
        }
        else if(label.equals("EXIT"))
        {
            exit();
        }
    }
    public void back()
    {
        Alert back = new Alert("BACK Command", "Back Command Executed", null, AlertType.INFO);
        back.setTimeout(5000);
        display.setCurrent(back, form);
    }
    public void ok()
    {
        Alert ok = new Alert("OK Command", "OK Command Executed", null, AlertType.INFO);
        ok.setTimeout(5000);
        display.setCurrent(ok, form);
    }
    public void cancel()
    {
        Alert cancel = new Alert("CANCEL Command", "Cancel Command Executed", null, AlertType.INFO);
        cancel.setTimeout(5000);
        display.setCurrent(cancel, form);
    }
    public void exit()
    {
        Alert exit = new Alert("EXIT Command", "Exit Command Executed", null, AlertType.INFO);
        exit.setTimeout(5000);
        display.setCurrent(exit, form);
    }
}
