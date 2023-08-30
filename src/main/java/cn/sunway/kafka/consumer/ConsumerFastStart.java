package cn.sunway.kafka.consumer;

import org.apache.dubbo.config.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author sunw
 * @date 2023/8/29
 */
public class ConsumerFastStart {
    public static String bootStrap = "localhost:9092";
    public static String topic = "topic-demo";
    public static String group = "group.demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.deserializer", StringSerializer.class.getName());
        properties.put("value.deserializer", StringSerializer.class.getName());
        properties.put("bootstrap.servers", bootStrap);
        properties.put("group.id", group);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        consumer.subscribe(Collections.singleton(topic));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }
    }
}
