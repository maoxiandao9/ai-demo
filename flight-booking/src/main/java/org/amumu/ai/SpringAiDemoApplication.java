package org.amumu.ai;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

/**
 * @author xushu
 * @version 1.0.0
 * @description 智能航空助手:需要一对一解答关注wx: 程序员徐庶
 */
@SpringBootApplication
public class SpringAiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner ingestTermOfServiceToVectorStore(VectorStore vectorStore,
                                                       @Value("classpath:rag/terms-of-service.txt") Resource termsOfServiceDocs) {

        return args -> {
            vectorStore.write(                                  // 3.写入向量数据库
                    new TokenTextSplitter().transform(          // 2.分隔、向量化
                            new TextReader(termsOfServiceDocs).read())  // 1.读取文本
            );
        };
    }
}
