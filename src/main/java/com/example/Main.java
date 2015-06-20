package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ItemConfig.Item;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    ItemConfig itemConfig;
    
    
    public static void main(String[] args) {
        System.getProperties().put("jasypt.encryptor.password", "change_me");
        SpringApplication.run(Main.class, args);
    }
    
    public void run(String... arg0) throws Exception {
        System.out.println("Started");
        
        // those properties are correctly read.
        System.out.println("Configuration name : " + itemConfig.getConfigurationName());
        System.out.println("Password : " + itemConfig.getPassword());
        
        // itemConfig.getitems() throws NPE.
        for (Item item : itemConfig.getItems()) {            
            System.out.println("item name" + item.getName());
            System.out.println("member value" + item.getValue());
        }
    }

}
