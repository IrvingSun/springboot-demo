package cn.sunway.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServerExample {
    public static void main(String[] args) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();

        // 创建服务器套接字通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("localhost", 8888));
        serverChannel.configureBlocking(false);

        // 将服务器通道注册到选择器上，并监听连接事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port 8888");

        while (true) {
            // 阻塞等待事件发生
            selector.select();

            // 获取发生事件的键集合
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    // 接受新连接
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);

                    // 将新连接的通道注册到选择器上，并监听读事件
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("New client connected: " + clientChannel.getRemoteAddress());
                } else if (key.isReadable()) {
                    // 读取客户端数据
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = clientChannel.read(buffer);

                    if (bytesRead > 0) {
                        buffer.flip();
                        byte[] data = new byte[buffer.limit()];
                        buffer.get(data);
                        String message = new String(data);
                        System.out.println("Received message from client: " + message);

                        // 响应客户端
                        String response = "Hello, client!";
                        ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
                        clientChannel.write(responseBuffer);
                    } else if (bytesRead == -1) {
                        // 客户端连接关闭
                        clientChannel.close();
                        System.out.println("Client disconnected: " + clientChannel.getRemoteAddress());
                    }
                }

                // 从键集合中移除当前键，避免重复处理
                keyIterator.remove();
            }
        }
    }
}