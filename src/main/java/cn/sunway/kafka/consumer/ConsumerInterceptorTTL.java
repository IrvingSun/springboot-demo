package cn.sunway.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消费者拦截器，用来判断消费者收取到的消息，是否超过时间限制，超过就丢弃
 *
 * @author sunw
 * @date 2023/9/7
 */
public class ConsumerInterceptorTTL implements ConsumerInterceptor<String, String> {

    private static final Long EXPIRE = 5 * 1000L;//5秒

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> consumerRecords) {
        long now = System.currentTimeMillis();
        Map<TopicPartition, List<ConsumerRecord<String, String>>> newRecords = new HashMap<>();
        for (TopicPartition topicPartition : consumerRecords.partitions()) {
            List<ConsumerRecord<String, String>> tpRecords = consumerRecords.records(topicPartition);

            List<ConsumerRecord<String, String>> newTopicRecords = new ArrayList<>();
            for (ConsumerRecord<String, String> tpRecord : tpRecords) {
                if (now - tpRecord.timestamp() < EXPIRE) {
                    newTopicRecords.add(tpRecord);
                }
            }
            System.out.println("=====>过滤之后的消息大小: " + newTopicRecords.size());
            if (!newTopicRecords.isEmpty()) {
                newRecords.put(topicPartition, newTopicRecords);
            }
        }
        return new ConsumerRecords<>(newRecords);
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
        map.forEach((tp, offset) -> System.out.println(tp + ":" + offset.offset()));
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
