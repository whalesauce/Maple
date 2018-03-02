package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;

/**
 * Created by williamallen on 3/1/18.
 */
public class LIFXPacketProtocolHeader {

    public static final String reservedOne = "0000000000000000000000000000000000000000000000000000000000000000";    /** Reserved 64 bits              | 64 bits **/
    /** Payload type                                                                                                /** Determines type of payload    | 16 bits **/
    public static final String reservedTwo = "0000000000000000";                                                    /** Reserved 16 bits              | 16 bits **/





    public static String returnPacketProtocolHeader(String payloadType) throws MapleException {
        if(payloadType.length() != 16){
            throw new MapleException("Invalid bit length \nPayload Type:" + payloadType.length());
        }

        return reservedOne + payloadType + reservedTwo;
    }

    public static int getSize(){
        return 96;
    }


}
