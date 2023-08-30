package cn.sunway.kafka.producer;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * 在发送消息之前，修改消息的值
 * @author sunw
 * @date 2023/8/30
 */
public class CompanyInterceptor implements ProducerInterceptor<String, Company>{
    @Override
    public ProducerRecord<String, Company> onSend(ProducerRecord<String, Company> producerRecord) {
        String newValue = producerRecord.value().getName()+" [附加信息]";
        producerRecord.value().setName(newValue);
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
