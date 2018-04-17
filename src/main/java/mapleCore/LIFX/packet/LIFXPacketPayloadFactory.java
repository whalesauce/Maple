package mapleCore.LIFX.packet;

import mapleCore.exception.MapleInvalidBitLengthException;
import util.BinaryString;

/**
 * Created by williamallen on 3/1/18.
 */
public class LIFXPacketPayloadFactory {





    /** Device messages */


    /** Requests: Client -> Device */
    public static final int getServicePayloadID = 2;
    public static final int getHostInfoPayloadID = 12;
    public static final int getHostFirmwarePayloadID = 14;
    public static final int getWifiInfoPayloadID = 16;
    public static final int getWifiFirmwarePayloadID = 18;
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
    public static final int echoResponsePayloadID  = 59;



    /** Light messages */


    /** Requests: Client -> Device */
    public static final int GETPayloadID = 101;
    public static final int setColorPayloadID = 102;
    public static final int setWaveformPayloadID = 103;
    public static final int getPowerPayloadID = 116;
    public static final int setPowerPayloadID = 117;
    public static final int setWaveformOptionalPayloadID = 119;
    public static final int getInfraredPayloadID = 120;
    public static final int setInfraredPayloadID = 122;

    /** Responses: Device -> Client */
    public static final int statePayloadID = 107;
    public static final int statePowerPayloadID = 118;
    public static final int stateInfaredPayloadID = 121;


