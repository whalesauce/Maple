package mapleCore.LIFX.packet;

import mapleCore.exception.MapleException;

/**
 * Created by williamallen on 2/27/18.
 */
public class LIFXPacketFrameAddress{

    public String target = "0000000000000000000000000000000000000000000000000000000000000000";    /** MAC Address or all 0's for ubiquitous broadcast                 | 64 bits**/
    public String reservedOne = "000000000000000000000000000000000000000000000000";               /** Reserved 48 bits                                                | 48 bits **/
    public String reservedTwo = "000000";                                                         /** Reserved 6 bits                                                 | 6 bits **/
    public String ack_required = "0";                                                             /** Does the LIFX light need to return an acknowledgement packet    | 1 bit **/
    public String res_required = "0";                                                             /** Does the LIFX light need to provide a response packet           | 1 bit **/
    public String response_id = "00000000";                                                       /** Unique ID for response packets to identify them                 | 8 bits **/


    public String constructedPacket = "";

    /** We need to implement the target, requirments for acknowledgement and responses, and the response id **/

    public LIFXPacketFrameAddress(String target, boolean ack_req, boolean res_req, String response_id) throws MapleException {
        if(target.length() != 64 || response_id.length() != 8){
            throw new MapleException("Invalid bit length");
        }

        this.target = target;
        if(ack_req){
            ack_required = "1";
        }
        if(res_req){
            res_required = "1";
        }

        this.response_id = response_id;

        constructedPacket = target + reservedOne + reservedTwo + ack_required + res_required + response_id;

    }

    public int getSize(){
        return 128;
    }


    public String getConstructedPacket(){
        return constructedPacket;
    }






}
