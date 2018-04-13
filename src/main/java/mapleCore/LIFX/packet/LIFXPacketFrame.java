package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;
import mapleCore.exception.MapleInvalidBitLengthException;
import util.BinaryString;

/**
 * Created by williamallen on 2/27/18.
 */
public class LIFXPacketFrame {


    /** Bit lengths for parameters */

    public static final int packetSizeBits = 16;
    public static final int originBits = 2;
    public static final int taggedBits = 1;
    public static final int addressableBits = 1;
    public static final int protocolBits = 12;
    public static final int sourceBits = 32;


    /** Packet parameters */

    /** Total packet size                                                                                 /** Total size of the entire packet                                            | 16 bits **/
    public static final String origin = "00";                                                             /** Message origin indicator; must be 0                                        | 2 bits **/
    /** Tagged                                                                                            /** Determines use of Frame Address Target Field                               | 1 bit **/
    public static final String addressable = "1";                                                         /** Indicates that the next header will be a frame address header; always 1    | 1 bit **/
    public static final String protocol = BinaryString.toFormattedBinaryString(1024, protocolBits);    /** Message protocol; must be 1024                                             | 12 bits **/
    public static final String source =  BinaryString.toFormattedBinaryString(5829, sourceBits);     /** Unique value set by client, used by responses                              | 32 bits **/




    public String constructedPacket = "";




    /** Only the packet size and whether it is tagged needs to be defined **/

    public static String returnFrame(String packetSize, boolean tagged) throws MapleException {
        if(packetSize.length() != 16){
            throw new MapleInvalidBitLengthException("Invalid input in create of packet frame.. 16 bits expected, received " + packetSize.length());
        }
        return packetSize + origin + (tagged ? "1" : "0") + addressable + protocol + source;
    }

    /** Return the bit size of the packet **/

    public static int getSize(){
        return 64;
    }



}
