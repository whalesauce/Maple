package mapleCore.LIFX.HSBK;

import util.BinaryString;

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


     public int hue;
     public int saturation;
     public int brightness;
     public int kelvin;


     public HSBK(int hue, int saturation, int brightness, int kelvin){
         this.hue = hue;
         this.saturation = saturation;
         this.brightness = brightness;
         this.kelvin = kelvin;
     }








     /** Static methods **/


     /** Convert to 16 bit binary integers **/
    public static String getHSBKBinary(int hue, int saturation, int brightness, int kelvin){
        String hueStr = BinaryString.toFormattedBinaryString(hue, 16);
        String satStr = BinaryString.toFormattedBinaryString(saturation, 16);
        String brightStr = BinaryString.toFormattedBinaryString(brightness, 16);
        String kelvinStr = BinaryString.toFormattedBinaryString(kelvin, 16);



        return hueStr + satStr + brightStr + kelvinStr;



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
