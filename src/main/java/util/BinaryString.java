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
         String tempStr2 = "";
         int switchCounter = 0;

        for(int i = 0; i < returnString.length(); i++){
            if(switchCounter >= 2){
                tempStr2 += returnString.charAt(i);

                switchCounter++;
            }else{
                tempStr += returnString.charAt(i);

                switchCounter++;
            }

            if(switchCounter == 4){
                System.out.println(tempStr2 + " | " + i);
                System.out.println(tempStr + " | " + i);

                newReturnString += tempStr2 + tempStr;
                tempStr = "";
                tempStr2 = "";
                switchCounter = 0;
            }


        }
        System.out.println(newReturnString.length());
        return newReturnString;
    }

    return returnString;
    }



    public static byte[] binaryStringToHexArray(String binaryString, int endian){
        String hexString = toHexString(binaryString, endian == 1 ? BIG_ENDIAN : LITTLE_ENDIAN);
            byte[] b = new byte[hexString.length() / 2];
            for (int i = 0; i < b.length; i++) {
                int index = i * 2;
                int v = Integer.parseInt(hexString.substring(index, index + 2), 16);
                b[i] = (byte) v;
            }
            return b;
        }
 



}
