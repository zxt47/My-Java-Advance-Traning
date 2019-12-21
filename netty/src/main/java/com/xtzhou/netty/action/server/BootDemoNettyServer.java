package com.xtzhou.netty.action.server;


import com.xtzhou.netty.action.adapter.BootNettyChannelInboundHandlerAdapter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.stereotype.Component;

/**
 * Spring Boot Demo Netty Server
 */
@Component
public class BootDemoNettyServer {

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
                pipeline.addLast(new LoggingHandler(LogLevel.INFO)).addLast("encoder",new StringEncoder())
                        .addLast("decoder",new StringDecoder());
                pipeline.addLast(new BootNettyChannelInboundHandlerAdapter());
            }
        });
        ChannelFuture f=serverBootstrap.bind(port).sync();
        f.channel().closeFuture().sync();
    }


}
