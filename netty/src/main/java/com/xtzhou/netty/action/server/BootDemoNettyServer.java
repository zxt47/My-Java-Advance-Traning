package com.xtzhou.netty.action.server;


import com.xtzhou.netty.action.codec.OrderFrameDecoder;
import com.xtzhou.netty.action.codec.OrderFrameEncoder;
import com.xtzhou.netty.action.codec.OrderProtocolDecoder;
import com.xtzhou.netty.action.codec.OrderProtocolEncoder;
import com.xtzhou.netty.action.server.handler.OrderServerProcessHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.stereotype.Component;

/**
 * Spring Boot Demo Netty Server
 */
@Component
public class BootDemoNettyServer {

    /**
     *
     * @param port
     * @throws Exception
     */
    public void bind(int port) throws Exception
    {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup(5);
        ServerBootstrap serverBootstrap=new ServerBootstrap().group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO));
        serverBootstrap.option(ChannelOption.RCVBUF_ALLOCATOR,new AdaptiveRecvByteBufAllocator())
                .childOption(ChannelOption.RCVBUF_ALLOCATOR,new AdaptiveRecvByteBufAllocator());
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());
                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));

                pipeline.addLast(new OrderServerProcessHandler());
            }
        });
        ChannelFuture f=serverBootstrap.bind(port).sync();
        f.channel().closeFuture().sync();
    }


}
