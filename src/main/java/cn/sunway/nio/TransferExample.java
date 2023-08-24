package cn.sunway.nio;

import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author sunw
 * @date 2023/5/26
 */
public class TransferExample {

    public static void main(String[] args) {
        try {
            FileChannel readChannel = FileChannel.open(Paths.get("source.txt"), StandardOpenOption.READ);
            FileChannel writeChannel = FileChannel.open(Paths.get("destination3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            long len = readChannel.size();
            long position = readChannel.position();
            //数据传输
            readChannel.transferTo(position, len, writeChannel);
            //效果和transferTo 一样的
            //writeChannel.transferFrom(readChannel, position, len, );
            readChannel.close();
            writeChannel.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
