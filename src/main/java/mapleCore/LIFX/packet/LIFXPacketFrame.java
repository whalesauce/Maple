package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;

/**
 * Created by williamallen on 2/27/18.
 */
public class LIFXPacketFrame {

    public String packetSize = "0000000000000000";                /** Total size of the entire packet                                            | 16 bits **/
    public String origin = "00";                                  /** Message origin indicator; must be 0                                        | 2 bits **/
    public String tagged = "0";                                   /** Determines use of Frame Address Target Field                               | 1 bit **/
    public String addressable = "1";                              /** Indicates that the next header will be a frame address header; always 1    | 1 bit **/
    public String protocol = "010000000000";                      /** Message protocol; must be 1024                                             | 12 bits **/
    public String source = "00000000000000000000000000000000";    /** Unique value set by client, used by responses                              | 32 bits **/

    public String constructedPacket = "";




    /** Only the packet size and whether it is tagged needs to be defined **/

    public LIFXPacketFrame(String packetSize, String tagged) throws MapleException {
        if(packetSize.length() != 16 || tagged.length() != 1){
            throw new MapleException("Invalid bit length");

        }
        this.packetSize = packetSize;
        this.tagged = tagged;
        constructedPacket = packetSize + origin + tagged + addressable + protocol + source;

    }

    /** Return the size of the packet **/

    public static int getSize(){
        return 64;
    }

    public String getConstructedPacket(){
        return constructedPacket;
    }


}
