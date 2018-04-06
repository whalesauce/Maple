package mapleCore.init;

import util.log.Log;
import util.network.ip.UDPBroadcast;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by williamallen on 12/27/17.
 */
public class Maple {

    public static void main(String[] args){
        Log.init();

        byte[] broadcast = {0x31,00,00,0x34,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,0x66,00,00,00,00,0x55,0x55,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xAC,(byte)0x0D,00,(byte)0x04,00,00};
        byte[] address = {(byte)255, (byte)255, (byte)255, (byte)255};

        try{
        UDPBroadcast.broadcast(broadcast, InetAddress.getByAddress(address), 56700);
        }catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
