package com.tencent.wxcloudrun.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 公众号订阅事件处理
 *
 * @author zhanghao
 * @version $$ Revision:1.0.0, $$ Date: 2022/11/30 9:39 $$
 */
@Slf4j
@Component
public class SubscribeHandler implements WxMpMessageHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

        try {
            log.info("公众号订阅事件处理  wxMessage:{}", wxMessage);

            String appId = wxMpService.getWxMpConfigStorage().getAppId();
            log.info("appId:{}",appId);
            // 调用guoquan-marketing查询回复的消息信息
//            List<WxMpKefuMessage> wxMpKefuMessageList = subscribeService.getSubscribeMessageByAppId(appId, wxMessage);
//            if (CollectionUtils.isNotEmpty(wxMpKefuMessageList)) {
//                for (WxMpKefuMessage mpKefuMessage : wxMpKefuMessageList) {
//                    // 调用微信发送客服消息
//                    boolean sendSuccess = wxMpService.getKefuService().sendKefuMessage(mpKefuMessage);
//                    if (!sendSuccess) {
//                        log.error("Send Official Account customer service message, wx response false. 入参:{} , 返回结果:{} ",
//                                JSON.toJSONString(mpKefuMessage), sendSuccess);
//                    }
//                }
//            }
        } catch (Exception e) {
            log.error("Send Official Account customer service message,{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }
}
