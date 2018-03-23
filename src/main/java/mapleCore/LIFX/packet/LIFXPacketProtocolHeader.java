package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;
import util.BinaryString;

/**
 * Created by williamallen on 3/1/18.
 */
public class LIFXPacketProtocolHeader {

    public static final String reservedOne = BinaryString.getReservedBits("0", 64);    /** Reserved 64 bits              | 64 bits **/
    /** LIFXPacketPayloadFactory type                                                                           /** Determines type of payload    | 16 bits **/
    public static final String reservedTwo = BinaryString.getReservedBits("0", 16);    /** Reserved 16 bits              | 16 bits **/





    public static String returnPacketProtocolHeader(String payloadType) throws MapleException {
        if(payloadType.length() != 16){
            throw new MapleException("Invalid bit length \nLIFXPacketPayloadFactory Type:" + payloadType.length());
        }

        return reservedOne + payloadType + reservedTwo;
    }

    public static int getSize(){
        return 96;
    }


}

