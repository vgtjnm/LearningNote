package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {

    @Autowired
    private AppConfigService appConfigService;

    @GetMapping("/config")
    public Map<String,Object> getConfig(){
        Map<String,Object> result = new HashMap<>();
        result.put("name",appConfigService.getName());
        result.put("version",appConfigService.getVersion());
        result.put("maxProductCount",appConfigService.getMaxProductCount());
        return result;
    }
}
