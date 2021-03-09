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
public class myStartApp extends MIDlet implements CommandListener{
    private Display display;
    private TextField userName, password;
    public Form form;
    private Command login, cancel;
    private Image img,imge,img2;
    
    public myStartApp(){
        form = new Form("Sign In");
        userName = new TextField("LoginID:","",30,TextField.ANY);
        password = new TextField("Password:","",30,TextField.PASSWORD);
        cancel = new Command("Cancel",Command.CANCEL,2);
        login = new Command("Login",Command.OK,2);
        
        try
        {
            img = Image.createImage("/im1.jpg");
            imge = Image.createImage("/im2.png");
            img2 = Image.createImage("/logo.jpg");
        }catch(Exception e)
        {
            throw new RuntimeException("Exception occured"+e);
        }
    }
    
   

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The mySartApp constructor.
     */
    

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
        display = Display.getDisplay(this);
        form.append(img);
        form.append(userName);
        form.append(password);
        form.addCommand(cancel);
        form.addCommand(login);
        form.setCommandListener(this);
        display.setCurrent(form);
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
      
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
        if(label.equals("Cancel")){
            destroyApp(true);
            
        }else if(label.equals("Login"))
        {
            validateUser(userName.getString(),password.getString());
        }
    }
    public void validateUser(String name, String password)
    {
        if(name.equals("shaizan") && password.equals("siddiqui"))
        {
            showMsg();
        }
        else
        {
            tryAgain();
        }
    }
    
    public void showMsg()
    {
        Alert success = new Alert("Login Successfully","Your Login Process is completed",img2,AlertType.INFO);
        userName.setString("");
        password.setString("");
        display.setCurrent(success, form);
    }
    public void tryAgain()
    {
        Alert error = new Alert("Login Incorrect", "Please try again",imge,AlertType.ERROR);
        error.setTimeout(900);
        error.setImage(imge);
        userName.setString("");
        password.setString("");
        display.setCurrent(error, form);
    }
}
