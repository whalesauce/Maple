package mapleCore.LIFX.payload;

/**
 * Created by williamallen on 3/1/18.
 */
public class Payload {

    public int messageID;


    public Payload(String payloadType, String[] params){
        constructPayload(payloadType);
    }

    public String constructPayload(String payloadType, String[] params){

        /** Get - 101 **/
        if(payloadType.equalsIgnoreCase("GET")){
            messageID = 101;
            /** No payload required **/
            return "";
        }

        /** SetColor - 102 **/
        if(payloadType.equalsIgnoreCase("SetColor")){
            messageID = 102;
             /**
             * Field	Type
             reserved	unsigned 8-bit integer
             color	    HSBK
             duration	unsigned 32-bit integer
             */


        }

        return "";






    }



}
