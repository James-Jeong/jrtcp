package network.rtcp.type.feedback.payloadspecific;

import network.rtcp.type.feedback.RtcpFeedback;
import network.rtcp.type.feedback.base.RtcpFeedbackMessageHeader;

public class RtcpVideoBackChannelMessage extends RtcpFeedback {

    /**
     * H.271 Video Back Channel Message
     *
     *    The VBCM is identified by RTCP packet type value PT=PSFB and FMT=7.
     *
     *    The FCI field MUST contain one or more VBCM FCI entries.
     *    (Syntax of an FCI Entry in the VBCM)
     *
     *     0                   1                   2                   3
     *     0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     *    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     *    |                              SSRC                             |
     *    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     *    | Seq nr.       |0| Payload Type| Length                        |
     *    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     *    |                    VBCM Octet String....      |    Padding    |
     *    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     *
     *    SSRC (32 bits): The SSRC value of the media sender that is requested
     *           to instruct its encoder to react to the VBCM.
     *
     *    Seq nr. (8 bits): Command sequence number.  The sequence number space
     *           is unique for pairing of the SSRC of the command source and
     *           the SSRC of the command target.  The sequence number SHALL be
     *           increased by 1 modulo 256 for each new command.  A repetition
     *           SHALL NOT increase the sequence number.  The initial value is
     *           arbitrary.
     *
     *    0: Must be set to 0 by the sender and should not be acted upon by the
     *           message receiver.
     *
     *    Payload Type (7 bits): The RTP payload type for which the VBCM bit
     *           stream must be interpreted.
     *
     *    Length (16 bits): The length of the VBCM octet string in octets
     *           exclusive of any padding octets.
     *
     *    VBCM Octet String (variable length): This is the octet string
     *           generated by the decoder carrying a specific feedback sub-
     *           message.
     *
     *    Padding (variable length): Bits set to 0 to make up a 32-bit
     *           boundary.
     *
     *
     *  The "payload" of the VBCM indication carries different types of
     *    codec-specific, feedback information.
     *
     *  The type of feedback information can be classified as a 'status report'
     *      (such as an indication that a bit stream was received without errors,
     *      or that a partial or complete picture or block was lost)
     *      or 'update requests' (such as complete refresh of the bit stream).
     *      > VBCM payload 데이터는 현재 RTP report 상태 정보를 의미
     *
     *   The different types of feedback sub-messages carried in the VBCM are
     *    indicated by the "payloadType" as defined in [H.271].  These sub-
     *    message types are reproduced below for convenience.  "payloadType",
     *    in ITU-T Rec. H.271 terminology, refers to the sub-type of the H.271
     *    message and should not be confused with an RTP payload type.
     *    > 아래 정의된 payload type 은 ITU-T 에서 정의된 개념을 활용하여 조금 더 의미론적으로 편리하게 구성
     *      (RTP Payload type 하고 혼동하면 안됨)
     *
     *  [H.271 message types ("payloadTypes")]
     *    Payload    Message Content
     *    Type
     *    ---------------------------------------------------------------------
     *    0          One or more pictures without detected bit stream error mismatch
     *    1          One or more pictures that are entirely or partially lost
     *    2          A set of blocks of one picture that is entirely or partially lost
     *    3          CRC for one parameter set
     *    4          CRC for all parameter sets of a certain type
     *    5          A "reset" request indicating that the sender should completely
     *               refresh the video bit stream as if no prior bit stream data had been received
     *    > 5        Reserved for future use by ITU-T
     *
     */

    ////////////////////////////////////////////////////////////
    // VARIABLES
    public static final int MIN_LENGTH = RtcpFeedbackMessageHeader.LENGTH; // bytes


    ////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    public RtcpVideoBackChannelMessage(RtcpFeedbackMessageHeader rtcpFeedbackMessageHeader) {
        super(rtcpFeedbackMessageHeader);
    }

    public RtcpVideoBackChannelMessage() {
    }

    public RtcpVideoBackChannelMessage(byte[] data) {
        super(data);
    }
    ////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////
    // FUNCTIONS


    ////////////////////////////////////////////////////////////

}
