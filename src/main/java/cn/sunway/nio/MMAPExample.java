package cn.sunway.nio;

import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author sunw
 * @date 2023/5/26
 */
public class MMAPExample {

    public static void main(String[] args){
        try {
            FileChannel readChannel = FileChannel.open(Paths.get("source.txt"), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get("destination2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            MappedByteBuffer data = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, 1024 * 4);
            //数据传输
            writeChannel.write(data);
            readChannel.close();
            writeChannel.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
