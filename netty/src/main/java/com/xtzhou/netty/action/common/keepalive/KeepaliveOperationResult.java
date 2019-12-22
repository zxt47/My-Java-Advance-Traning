package com.xtzhou.netty.action.common.keepalive;

import com.xtzhou.netty.action.common.OperationResult;
import lombok.Data;

@Data
public class KeepaliveOperationResult extends OperationResult {

    private final long time;

}