    /** This class is not so much functional as it is organizational. Checks for parameter validity will be done
     * outside of this class, the only real function this class provides is insertion of occasional reserved bits and
     * returning payload binary ID's
     */

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
        return BinaryString.toFormattedBinaryString(getServicePayloadID, 16);
    }






    /**
     * Get Host MCU information. Causes the device to transmit a StateHostInfo message.
     */

    /** No payload is required. */
    public static String returnGetHostInfoPayload(){
        return "";
    }

    /** 12 */
    public static String returnGetHostInfoPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getHostInfoPayloadID, 16);
    }






    /**
     * Gets Host MCU firmware information. No payload is required. Causes the device to transmit a StateHostFirmware message.
     */

    /** No payload is required */
    public static String returnGetHostFirmwarePayload(){
        return "";
    }

    /** 14 **/
    public static String returnGetHostFirmwarePayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getHostFirmwarePayloadID, 16);
    }







    /**
     * Get Wifi subsystem information. Causes the device to transmit a StateWifiInfo message.
     */

    /** No payload is required. */
    public static String returnGetWifiInfoPayload(){
        return "";
    }
    /** 16 */
    public static String returnGetWifiInfoPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getWifiInfoPayloadID, 16);
    }






    /**
     * Get Wifi subsystem firmware. Causes the device to transmit a StateWifiFirmware message.
     */

    /** No payload is required. */
    public static String returnGetWifiFirmwarePayload(){
        return "";
    }
    /** 18 */
    public static String returnGetWifiFirmwarePayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getWifiFirmwarePayloadID, 16);
    }






    /**
     * Get device label. Causes the device to transmit a StateLabel message.
     */

    /** No payload is required. */
    public static String returnGetLabelPayload(){
        return "";
    }

    /** 23 */
    public static String returnGetLabelPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getLabelPayloadID, 16);
    }






    /** Set the device label text. */

    public static String returnSetLabelPayload(String label){
        /**
         * label    32 bytes
         */

        return label;
    }

    /** 24 */
    public static String returnSetLabelPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setLabelPayloadID, 16);
    }






    /**
     * Get the hardware version. No payload is required. Causes the device to transmit a StateVersion message.
     */
    
    /** No payload is required */
    public static String returnGetVersionPayload(){
        return "";
    }

    /** 32 */
    public static String returnGetVersionPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getVersionPayloadID, 16);
    }






    /** Get run-time information. No payload is required. Causes the device to transmit a StateInfo message. */

    /** No payload required */
    public static String returnGetInfoPayload(){
        return "";
    }

    /** 34 */
    public static String returnGetInfoPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getInfoPayloadID, 16);
    }






    /** Ask the bulb to return its location information. Causes the device to transmit a StateLocation message. */

    /** No payload required */
    public static String returnGetLocation(){
        return "";
    }

    /** 48 */
    public static String returnGetLocationBinaryID(){
        return BinaryString.toFormattedBinaryString(getLocationPayloadID, 16);
    }


    /**
     * Set the device location.

     Applications wishing to change either the label or location attributes MUST set the updated_at field to the
     current timestamp and send the message to all applicable devices that are currently online.
     This is because when reading these values the applications will consider unique location fields
     to be a location identifier, and the label on the bulb with the highest updated_at field for that location will be used.
     Applications SHOULD attempt to correct any labels that are out of date when found.
     It is recommended to set the response_required flag on the message header to speed up updating the cloud account.
     */

    public static String returnSetLocationPayload(String location, String label, String updated_at){
        /**
         * When creating a new location generate the location field with random data.
         *
         * location	     16 bit byte array
         * label	     32 bit string
         * updated_at    64 bit integer
         */

        return location + label + updated_at;
    }

    /** 49 */
    public static String returnSetLocationBinaryID(){
        return BinaryString.toFormattedBinaryString(setLocationPayloadID, 16);
    }






    /** Ask the bulb to return its group membership information. Causes the device to transmit a StateGroup message. */

    /** No payload required */
    public static String returnGetGroupPayload(){
        return "";
    }

    /** 51 */
    public static String returnGetGroupPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getGroupPayloadID, 16);
    }


    /**
     * Set the device group.
     *
     * Applications wishing to change either the label or group attributes MUST set the updated_at field to the current timestamp
     * and send the message to all applicable devices that are currently online. This is because when reading these values the applications
     * will consider unique group fields to be a group identifier, and the label on the bulb with the highest updated_at field for that group will be used.
     * Applications SHOULD attempt to correct any labels that are out of date when found.
     * It is recommended to set the response_required flag on the message header to speed up updating the cloud account.
     */

    public static String returnSetGroupPayload(String group, String label, String updated_at){
        /**
         * When creating a new group generate the group field with random data.
         *
         * group	     16 bit byte array
         * label	     32 bit string
         * updated_at    64 bit integer
         */

        return group + label + updated_at;
    }

    /** 52 */
    public static String returnSetGroupPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setGroupPayloadID, 16);
    }






    /** Request an arbitrary payload be echoed back. Causes the device to transmit an EchoResponse message. */

    public static String echoRequestPayload(String payload){
        return payload;
    }

    /** 58 */
    public static String echoRequestPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(echoRequestPayloadID, 16);
    }






    public static String returnGETPayload(){
        return "";
    }

    /** 101 **/
    public static String returnGETPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(GETPayloadID, 16);
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
     This message will be replied to with a State message.
     */
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




    /**
     * Get device power level. Causes the device to transmit a StatePower message.
     */

    /**  No payload is required. */
    public static String returnGetPowerPayload(){
        return "";
    }
    /** 116 OR 21 */
    public static String returnGetPowerPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getPowerPayloadID, 16);
    }





    /**
     * Set device power level.
     * Zero implies standby and non-zero sets a corresponding power draw level. Currently only 0 and 65535 are supported.
     */

    public static String returnSetPowerPayload(String level, String duration){
        /**
         * level	   unsigned 16-bit integer
         * duration    unsigned 32-bit integer
         */
        return level + duration;
    }

    /** 117 */
    public static String returnSetPowerPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setPowerPayloadID, 16);
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

    /** 119 */
    public static String returnSetWaveformOptionalPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setWaveformOptionalPayloadID, 16);
    }






    /**
     * Gets the current maximum power level of the Infrared channel.
     * If the Frame Address res_required field is set to one (1) then the device will transmit a StateInfrared message.
     */

    /** No payload is required */
    public static String returnGetInfraredPayload(){
        return "";
    }

    /** 120 */
    public static String returnGetInfraredPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(getInfraredPayloadID, 16);
    }






    /**
     * Send this message to alter the current maximum brightness for the infrared channel.
     * If the Frame Address res_required field is set to one (1) then the device will transmit a StateInfrared message.
     */

    public static String returnSetInfaredPayload(String brightness){
        /**
         * brightness    unsigned 16-bit integer
         */

        return  brightness;

    }

    /** 122 */
    public static String returnSetInfaredPayloadBinaryID(){
        return BinaryString.toFormattedBinaryString(setInfraredPayloadID, 16);
    }


}
