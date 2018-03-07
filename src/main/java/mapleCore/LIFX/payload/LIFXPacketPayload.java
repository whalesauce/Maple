package mapleCore.LIFX.payload;

import mapleCore.LIFX.packet.LIFXPacketFrame;
import mapleCore.exception.MapleException;
import mapleCore.exception.MapleInvalidBitLengthException;
import util.BinaryString;

import java.util.HashMap;

/**
 * Created by williamallen on 3/1/18.
 */
public class LIFXPacketPayload {





    /** Device messages */


    /** Requests: Client -> Device */
    public static final int getServicePayloadID = 2;
    public static final int getHostInfoPayloadID = 12;
    public static final int getHostFirmwarePayloadID = 14;
    public static final int getWifiInfoPayloadID = 16;
    public static final int getWifiFirmwarePayloadID 18;
    public static final int getLabelPayloadID = 23;
    public static final int setLabelPayloadID = 24;
    public static final int getVersionPayloadID = 32;
    public static final int getInfoPayloadID = 34;
    public static final int getLocationPayloadID = 48;
    public static final int setLocationPayloadID = 49;
    public static final int getGroupPayloadID = 51;
    public static final int setGroupPayloadID = 52;
    public static final int echoRequestPayloadID = 58;

    /** Responses: Device -> Client */
    public static final int stateServicePayloadID = 3;
    public static final int stateHostInfoPayloadID = 13;
    public static final int stateHostFirmwarePayloadID = 15;
    public static final int stateWifiInfoPayloadID = 17;
    public static final int stateWifiFirmwarePayloadID = 19;
    public static final int stateLabelPayloadID = 25;
    public static final int stateVersionPayloadID = 33;
    public static final int stateInfoPayloadID = 35;
    public static final int acknowledgementPayloadID = 45;
    public static final int stateLocationPayloadID = 50;
    public static final int stateGroupPayloadID = 53;
    public static final int echoResponsePayloadID = 59;



    /** Light messages */


    /** Requests: Client -> Device */
    public static final int GETPayloadID = 101;
    public static final int setColorPayloadID = 102;
    public static final int setWaveformPayloadID = 103;
    public static final int getPowerPayloadID = 116;
    public static final int setPowerPayloadID = 117;
    public static final int setWaveformOptionalPayloadID = 119;
    public static final int getInfaredPayloadID = 120;
    public static final int setInfaredPayloadID = 122;

    /** Responses: Device -> Client */
    public static final int statePayloadID = 107;
    public static final int statePowerPayloadID = 118;
    public static final int stateInfaredPayloadID = 121;



    /** All binary ID's are returned as 16 bit binary strings */

    /** ALL PARAMETERS MUST BE PASSED AS FORMATTED BINARY STRINGS **/

    /** Sent by a client to obtain the light state.
     *  No payload required. Causes the device to transmit a State message. **/





    /**
     * Sent by a client to acquire responses from all devices on the local network.
     * Causes the devices to transmit a StateService message.
     * When using this message the Frame tagged field must be set to one (1).
     */

    /** No payload is required. */
    public static String returnGetServicePayload(){
        return "";
    }

    /** 2 */
    public static String returnGetServicePayloadBinaryID(){

    }





    /**
     * Get Host MCU information. Causes the device to transmit a StateHostInfo message.
     */

    /** No payload is required. */
    public String returnGetHostInfoPayload(){

    }

    /** 12 */
    public String returnGetHostInfoPayloadBinaryID(){

    }





    /**
     * Get Wifi subsystem information. Causes the device to transmit a StateWifiInfo message.
     */

    /** No payload is required. */
    public String returnGetWifiInfoPayload(){

    }

    public String returnGetWifiInfoPayloadBinaryID(){

    }





    /**
     * Get Wifi subsystem firmware. Causes the device to transmit a StateWifiFirmware message.
     */

    /** No payload is required. */
    public String returnGetWifiFirmwarePayload(){

    }

    public String returnGetWifiFirmwarePayloadBinaryID(){

    }


    /**
     * Get device power level. Causes the device to transmit a StatePower message.
     */

    /**  No payload is required. */
    public String returnGetPowerPayload(){

    }

    public String returnGetPowerPayloadBinaryID(){

    }





    /**
     * Set device power level.
     * Zero implies standby and non-zero sets a corresponding power draw level. Currently only 0 and 65535 are supported.
     */

    public String returnSetPowerPayload(){

    }

    public String returnSetPowerPayloadBinaryID(){

    }





    /**
     * Get device label. Causes the device to transmit a StateLabel message.
     */

    /** No payload is required. */
    public String returnGetLabelPayload(){

    }

    public String returnGetLabelPayloadBinaryID(){

    }













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
