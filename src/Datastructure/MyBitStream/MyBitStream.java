package Datastructure.MyBitStream;

import java.security.InvalidParameterException;

/**
 * Created by inoueshuto on 2014/08/24.
 */
public class MyBitStream {
    private final int SHIFT_FIRST_SEG = 24;
    private final int SHIFT_SECOND_SEG = 16;
    private final int SHIFT_THIRD_SEG  = 8;
    private final int MASK = 255;

    private int subnet_mask = -1;

    RawIp rawIp;
    MaskedIp maskedIp;


    public class MaskedIp{
        public long address = -1;
        public long first_seg, second_seg, third_seg, fourth_seg;
    }

    protected class RawIp{
        public long address = -1;
        public long first_seg, second_seg, third_seg, fourth_seg;
    }

    public MyBitStream(){
        rawIp = new RawIp();
        maskedIp = new MaskedIp();
    }

    public void setSubnetMask(int subnet_mask){
        this.subnet_mask = subnet_mask;
    }
    public void setIpSegments(long first, long second, long third, long fourth){
        rawIp.first_seg  = first;
        rawIp.second_seg = second;
        rawIp.third_seg  = third;
        rawIp.fourth_seg = fourth;
    }

    public void maskIp(){
        maskedIp.address = rawIp.address & shiftSubnetMask();
    }

    public void setMaskedSegments(){
        if(maskedIp.address < 0)
            throw new InvalidParameterException();

        maskedIp.first_seg  = (maskedIp.address >> SHIFT_FIRST_SEG)  & MASK;
        maskedIp.second_seg = (maskedIp.address >> SHIFT_SECOND_SEG) & MASK;
        maskedIp.third_seg  = (maskedIp.address >> SHIFT_THIRD_SEG)  & MASK;
        maskedIp.fourth_seg = (maskedIp.address) & MASK;
    }

    public void calcIp(){
        rawIp.address = (rawIp.first_seg  << SHIFT_FIRST_SEG)  +
                        (rawIp.second_seg << SHIFT_SECOND_SEG) +
                        (rawIp.third_seg  << SHIFT_THIRD_SEG)  +
                         rawIp.fourth_seg;
    }

    public long shiftSubnetMask(){
        return (long)(Math.pow(2,subnet_mask) - 1) << (32 - subnet_mask);
    }

    public String stringifyMaskedIp(){
        return maskedIp.first_seg + "."+ maskedIp.second_seg + "." + maskedIp.third_seg + "." +maskedIp.fourth_seg;
    }

    public String stringifyRawIp(){
        return rawIp.first_seg + "." + rawIp.second_seg + "." + rawIp.third_seg + "." + rawIp.fourth_seg;
    }

    public String stringifyNetworkAddress(){
        return stringifyMaskedIp() + "/" + this.subnet_mask;
    }

    public void printMaskedIp(){
        System.out.println(stringifyMaskedIp());
    }

    public void printNetworkAddress(){
        System.out.println(stringifyNetworkAddress());
    }

    public long getIpAddress(){
        return rawIp.address;
    }

    public long getMaskedIp(){
        return maskedIp.address;
    }
}