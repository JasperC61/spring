package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {


    @Override
    public void print(String message) {
        System.out.println("hp印表機"+message);
    }
}
