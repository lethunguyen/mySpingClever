package com.example.servingwebcontent.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class getProperties {

    @Value("${spring.datasource.url}") @Autowired private String url;
    
    public String getURL() {
            return url;
        }
    
}
