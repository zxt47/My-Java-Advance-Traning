package com.xtzhou.netty.action.common.auth;

import com.xtzhou.netty.action.common.OperationResult;
import lombok.Data;

@Data
public class AuthOperationResult extends OperationResult {

    private final boolean passAuth;

}
