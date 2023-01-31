package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("red", "đỏ");
        dictionary.put("green", "xanh lá");
        dictionary.put("black", "đen");
        dictionary.put("white", "trắng");
    }

    @Override
    public String Search(String english) {
        String vietnamese = "not Found";
        if (dictionary.get(english) != null) {
            vietnamese = dictionary.get(english);
        }
        return vietnamese;
    }
}
