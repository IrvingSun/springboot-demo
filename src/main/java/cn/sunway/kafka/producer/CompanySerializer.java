package cn.sunway.kafka.producer;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CompanySerializer implements Serializer<Company> {
    private String encoding = "UTF8";

    public CompanySerializer() {
    }

    public void configure(Map<String, ?> configs, boolean isKey) {
        String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null) {
            encodingValue = configs.get("serializer.encoding");
        }

        if (encodingValue instanceof String) {
            this.encoding = (String)encodingValue;
        }

    }

    /**
     * 自定义的序列化器，只序列化Company对象的name字段，其他字段忽略
     * @param topic
     * @param data
     * @return
     */
    public byte[] serialize(String topic, Company data) {
        try {
            return data == null ? null : data.getName().getBytes(this.encoding);
        } catch (UnsupportedEncodingException var4) {
            throw new SerializationException("Error when serializing string to byte[] due to unsupported encoding " + this.encoding);
        }
    }

    public void close() {
    }
}