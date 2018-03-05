package com.romanov.stack.exchange.consumer.repsitories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.romanov.stack.exchange.consumer.model.SearchItem;
import com.romanov.stack.exchange.consumer.util.SearchProperty;
import com.romanov.stack.exchange.consumer.util.CustomDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StackExchangeRepository {

    @Autowired
    private RestTemplate restTemplate;

    public SearchItem getQuestions(String title, int page) {
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(SearchProperty.STACK_EXCHANGE_API_URL +
                "?page=" + page + SearchProperty.ORDER + SearchProperty.SORT + "&intitle=" + title + SearchProperty.SITE,
            Object.class);
        
        Object body = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(SearchItem.class, new CustomDeserializer());
        mapper.registerModule(module);

        SearchItem searchItem = mapper.convertValue(body, SearchItem.class);
        return searchItem;
    }
}
