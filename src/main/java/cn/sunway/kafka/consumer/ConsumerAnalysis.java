package cn.sunway.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author sunw
 */
public class ConsumerAnalysis {
    public static String bootStrap = "localhost:9092";
    public static String topic = "topic-demo";
    public static String group = "group.demo.2";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);


    public static Properties initConfig(){
        Properties properties = new Properties();
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        properties.put("bootstrap.servers", bootStrap);
        properties.put("group.id", group);
        properties.put("client.id", "consumer.client.id.demo");
        return properties;
    }

    public static void main(String[] args) {

        Properties properties = initConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singleton(topic));

        while (isRunning.get()) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
                System.out.println(record);
            }
        }
    }
}
