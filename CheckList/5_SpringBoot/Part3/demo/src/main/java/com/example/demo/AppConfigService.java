package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppConfigService {

    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    @Value("${app.max-product-count}")
    private int maxProductCount;

    public int getMaxProductCount() {
        return maxProductCount;
    }

    public void setMaxProductCount(int maxProductCount) {
        this.maxProductCount = maxProductCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
