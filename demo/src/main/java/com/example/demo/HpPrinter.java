package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {
    @Value("${printer.name}")
    private String name;
    @Value("${printer.count:30}")
    private int count;

    @Override
    public void print(String message) {
        count--;
        System.out.println(name+":"+message);
        System.out.println("剩餘使用數字"+count);
    }
}
