package com.xtzhou.netty.action.client;


import com.xtzhou.netty.action.codec.OrderFrameDecoder;
import com.xtzhou.netty.action.codec.OrderFrameEncoder;
import com.xtzhou.netty.action.codec.OrderProtocolDecoder;
import com.xtzhou.netty.action.codec.OrderProtocolEncoder;
import com.xtzhou.netty.action.common.RequestMessage;
import com.xtzhou.netty.action.common.order.OrderOperation;
import com.xtzhou.netty.action.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class BootDemoNettyClient {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        bootstrap.group(new NioEventLoopGroup());

        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());
                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
            }
        });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6379);

        try {
            channelFuture.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), new OrderOperation(1001, "tudou"));

        channelFuture.channel().writeAndFlush(requestMessage);

        try {
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
