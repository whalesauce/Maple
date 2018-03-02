package mapleCore.LIFX.HSBK;

/**
 * Created by williamallen on 3/2/18.
 */
public class HSBK {


     /**
     HSBK is used to represent the color and color temperature of a light.

     The color is represented as an HSB (Hue, Saturation, Brightness) value.

     The color temperature is represented in K (Kelvin) and is used to adjust the warmness / coolness of a white light, which is most obvious when saturation is close zero.

     Hue: range 0 to 65535
     Saturation: range 0 to 65535
     Brightness: range 0 to 65535
     Kelvin: range 2500° (warm) to 9000° (cool)
     */

     /** Convert to 16 bit binary integers **/
    public static String getHSBKBinary(int hue, int saturation, int brightness, int kelvin){
        String hueStr = Integer.toBinaryString(hue);
        String satStr = Integer.toBinaryString(saturation);
        String brightStr = Integer.toBinaryString(brightness);
        String kelvinStr = Integer.toBinaryString(kelvin);

        for(int i = hueStr.length(); i < 16; i++){
            hueStr = "0" + hueStr;
        }

        for(int i = satStr.length(); i < 16; i++){
            satStr = "0" + satStr;
        }

        for(int i = brightStr.length(); i < 16; i++){
            brightStr = "0" + brightStr;
        }

        for(int i = kelvinStr.length(); i < 16; i++){
            kelvinStr = "0" + kelvinStr;
        }


        return hueStr + satStr + brightStr + kelvinStr;



        //This is wrong, add leading 0's
    }


    public static String getHSBKfromRGB(int red, int green, int blue, int brightness){
        int redP = red/255;
        int greenP = green/255;
        int blueP = blue/255;

        int Cmax = Math.max(Math.max(redP, greenP), blueP);
        int Cmin = Math.min(Math.min(redP, greenP), blueP);

        int delta = Cmax - Cmin;

        int hue = 0;
        if(Cmax == redP){
            hue = 60 * ((greenP - blueP)/delta)%6;
        } else if(Cmax == greenP){
            hue = 60 * ((blueP - redP)/delta)+2;
        } else if(Cmax == blueP){
            hue = 60 * ((redP - greenP)/delta)+4;
        }

        int saturation;

        if(Cmax == 0){
            saturation = 0;
        } else {
           saturation = delta/Cmax;
        }

        int value = Cmax;


        //TODO Might need to adjust from percentage to real values
        return getHSBKBinary(hue, saturation, brightness, value);


    }


}
