package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;

/**
 * Created by williamallen on 2/27/18.
 */
public class LIFXPacketFrame {

    /** Total packet size                                                      /** Total size of the entire packet                                            | 16 bits **/
    public static final String origin = "00";                                  /** Message origin indicator; must be 0                                        | 2 bits **/
    /** Tagged                                                                 /** Determines use of Frame Address Target Field                               | 1 bit **/
    public static final String addressable = "1";                              /** Indicates that the next header will be a frame address header; always 1    | 1 bit **/
    public static final String protocol = "010000000000";                      /** Message protocol; must be 1024                                             | 12 bits **/
    public static final String source = "00000000000000000000000000000000";    /** Unique value set by client, used by responses                              | 32 bits **/

    public String constructedPacket = "";




    /** Only the packet size and whether it is tagged needs to be defined **/

    public static String returnFrame(String packetSize, boolean tagged) throws MapleException {
        if(packetSize.length() != 16){
            throw new MapleException("Invalid bit length in packet frame \nPacket Size: " + packetSize.length());
        }
        return packetSize + origin + Boolean.toString(tagged) + addressable + protocol + source;
    }

    /** Return the bit size of the packet **/

    public static int getSize(){
        return 64;
    }



}
