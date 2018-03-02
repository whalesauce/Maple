package mapleCore.LIFX.packet;

import mapleCore.LIFX.payload.Payload;
import mapleCore.exception.MapleException;

/**
 * Created by williamallen on 1/9/18.
 */
public class LIFXPacketFactory {




    public LIFXPacketFactory(){

    }



    public static byte[] createInstruction(String payloadType, String[] params) throws MapleException {

        int packetSize = LIFXPacketFrame.getSize();

        //Payload.constructPayload(payloadType, params);


        return null;
    }




}

