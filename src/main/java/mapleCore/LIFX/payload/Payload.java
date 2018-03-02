package mapleCore.LIFX.payload;

import mapleCore.exception.MapleException;

import java.util.HashMap;

/**
 * Created by williamallen on 3/1/18.
 */
public class Payload {


    /** Sent by a client to obtain the light state.
     *  No payload required. Causes the device to transmit a State message. **/
    public static String returnGETPayload(){
        return "";
    }

    /** 101 **/
    public static int returnGETPayloadID(){
        return 101;
    }



    /** Sent by a client to change the light state. **/
    public static String returnSetColorPayload(String HSBK, String duration){
     /**
     reserved	unsigned 8-bit integer
     color	    HSBK
     duration	unsigned 32-bit integer
     */

     if(duration.length() != 32){
         // TODO Error
     }

     return "00000000" + HSBK + duration;

    }

    public static int returnSetColorPayloadID(){
        return 102;
    }



    /** Apply an effect to the bulb.
        This message will be replied to with a State message. **/
    public static String returnSetWaveformPayload(){
        /**
         reserved	unsigned 8-bit integer
         transient	8-bit integer as 0 or 1  	Color does not persist.
         color	    Hsbk	                    Light end color.
         period	    unsigned 32-bit integer	    Duration of a cycle in milliseconds.
         cycles	    32-bit float	            Number of cycles.
         skew_ratio	signed 16-bit integer	    Waveform Skew, [-32768, 32767] scaled to [0, 1].
         waveform	unsigned 8-bit integer	    Waveform to use for transition.
         */

        return "";
    }





}
