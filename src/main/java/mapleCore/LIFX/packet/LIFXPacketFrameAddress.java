package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;
import util.BinaryString;

/**
 * Created by williamallen on 2/27/18.
 */
public class LIFXPacketFrameAddress{

    /** Target                                                                                                      /** MAC Address or all 0's for ubiquitous broadcast                 | 64 bits**/
    public static final String reservedBitsOne = BinaryString.getReservedBits("0", 48);    /** Reserved 48 bits                                                | 48 bits **/
    public static final String reservedBitsTwo = BinaryString.getReservedBits("0", 6);     /** Reserved 6 bits                                                 | 6 bits **/
    /** Acknowledgement required                                                                                    /** Does the LIFX light need to return an acknowledgement packet    | 1 bit **/
    /** Response required                                                                                           /** Does the LIFX light need to provide a response packet           | 1 bit **/
    /** Response id                                                                                                 /** Unique ID for response packets to identify them                 | 8 bits **/



    /** Bit lengths for parameters */

    public static final int targetBits = 64;
    public static final int totalReservedBits = 54;
    public static final int ackReqBits = 1;
    public static final int resReqBits = 1;
    public static final int responseIDBits = 8;






    /** We need to implement the target, requirementss for acknowledgement and responses, and the response id **/
    public static String returnFrameAddress(String target, boolean ack_req, boolean res_req, String response_id) throws MapleException {
        if(target.length() != 64 || response_id.length() != 8){
            throw new MapleException("Invalid bit length \nTarget: " + target.length() + "\nResponse ID: " + response_id.length());
        }
        return target + reservedBitsOne + reservedBitsTwo + (ack_req ? 1 : 0) + (res_req ? 1 : 0) + response_id;
    }


    public static int getSize(){
        return 128;
    }








}
