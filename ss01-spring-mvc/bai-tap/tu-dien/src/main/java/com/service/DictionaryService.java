package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("hello", "xin chào");
        stringMap.put("sorry", "xin lỗi");
        stringMap.put("bye", "tạm biệt");
        stringMap.put("one", "số 1");
    }
    @Override
    public String result(String key) {
        return stringMap.get(key);
    }
}
