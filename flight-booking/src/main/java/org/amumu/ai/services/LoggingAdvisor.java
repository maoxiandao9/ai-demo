package org.amumu.ai.services;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ai.chat.ChatResponse;
//import org.springframework.ai.chat.client.advisor.ChatClientAdvisor;
//import org.springframework.ai.chat.client.advisor.ChatClientRequestAdapter;
//import org.springframework.ai.chat.client.advisor.ChatClientResponseAdapter;
//import org.springframework.ai.chat.messages.Message;
//import org.springframework.ai.chat.messages.MessageType;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 对话日志记录器
// * 实现ChatClientAdvisor接口，记录AI对话的请求和响应
// */
//@Component
public class LoggingAdvisor{
//
//    private static final Logger log = LoggerFactory.getLogger(LoggingAdvisor.class);
//
//    @Override
//    public void afterRequest(ChatClientRequestAdapter chatClientRequestAdapter) {
//        // 记录用户请求信息
//        List<Message> userMessages = chatClientRequestAdapter.getMessages().stream()
//                .filter(message -> message.getMessageType() == MessageType.USER)
//                .toList();
//
//        if (!userMessages.isEmpty()) {
//            Message latestUserMessage = userMessages.get(userMessages.size() - 1);
//            log.info("用户发送消息: {}", latestUserMessage.getContent());
//        }
//
//        // 记录系统提示信息
//        List<Message> systemMessages = chatClientRequestAdapter.getMessages().stream()
//                .filter(message -> message.getMessageType() == MessageType.SYSTEM)
//                .toList();
//
//        if (!systemMessages.isEmpty() && log.isDebugEnabled()) {
//            Message systemMessage = systemMessages.get(0);
//            log.debug("系统提示信息: {}", systemMessage.getContent());
//        }
//    }
//
//    @Override
//    public void afterCompletion(ChatClientRequestAdapter chatClientRequestAdapter,
//                               ChatClientResponseAdapter chatClientResponseAdapter) {
//        // 记录AI响应信息
//        ChatResponse chatResponse = chatClientResponseAdapter.getChatResponse();
//        String responseContent = chatResponse.getResult().getOutput().getContent();
//        log.info("AI响应: {}", responseContent);
//
//        // 打印对话历史分隔线
//        log.info("--------- 对话完成 ---------");
//    }
}
