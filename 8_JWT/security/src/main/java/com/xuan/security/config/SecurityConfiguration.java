package com.xuan.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;  // 改这里

    //补一些之前漏掉的知识：

    //IOC 是什么：
    //正常情况下，你要用一个对象，得自己 new：
    //UserService userService = new UserService();
    //IOC 的意思是：你不用自己 new，Spring 帮你创建、帮你管理。
    //你只需要加个注解，Spring 启动的时候就自动把这个对象创建好，放进一个"容器"里。你要用的时候，直接从容器里取（@Autowired），不用自己 new。

    //@Bean 是什么：
    //@Bean 就是告诉 Spring：这个方法返回的对象，你帮我放进容器里管理。
    //比如：
    //@Bean
    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}
    //意思是：Spring 启动时，调这个方法，把返回的 BCryptPasswordEncoder 对象放进容器，以后谁需要 PasswordEncoder，直接注入就行，不用自己 new。

    //@Configuration 是什么：
    //就是告诉 Spring：这个类里面有 @Bean，你启动的时候来这里扫一遍。
    //
    //这三个东西合在一起就是：Spring 启动 → 扫到 @Configuration → 执行里面的 @Bean 方法 → 把对象放进容器 → 之后谁需要就注入谁。

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .anyRequest().authenticated()
                        //这段合在一起的意思是：
                        //
                        // /api/v1/auth/** 这个路径下的请求（登录、注册）全部放行，不需要 Token
                        //其他任何请求，必须有 Token 才能访问
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        //STATELESS = 无状态。
                        //这行的意思是：告诉 Security 不要创建 Session，保持无状态。
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                //这行的意思是：把我们自己写的 JwtAuthenticationFilter 插到 Security 默认的登录过滤器前面。
                //为什么要插在前面？因为我们要先拦截请求，取出 Token 验证身份，验证通过了再让 Security 继续走后面的流程。

        return http.build();

    }

    //SecurityConfiguration 你现在基本看懂了。总结一下它做了四件事：
    //关掉 CSRF
    //设置哪些路径放行，哪些需要 Token
    //关掉 Session，改用无状态
    //把 JWT 过滤器插到过滤器链里

}
