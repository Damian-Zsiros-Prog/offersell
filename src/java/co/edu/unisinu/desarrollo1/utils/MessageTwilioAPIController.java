package co.edu.unisinu.desarrollo1.utils;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.math.BigDecimal;

public class MessageTwilioAPIController {

    public static final String ACCOUNT_SID = "AC68495c9a9b61a8716b99429499c76be7";
    public static final String AUTH_TOKEN = "7e630ffef507775b1a930e93291ee35c";

    public MessageTwilioAPIController() {
    }

    public String sendWhatsappMessage(String phone, String messageAtSend) {
        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:+57" + phone),
                    new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                    messageAtSend)
                    .create();
            System.out.println(message.getSid());
            System.out.println(message.getPrice());
            System.out.println(message.getErrorCode() + ": " + message.getErrorMessage());
            System.out.println(message.getStatus());
            return message.getSid();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
