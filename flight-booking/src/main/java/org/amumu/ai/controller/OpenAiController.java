package org.amumu.ai.controller;

import org.amumu.ai.services.BookingTools;
import org.amumu.ai.services.LoggingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;


/**
 * @author xushu
 * @version 1.0
 * @description:
 */
@RestController
@CrossOrigin
public class OpenAiController  {

    private final ChatClient chatClient;

    public OpenAiController(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory, VectorStore vectorStore, BookingTools bookingTools, ToolCallbackProvider mcpTools) {
        this.chatClient = chatClientBuilder.defaultSystem(
			   """
					    您是“Amumu”航空公司的客户聊天支持代理。请以友好、乐于助人且愉快的方式来回复。
                        您正在通过在线聊天系统与客户互动。
                        在提供有关预订或取消预订的信息之前，您必须始终
                        从用户处获取以下信息：预订号、客户姓名。
                        在询问用户之前，请检查消息历史记录以获取此信息。
                        请讲中文。
                        今天的日期是 {current_date}.
                        在更改或退订function-call前，请先获取预订信息并且一定要等用户回复"确定"之后才进行更改或退订的function-call。 
				   	""").defaultAdvisors(
                               new PromptChatMemoryAdvisor(chatMemory),
                               new LoggingAdvisor(),
                               new QuestionAnswerAdvisor(vectorStore, SearchRequest.builder().build()))
                .defaultTools(bookingTools)
                .defaultTools(mcpTools)
//                .defaultFunctions("cancelBooking","getBookingDetails")
                .build();
    }

//    @Autowired
//    private VectorStore vectorStore;

    @CrossOrigin
    @GetMapping(value = "/ai/generateStreamAsString", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> generateStreamAsString(@RequestParam(value = "message", defaultValue = "讲个笑话") String message) {
        Flux<String> content = this.chatClient.prompt()
                .user(message)
                .system(promptSystemSpec -> promptSystemSpec.param("current_date", LocalDate.now().toString()))
                .advisors(advisorSpec -> advisorSpec.param(AbstractChatMemoryAdvisor.CHAT_MEMORY_RETRIEVE_SIZE_KEY, 100))
//                .advisors(new QuestionAnswerAdvisor(vectorStore,
//
//                        SearchRequest.builder().query(message)
//                                .similarityThreshold(0.6)
//                                .build()))
                .stream()
                .content();
        return content.concatWith(Flux.just("[complete]"));
    }



}
