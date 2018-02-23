package util.network.http.ip;

import mapleCore.exception.MapleException;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by williamallen on 2/22/18.
 */
public class UDPBroadcast {

    private static DatagramSocket socket = null;

    public UDPBroadcast(){

    }


    public static void broadcast(byte[] broadcastMessage, InetAddress address, int port) throws IOException{
        socket = new DatagramSocket();
        socket.setBroadcast(true);

        DatagramPacket packet = new DatagramPacket(broadcastMessage, broadcastMessage.length, address, port);

        socket.send(packet);
        socket.close();





    }
}
