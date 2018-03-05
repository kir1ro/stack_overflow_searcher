package com.romanov.stack.exchange.consumer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.romanov.stack.exchange.consumer.repsitories.StackExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import java.io.IOException;

@Controller
public class SearchController {

    @Autowired
    private StackExchangeRepository stackExchangeRepository;

    @GetMapping("/")
    public String getSearchPage() {
        return "search_page";
    }

    @PostMapping("/questions")
    @ResponseBody
    public String getQuestions(@RequestBody JsonNode json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String title = json.findPath("title").asText();
        int page = json.findPath("page").asInt();
        return mapper.writeValueAsString((stackExchangeRepository.getQuestions(title, page)));
    }
}
