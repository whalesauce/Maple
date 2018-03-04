package util;

/**
 * Created by williamallen on 3/2/18.
 */
public class BinaryString {


    public static String toFormattedBinaryString(int number, int bits){
        return addLeadingZeros(Integer.toBinaryString(number), bits);
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


}
