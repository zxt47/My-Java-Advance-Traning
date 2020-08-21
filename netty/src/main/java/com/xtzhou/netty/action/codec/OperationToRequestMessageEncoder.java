package com.xtzhou.netty.action.codec;

import com.xtzhou.netty.action.common.Operation;
import com.xtzhou.netty.action.common.RequestMessage;
import com.xtzhou.netty.action.util.IdUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class OperationToRequestMessageEncoder extends MessageToMessageEncoder<Operation> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Operation operation, List<Object> out) throws Exception {
        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);

        out.add(requestMessage);
    }
}
