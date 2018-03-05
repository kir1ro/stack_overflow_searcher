package com.romanov.stack.exchange.consumer.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchItem {
    private List<Question> questions = new ArrayList<>();
    private boolean hasMore;
    private int quotaMax;
    private int qoutaRemaining;
}
