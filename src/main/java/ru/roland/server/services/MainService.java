package ru.roland.server.services;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Service;
import ru.roland.server.configs.MainConfig;
import ru.roland.server.handlers.ByteToPacketDecoder;

import java.net.InetSocketAddress;

@Service
public class MainService {

    public MainService(MainConfig mainConfig) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.localAddress(new InetSocketAddress(mainConfig.getHost(), mainConfig.getPort()));
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) {
                socketChannel.pipeline().addLast(new ByteToPacketDecoder());
            }
        });
        ChannelFuture channelFuture = serverBootstrap.bind().sync();
    }

}
