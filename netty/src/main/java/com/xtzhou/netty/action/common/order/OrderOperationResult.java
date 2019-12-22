package com.xtzhou.netty.action.common.order;


import com.xtzhou.netty.action.common.OperationResult;
import lombok.Data;

@Data
public class OrderOperationResult extends OperationResult {

    private final int tableId;
    private final String dish;
    private final boolean complete;

}
