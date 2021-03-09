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
public class practice extends MIDlet implements CommandListener{
    
    private boolean midletPaused = false;
    private Display display;
    private String s;
    private Form form;
    private Command c,l,ch;
    private TextField t1,t2;
    private Image img;
    private ChoiceGroup tech;
    private int Index;
    private List list;
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The practice constructor.
     */
    public practice() {
       c = new Command("cancel",Command.CANCEL,2);
       l =  new Command("login",Command.OK,2);
       ch = new Command("Choose",Command.SCREEN,2);
        t1 = new TextField("LoginId","",30,TextField.ANY);
        t2 = new TextField("Password","",30,TextField.PASSWORD);
        tech = new ChoiceGroup("AVAILABLE CHOICES",Choice.MULTIPLE);
        list = new List("Choice of subjects",Choice.EXCLUSIVE);
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
            display = Display.getDisplay(this);
            form = new Form("Practice");
            s = "Hello world";
            form.append(t1);
            form.append(t2);
            form.append(s);
            list.append("OS", null);
            list.append("N/W", null);
            list.append("CPP", null);
            list.append("DBMS", null);
            display.setCurrent(list);
            form.addCommand(c);
           form.addCommand(l);
           form.addCommand(ch);
           tech.append("JAVA",null);
           tech.append("CPP", null);
           tech.append("PYTHON", null);
           Index = form.append(tech);
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
    public void commandAction(Command c,Displayable d)
    {
        String label = c.getLabel();
        if(label.equals("cancel"))
        {
            destroyApp(true);
        }
        else if(label.equals("login"))
        {
            validate(t1.getString(),t2.getString());
        }
        else if (label.equals("Choose")) {
            StringItem message[] = new StringItem[tech.size()];
            boolean get[] = new boolean[tech.size()];
            tech.getSelectedFlags(get);
            for (int i = 0; i < get.length; i++) {
            if (get[i]) {
            message[i] = new StringItem("Your Choice is: ", tech.getString(i));
            form.append(message[i]);
            }
            }
            form.delete(Index);
            form.removeCommand(ch);
            } else if (label.equals("Exit")){
            destroyApp(false);
            }
            }
    
    public void validate(String n,String p)
    {
        if(n.equals("shaizan") && p.equals("password"))
        {
            showM();
        }
        else 
        {
            error();
        }
    }
    public void showM(){
        Alert s = new Alert("Login Successfully","Your Login Successfully",img,AlertType.CONFIRMATION);
        display.setCurrent(s,form);
    }
    public void error()
    {
        Alert a = new Alert("Sorry");
        display.setCurrent(a,form);
    }
}
