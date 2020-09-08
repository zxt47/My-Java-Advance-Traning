package com.xtzhou.jpa.domain;

import lombok.Data;

/**
 * @author Zhouxiaotian
 * @version 1.0
 * @date 2020/9/8 12:12
 * @since 1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
