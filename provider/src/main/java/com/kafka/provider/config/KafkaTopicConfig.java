package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configuration = new HashMap<>();

        //delete (Borra mensaje después de un tiempo), compact (Mantiene el último mensaje)
        configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);

        //Tiempo de retención de mensajes en milisegundos, por defecto en -1 (nunca se borrarán)
        configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");

        //Tamaño máximo de los segmentos dentro del topic en bytes, por defecto 1 GB
        configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");

        //Tamaño máximo de cada mensaje en bytes, por defecto es de 1 MB
        configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1024");

        return TopicBuilder
                .name("ejemploTopic")
                .replicas(2)
                .configs(configuration)
                .build();
    }
}
