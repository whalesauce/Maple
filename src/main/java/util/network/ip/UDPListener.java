package util.network.ip;

import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

import java.io.EOFException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

/**
 * Created by williamallen on 4/11/18.
 */
public class UDPListener {


     InetAddress addr;
     PcapNetworkInterface nif;
     PcapNetworkInterface.PromiscuousMode mode = PcapNetworkInterface.PromiscuousMode.PROMISCUOUS;
     PcapHandle handle;
     int snapLen = 65536;
     int timeout = 10;

    public UDPListener(String networkInterface) throws PcapNativeException, UnknownHostException {
        addr = InetAddress.getByName(networkInterface);
        nif = Pcaps.getDevByAddress(addr);
        handle = nif.openLive(snapLen, mode, timeout);
    }

    public UDPListener(String networkInterface, int timeout) throws PcapNativeException, UnknownHostException {
        addr = InetAddress.getByName(networkInterface);
        nif = Pcaps.getDevByAddress(addr);
        this.timeout = timeout;
        handle = nif.openLive(snapLen, mode, timeout);
    }

    public Packet getNextPacket() throws PcapNativeException, NotOpenException, EOFException, TimeoutException {




        return handle.getNextPacketEx();

    }
}


