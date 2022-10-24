package factories;

import models.MessageDto;

public class MessageFactory {

    public static MessageDto create(String message) {
        return new MessageDto(message);
    }
}
