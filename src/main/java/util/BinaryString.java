package util;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

/**
 * Created by williamallen on 3/2/18.
 */
public class BinaryString {

    public static final int LITTLE_ENDIAN = 0;
    public static final int BIG_ENDIAN = 1;


    public static String toFormattedBinaryString(int number, int bits){
        return addLeadingZeros(Integer.toBinaryString(number), bits);
    }

    public static String toFormattedBinaryString(long number, int bits){
        return addLeadingZeros(Long.toBinaryString(number), bits);
    }




    public static String addLeadingZeros(String binaryString, int numberOfBits){
        String returnString = binaryString;
        for(int i = returnString.length(); i < numberOfBits; i++){
            returnString = "0" + returnString;
        }

        return returnString;
    }

    public static String addLeadingZeros(int number, int numberOfBits){
        String returnString = Integer.toBinaryString(number);
        for(int i = returnString.length(); i < numberOfBits; i++){
            returnString = "0" + returnString;
        }

        return returnString;
    }


    public static String getReservedBits(String reservedType, int numberOfBits){
        String returnString = "";
        for(int i = 0; i < numberOfBits; i++){
            returnString += reservedType;
        }
        return returnString;
    }


    public static String toHexString(String binaryString, int endian){

        int counter = 0;
        int endianCounter = 0;


        String returnString = "";
        String tempStr = "";

    for(int i = 0; i < binaryString.length(); i++){
        counter++;
        tempStr += binaryString.charAt(i);

        if(counter == 8 || i == binaryString.length()){

                String savedByte = Long.toHexString(Long.parseLong(tempStr,2));

                if(savedByte.equalsIgnoreCase("0")) {
                    savedByte = "00";
                }

                if(savedByte.length() == 1){
                    savedByte = "0" + savedByte;
                }

                    returnString += savedByte;

                System.out.println(tempStr + "   |   " + savedByte);
                tempStr = "";
                counter = 0;

        }
    }

    if(endian == LITTLE_ENDIAN){
        String newReturnString = "";
         tempStr = "";
         int switchCounter = 0;

        for(int i = 0; i < returnString.length(); i++){
            tempStr += returnString.charAt(i);
            switchCounter++;
            if(switchCounter >= 2){
                newReturnString
            }


        }


    }

    return returnString;
    }
 



}
