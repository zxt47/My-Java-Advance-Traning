package com.xtzhou.netty.action.adapter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BootNettyChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("channelRead:read msg:"+msg.toString());
        ctx.write("I got it");
    }
}
