package test.MyBitStream;

import Datastructure.MyBitStream.MyBitStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by inoueshuto on 2014/08/24.
 */
public class MyBitStreamTest {
    MyBitStream bit_stream;

    @Before
    public void setUp(){
        bit_stream = new MyBitStream();
    }

    @Test
    public void testShiftSubnetMask() {
        bit_stream.setSubnetMask(32);

        long _actual = bit_stream.shiftSubnetMask();

        long _expected = (long)4294967295L;

        assertEquals(_actual, _expected);

    }

    @Test
    public void testStringifyIp() {
        bit_stream.setIpSegments(192,168,1,1);

        String _actual = bit_stream.stringifyRawIp();

        String _expected = "192.168.1.1";

        assertTrue(_actual.equals(_expected));
    }

    @Test
    public void testCalcIp(){
        bit_stream.setIpSegments(255, 255, 255, 255);
        bit_stream.calcIp();

        String _actual = Long.toBinaryString(bit_stream.getIpAddress());

        String _expect = "11111111111111111111111111111111";
        assertTrue(_actual.equals(_expect));
    }

    @Test
    public void testMask(){
        bit_stream.setIpSegments(255, 255, 255, 255);
        bit_stream.calcIp();
        bit_stream.setSubnetMask(24);

        bit_stream.maskIp();
        String _actual = Long.toBinaryString(bit_stream.getMaskedIp());

        String _expect = "11111111111111111111111100000000";
        assertTrue(_actual.equals(_expect));
    }

    @Test
    public void testNetworkAddress(){
        bit_stream.setIpSegments(192,168,1,25);
        bit_stream.calcIp();
        bit_stream.setSubnetMask(24);

        bit_stream.maskIp();
        bit_stream.setMaskedSegments();

        String _actual = bit_stream.stringifyMaskedIp();

        String _expected = "192.168.1.0";
        assertTrue((_actual.equals(_expected)));


    }
}
