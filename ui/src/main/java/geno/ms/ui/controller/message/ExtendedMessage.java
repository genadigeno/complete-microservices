package geno.ms.ui.controller.message;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import java.util.Map;

public class ExtendedMessage extends Message {
    public ExtendedMessage(byte[] body) {
        super(body);
    }

    public ExtendedMessage(byte[] body, MessageProperties messageProperties) {
        super(body, messageProperties);
    }

    private Map<String, ?> metaData;

    public Map<String, ?> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, ?> metaData) {
        this.metaData = metaData;
    }
}
