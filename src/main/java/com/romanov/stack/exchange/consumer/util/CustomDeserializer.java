package com.romanov.stack.exchange.consumer.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.romanov.stack.exchange.consumer.model.Question;
import com.romanov.stack.exchange.consumer.model.SearchItem;

import java.io.IOException;
import java.util.List;

public class CustomDeserializer extends JsonDeserializer<SearchItem> {
    public CustomDeserializer() {
    }

    @Override
    public SearchItem deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        SearchItem searchItem = new SearchItem();
        searchItem.setHasMore(node.get("has_more").asBoolean());
        searchItem.setQuotaMax(node.get("quota_max").asInt());
        searchItem.setQoutaRemaining(node.get("quota_remaining").asInt());

        JsonNode items = node.get("items");

        ObjectMapper mapper = new ObjectMapper();
        List<Question> questions = mapper.readValue(items.toString(), new TypeReference<List<Question>>() {
        });
        searchItem.setQuestions(questions);

        return searchItem;
    }
}
