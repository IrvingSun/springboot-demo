package cn.sunway.kafka.client;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.assertj.core.util.Lists;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * 通过AdminClient获取topic信息
 * @author sunw
 * @date 2023/9/11
 */
public class AdminClientFastStart {
    public static String brokerList = "localhost:9092";
    public static String topic = "topic-demo";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
        AdminClient adminClient = AdminClient.create(properties);

        DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Lists.list(topic));
        for(String key : describeTopicsResult.values().keySet()){
            System.out.println("key = " + key);
            KafkaFuture<TopicDescription> descriptionKafkaFuture = describeTopicsResult.values().get(key);
            TopicDescription topicDescription = descriptionKafkaFuture.get();
            System.out.println("Topic info ==>" + topicDescription);
        }

        //adminClient.createTopics()  创建topic
        //adminClient.createPartitions()  创建分区
    }
}
