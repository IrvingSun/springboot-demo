package cn.sunway.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.assertj.core.util.Lists;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * 从指定位置拉取消息
 * @author sunw
 */
public class ConsumerSeek {
    public static String bootStrap = "localhost:9092";
    public static String topic = "topic-demo";
    public static String group = "group.demo.2";
    public static final AtomicBoolean isRunning = new AtomicBoolean(true);


    public static Properties initConfig() {
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
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
//        consumer.subscribe(Collections.singleton(topic));

        //获取分区
        List<PartitionInfo> partitions = consumer.partitionsFor(topic);
        // 由于自测环境只有一个分区，所以直接获取
        PartitionInfo partitionInfo = partitions.get(0);
        TopicPartition topicPartition = new TopicPartition(partitionInfo.topic(), partitionInfo.partition());

        //从指定partition的指定位置拉取（从第一个位置开始拉取）
        consumer.assign(Lists.list(topicPartition));
        consumer.seek(topicPartition, 1);
//        consumer.seekToEnd(Lists.list(topicPartition));
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));


        OffsetAndMetadata offsetAndMetadata = consumer.committed(topicPartition);
        // 提交的offset是消费消息的offset + 1
        System.out.println(String.format("==> committed offset is %d", offsetAndMetadata.offset()));

        for (ConsumerRecord<String, String> record : records) {
            System.out.println(String.format("offset = %d", record.offset()));
            System.out.println(record);
//                consumer.commitSync();//同步提交
            System.out.println(String.format("offset = %d", record.offset()));//获取提交的offset
        }
    }
}
