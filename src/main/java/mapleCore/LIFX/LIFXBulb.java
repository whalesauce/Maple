package mapleCore.LIFX;

/**
 * Created by williamallen on 3/1/18.
 */
public class LIFXBulb {



    /** Light variables **/

    /** Boolean on/off status */
    private boolean statePower;

    /** Power level 0 - 65535 */
    private int powerLevel;

    /** HSBK values in integer form */
    private int hue;
    private int saturation;
    private int brightness;
    private int kelvin;


    /** Wifi Variables **/

    /** Radio receive signal strength in milliWatts */
    private float signal;

    /** bytes transmitted since power on */
    private int tx;

    /** bytes received since power on */
    private int rx;

    /** Port */
    private final int port = 56700;



    /** Firmware Variables **/

    /** Firmware build */
    private int firmwareBuild;

    /** Firmware version */
    private int firmwareVersion;






    /** HSBK Color stored in binary string */
    private String binaryColor;

    /** Waveform stored in binary string */
    private String binaryWaveform;





    public LIFXBulb() {

    }


    public void changeColor() {

    }


}
