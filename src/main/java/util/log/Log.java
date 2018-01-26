package util.log;

import javax.swing.*;

/**
 * Created by williamallen on 1/25/18.
 */
public class Log {

    /** This is a custom console/output mechanism to fit any variable needs I may desire for Maple **/
    /** All parts will be static for flexibility **/

    /** This module should only be started if a call is made, this variable keeps track if such call is made **/
    static boolean initialized = false;


    /** Using JFrame swing library, subject to change **/

    /** Frame container **/
    static JFrame logFrame;

    /** Toolbar container **/
    static JToolBar logToolbar;

    /** Panel for text **/
    static JPanel logPanel;

    /** Text container **/
    static JTextArea logText;



    /** Customizable attributes **/

    /** Font type **/
    String fontType;

    /** Font color **/
    // TODO Add Maple Color, compatible with lifx
    String fontColor;



    public Log(){

    }



    public static void init(){

        initialized = true;

        /** Create the frame **/
        logFrame = new JFrame();

        /** Create the panel **/
        logToolbar= new JToolBar();

        /** Create the panel **/
        logPanel= new JPanel();


        /** Create the panel **/
        logPanel= new JPanel();
    }







}
