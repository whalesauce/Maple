package mapleCore.init;

import mapleCore.LIFX.packet.LIFXPacketFactory;
import mapleCore.exception.MapleException;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.packet.*;
import org.pcap4j.packet.namednumber.UdpPort;
import util.BinaryString;
import util.log.Log;
import util.network.ip.UDPBroadcast;
import util.network.ip.UDPListener;


import java.io.EOFException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeoutException;

/**
 * Created by williamallen on 12/27/17.
 */
public class Maple implements Runnable{


    Packet packet = null;
    UDPListener udpListener = null;

    boolean running;
    Thread thread;

    public static void main(String[] args){


        new Maple();

        //Log.init();









    }

    public Maple(){


        thread = new Thread(this);
        thread.start();

        final Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {


                    byte[] address = {(byte) 255, (byte) 255, (byte) 255, (byte) 255};


                    //System.out.println(BinaryString.toFormattedBinaryString(5829, 8));
                    byte[] justForTesting = {};
                    try {
                        justForTesting = LIFXPacketFactory.returnLightOffPacket(null);
                    } catch (MapleException e) {
                        e.printStackTrace();
                    }
                    {

                    }

                    try {
                        UDPBroadcast.broadcast(justForTesting, InetAddress.getByAddress(address), 56700);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            /*

            for (int i = 0; i < justForTesting.length; i++) {
                System.out.println(justForTesting[i]);
            }
            */



            }
        }, 5000);













    }


    @Override
    public void run() {
        if(!running){
            try {
                udpListener = new UDPListener("192.168.0.6");
            } catch (PcapNativeException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            running=true;
        }

        while(true) {
            try {
                listenForPackets();
            } catch (PcapNativeException e) {
                e.printStackTrace();
            } catch (NotOpenException e) {
                e.printStackTrace();
            } catch (EOFException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                //e.printStackTrace();
            } catch (IllegalRawDataException e) {
               // e.printStackTrace();
            }
        }






        }

        public void listenForPackets() throws PcapNativeException, NotOpenException, EOFException, TimeoutException, IllegalRawDataException {

                packet = udpListener.getNextPacket();
                UdpPacket udpPacket = packet.get(UdpPacket.class);

                     if(udpPacket == null){

                     }else {











                         if (udpPacket.getHeader().getSrcPort().valueAsInt() == 56700)
                             System.out.println(udpPacket);
                     }



    }



}
