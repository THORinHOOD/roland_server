package ru.roland.server.services;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.roland.server.configs.MainConfig;
import ru.roland.server.handlers.ByteToPacketDecoder;

import java.net.InetSocketAddress;

@Service
@Log4j2
public class TcpServerService {

    private ServerBootstrap serverBootstrap;
    private ChannelFuture channelFuture;
    private EventLoopGroup group;

    public TcpServerService(MainConfig mainConfig) {
        group = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.localAddress(new InetSocketAddress(mainConfig.getHost(), mainConfig.getPort()));
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) {
                socketChannel.pipeline().addLast(new ByteToPacketDecoder());
            }
        });
    }

    public void startTcpServer() throws Exception {
        channelFuture = serverBootstrap.bind().sync();
    }

}
