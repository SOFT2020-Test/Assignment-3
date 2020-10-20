package servicelayer.notifications;

import dto.SmsMessage;

public class SmsServiceImpl implements SmsService {
    @Override
    public boolean sendSms(SmsMessage message) throws SmsServiceException {
        try {
            if(message == null) {
                throw new SmsServiceException("SMS ERROR: message cannot be null..." );
            }
            if(message.getRecipient().isEmpty()) {
                throw new SmsServiceException("SMS ERROR: message must have a recipient...");
            }
            if(message.getMessage().isEmpty()) {
                throw new SmsServiceException("SMS ERROR: message is empty...");
            }
            else {
                return true;
            }
        } catch (Exception ex) {
            throw new SmsServiceException(ex.getMessage());
        }
    }
}
