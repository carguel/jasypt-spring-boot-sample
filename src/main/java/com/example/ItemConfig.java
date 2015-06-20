package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="itemConfig")
public class ItemConfig {
    
    // property read from the application.yml
    @Value("${itemConfig.configurationName}")
    private String configurationName;
    
    // property read from the application.yml
    @Value("${itemConfig.password}")
    private String password;
    
    // should be populated from items nested collection
    // found in application.yml
    private List<Item> items;
    
    public String getConfigurationName() {
        return configurationName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    // Maps an item entry in the application.yml.
    public static class Item {
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        private String name;
        
        private Integer value;
    }

}
