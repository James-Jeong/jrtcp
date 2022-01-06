package rtcp;

import network.rtcp.base.RtcpHeader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.module.ByteUtil;

public class RtcpHeaderTest {

    private static final Logger logger = LoggerFactory.getLogger(RtcpHeaderTest.class);

    @Test
    public void test() {
        byte[] data = creationTest();
        getTest(data);
    }

    private byte[] creationTest() {
        // SR
        RtcpHeader rtcpHeader = new RtcpHeader(2, 0, 1, (short) 201, 7, 26422708);
        logger.debug("[RtcpHeaderTest][creationTest] RtcpHeader: \n{}", rtcpHeader);

        byte[] rtcpHeaderData = rtcpHeader.getData();
        logger.debug("[RtcpHeaderTest][creationTest] RtcpHeader byte data: \n{}", rtcpHeaderData);
        logger.debug("[RtcpHeaderTest][creationTest] RtcpHeader byte data: \n{}", ByteUtil.byteArrayToHex(rtcpHeaderData));
        return rtcpHeaderData;
    }

    private void getTest(byte[] data) {
        RtcpHeader rtcpHeader = new RtcpHeader(data);
        logger.debug("[RtcpHeaderTest][getTest] RtcpHeader: \n{}", rtcpHeader);
    }

}
