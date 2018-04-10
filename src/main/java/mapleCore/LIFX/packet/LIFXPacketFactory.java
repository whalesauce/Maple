package mapleCore.LIFX.packet;

import mapleCore.LIFX.LIFXBulb;
import mapleCore.exception.MapleException;
import util.BinaryString;

import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 * Created by williamallen on 1/9/18.
 */
public class LIFXPacketFactory {


    public static final int responseID = 58;




    //TODO - Consolidate payloadPacketSizes into the PayloadFactory class


    public LIFXPacketFactory(){

    }



    /** Light on packet */
    public static byte[] returnLightOnPacket(LIFXBulb light, boolean allLights) throws MapleException {



        final int payloadPacketSize = 48;

        /** Max brightness of 65535 */
        final int brightness = 65535;

        /** Max duration of 4294967295 */
        final long duration = 4294967295L;


        int packetSize = LIFXPacketFrame.getSize() +
                         LIFXPacketFrameAddress.getSize() +
                         LIFXPacketProtocolHeader.getSize() +
                         payloadPacketSize;



        /**
         * payload
         *
         * level	   unsigned 16-bit integer
         * duration    unsigned 32-bit integer
         */

        String fullPacketStr
             = LIFXPacketFrame.returnFrame(BinaryString.toFormattedBinaryString(packetSize, LIFXPacketFrame.packetSizeBits), true)
             + LIFXPacketFrameAddress.returnFrameAddress(allLights ? BinaryString.toFormattedBinaryString(0, LIFXPacketFrameAddress.targetBits) : BinaryString.toFormattedBinaryString(light.getMAC(), LIFXPacketFrameAddress.targetBits)
                                                        , true
                                                        , true
                                                        , BinaryString.toFormattedBinaryString(responseID, LIFXPacketFrameAddress.responseIDBits))
             + LIFXPacketProtocolHeader.returnPacketProtocolHeader(LIFXPacketPayloadFactory.returnSetPowerPayloadBinaryID())
             + LIFXPacketPayloadFactory.returnSetPowerPayload(BinaryString.toFormattedBinaryString(brightness, 16), BinaryString.toFormattedBinaryString(duration, 32));



    return BinaryString.binaryStringToHexArray(fullPacketStr, BinaryString.LITTLE_ENDIAN);





    }

    public static byte[] returnLightOffPacket(){
        return null;
    }





}

