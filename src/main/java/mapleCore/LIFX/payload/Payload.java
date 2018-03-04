package mapleCore.LIFX.payload;

import mapleCore.exception.MapleException;
import mapleCore.exception.MapleInvalidBitLengthException;
import util.BinaryString;

import java.util.HashMap;

/**
 * Created by williamallen on 3/1/18.
 */
public class Payload {

    public static final int getPayloadID = 101;
    public static final int setColorPayloadID = 102;
    public static final int setWaveformPayloadID = 103;

    public static final int setWaveformOptionalPayloadID = 119;


    /** All binary ID's are returned as 16 bit binary strings */

    /** ALL PARAMETERS MUST BE PASSED AS FORMATTED BINARY STRINGS **/

    /** Sent by a client to obtain the light state.
     *  No payload required. Causes the device to transmit a State message. **/
    public static String returnGETPayload(){
        return "";
    }

    /** 101 **/
    public static String returnGETPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getPayloadID, 16);
    }



    /** Sent by a client to change the light state. **/
    public static String returnSetColorPayload(String HSBK, String duration) throws MapleInvalidBitLengthException {
     /**
     reserved	unsigned 8-bit integer
     color	    HSBK
     duration	unsigned 32-bit integer
     */

     return BinaryString.getReservedBits("0", 8) + HSBK + duration;

    }

    /** 102 */
    public static String returnSetColorPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setColorPayloadID, 16);
    }


    /** Apply an effect to the bulb.
        This message will be replied to with a State message. **/
    public static String returnSetWaveformPayload(String isTransient, String HSBK, String period, String cycles, String skewRatio, String waveform ) throws MapleInvalidBitLengthException {
        /**
         reserved	unsigned 8-bit integer
         transient	8-bit integer as 0 or 1  	Color does not persist.
         color	    Hsbk	                    Light end color.
         period	    unsigned 32-bit integer	    Duration of a cycle in milliseconds.
         cycles	    32-bit float	            Number of cycles.
         skew_ratio	signed 16-bit integer	    Waveform Skew, [-32768, 32767] scaled to [0, 1].
         waveform	unsigned 8-bit integer	    Waveform to use for transition.
         */


        return BinaryString.getReservedBits("0", 8) + isTransient + HSBK + period + cycles + skewRatio + waveform;

    }

    /** 103 */
    public static String returnSetWaveformPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setWaveformPayloadID, 16);
    }




    public static String returnSetWaveformOptionalPayload(String isTransient, String HSBK, String period, String cycles, String skewRatio, String waveform, String setHue, String setSaturation, String setBrightness, String setKelvin){
        /**
         reserved	       unsigned 8-bit integer
         transient	       boolean
         color	           Hsbk
         period	           unsigned 32-bit integer
         cycles	           32-bit float
         skew_ratio	       signed 16-bit integer
         waveform	       unsigned 8-bit integer
         set_hue	       8-bit integer as 0 or 1
         set_saturation	   8-bit integer as 0 or 1
         set_brightness    8-bit integer as 0 or 1
         set_kelvin	       8-bit integer as 0 or 1
         */
        return BinaryString.getReservedBits("0", 8) + isTransient + HSBK + period + cycles + skewRatio + waveform + setHue + setSaturation + setBrightness + setKelvin;

    }


    public static String returnSetWaveformOptionalPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setWaveformOptionalPayloadID, 16);
    }













}
