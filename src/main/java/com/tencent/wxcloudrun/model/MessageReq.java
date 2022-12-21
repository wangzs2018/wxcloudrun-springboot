package com.tencent.wxcloudrun.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title
 * @Description
 * @Author wangzhengshi
 * @Version 1.0.0
 * @CraeteTime 2022/12/21 17:29
 **/
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MessageReq {
    @JsonProperty("action")
    private String action;
}
