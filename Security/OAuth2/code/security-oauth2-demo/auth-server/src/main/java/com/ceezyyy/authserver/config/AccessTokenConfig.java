package com.ceezyyy.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class AccessTokenConfig {
    @Bean
    TokenStore tokenStore() {
        // 配置 token 存储在内存中
        return new InMemoryTokenStore();
    }
}
