package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;

/**
 * Created by williamallen on 3/1/18.
 */
public class LIFXPacketProtocolHeader {

    public String reservedOne = "0000000000000000000000000000000000000000000000000000000000000000";    /** Reserved 64 bits              | 64 bits **/
    public String type = "0000000000000000";                                                           /** Determines type of payload    | 16 bits **/
    public String reservedTwo = "0000000000000000";                                                    /** Reserved 16 bits              | 16 bits **/

    public String constructedPacket;

    public LIFXPacketProtocolHeader(String type) throws MapleException {
        if(type.length() != 16){
            throw new MapleException("Invalid bit length");
        }

        constructedPacket = reservedOne + type + reservedTwo;
    }

    public int getSize(){
        return 96;
    }


    public String getConstructedPacket(){
        return constructedPacket;
    }
}
