package cn.sunway.propertySourceLoader;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建json配置文件，读取数据，返回MapPropertySource
 * @author sunw
 * @date 2023/2/21
 */
public class DemoJsonPropertyLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        ReadableByteChannel readableByteChannel = resource.readableChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) resource.contentLength());
        readableByteChannel.read(byteBuffer);
        String content = new String(byteBuffer.array());
        JSONObject jsonObject = JSONUtil.parseObj(content);
        Map<String, Object> map = new HashMap<>(jsonObject.size());
        //将 json 的键值对读出来，放入到 map 中
        for (String key : jsonObject.keySet()) {
            map.put(key, jsonObject.getStr(key));
        }
        return Collections.singletonList(new MapPropertySource("jsonPropertySource", map));
    }
}
