package mapleCore.LIFX.packet;

import mapleCore.LIFX.LIFXBulb;
import mapleCore.exception.MapleException;
import util.BinaryString;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by williamallen on 1/9/18.
 */
public class LIFXPacketFactory {


    public static final int responseID = 58;




    //TODO - Consolidate payloadPacketSizes into the PayloadFactory class


    public LIFXPacketFactory(){

    }



    /** Get service packet */
    public static byte[] returnGetAllLightsPacket() throws MapleException {


        int payloadPacketSize = 0;

        int packetSize = (LIFXPacketFrame.getSize() +
                LIFXPacketFrameAddress.getSize() +
                LIFXPacketProtocolHeader.getSize() +
                payloadPacketSize)/8;

        String fullPacketStr
                = LIFXPacketFrame.returnFrame(BinaryString.toFormattedBinaryString(packetSize, LIFXPacketFrame.packetSizeBits), true)
                + LIFXPacketFrameAddress.returnFrameAddress(BinaryString.toFormattedBinaryString(0, LIFXPacketFrameAddress.targetBits)
                , false
                , false
                , BinaryString.toFormattedBinaryString(responseID, LIFXPacketFrameAddress.responseIDBits))
                + LIFXPacketProtocolHeader.returnPacketProtocolHeader(LIFXPacketPayloadFactory.returnGetServicePayloadBinaryID() );


        return BinaryString.binaryStringToHexArray(fullPacketStr, BinaryString.LITTLE_ENDIAN);

    }



    /** Light on packet */
    public static byte[] returnLightOnPacket(LIFXBulb light) throws MapleException {



        final int payloadPacketSize = 48;

        /** Max brightness of 65535 */
        final int brightness = 65535;

        /** Max duration of 4294967295 */
        final int duration = 0;


        int packetSize = (LIFXPacketFrame.getSize() +
                         LIFXPacketFrameAddress.getSize() +
                         LIFXPacketProtocolHeader.getSize() +
                         payloadPacketSize)/8;



        /**
         * payload
         *
         * level	   unsigned 16-bit integer
         * duration    unsigned 32-bit integer
         */

        String fullPacketStr
             = LIFXPacketFrame.returnFrame(BinaryString.toFormattedBinaryString(packetSize, LIFXPacketFrame.packetSizeBits), false)
             + LIFXPacketFrameAddress.returnFrameAddress(BinaryString.toFormattedBinaryString(0, LIFXPacketFrameAddress.targetBits)
                                                        , true
                                                        , true
                                                        , BinaryString.toFormattedBinaryString(responseID, LIFXPacketFrameAddress.responseIDBits))
             + LIFXPacketProtocolHeader.returnPacketProtocolHeader(LIFXPacketPayloadFactory.returnSetPowerPayloadBinaryID())
             + LIFXPacketPayloadFactory.returnSetPowerPayload(BinaryString.toFormattedBinaryString(brightness, 16), BinaryString.toFormattedBinaryString(duration, 32));



    return BinaryString.binaryStringToHexArray(fullPacketStr, BinaryString.LITTLE_ENDIAN);





    }

    /** Light off packet */
    public static byte[] returnLightOffPacket(LIFXBulb light) throws MapleException{

        final int payloadPacketSize = 48;

        /** Min brightness of 0 */
        final int brightness = 0;

        /** Max duration of 4294967295 */
        final int duration = 0;


        int packetSize = (LIFXPacketFrame.getSize() +
                LIFXPacketFrameAddress.getSize() +
                LIFXPacketProtocolHeader.getSize() +
                payloadPacketSize)/8;



        /**
         * payload
         *
         * level	   unsigned 16-bit integer
         * duration    unsigned 32-bit integer
         */

        String fullPacketStr
                = LIFXPacketFrame.returnFrame(BinaryString.toFormattedBinaryString(packetSize, LIFXPacketFrame.packetSizeBits), false)
                + LIFXPacketFrameAddress.returnFrameAddress(BinaryString.toFormattedBinaryString(0, LIFXPacketFrameAddress.targetBits)
                , true
                , true
                , BinaryString.toFormattedBinaryString(responseID, LIFXPacketFrameAddress.responseIDBits))
                + LIFXPacketProtocolHeader.returnPacketProtocolHeader(LIFXPacketPayloadFactory.returnSetPowerPayloadBinaryID())
                + LIFXPacketPayloadFactory.returnSetPowerPayload(BinaryString.toFormattedBinaryString(brightness, 16), BinaryString.toFormattedBinaryString(duration, 32));



        return BinaryString.binaryStringToHexArray(fullPacketStr, BinaryString.LITTLE_ENDIAN);


    }





}

