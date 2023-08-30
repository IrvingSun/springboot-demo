package cn.sunway.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author sunw
 * @date 2023/8/29
 */
public class ProducerCustomerSerializerDemo {

    public static String brokerList = "localhost:9092";
    public static String topic = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CompanySerializer.class.getName());//自定义的序列化器
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, CompanyInterceptor.class.getName());//自定义的拦截器
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);

        KafkaProducer<String, Company> producer = new KafkaProducer<>(properties);

        Company company = new Company();
        company.setName("CompanyName");
        company.setAddress("CompanyAddress");
        ProducerRecord<String, Company> record = new ProducerRecord<>(topic, company);

        Future<RecordMetadata> future = producer.send(record);
        try {
            RecordMetadata metadata = future.get();
            System.out.println(metadata.topic() + " - " + metadata.partition() + " : " + metadata.offset());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
