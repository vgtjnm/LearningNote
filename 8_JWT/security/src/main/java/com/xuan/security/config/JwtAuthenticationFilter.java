package com.xuan.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {//Once就是每次用户请求都需要验证

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        //这里的 request 是 HTTP 请求
        //getHeader("Authorization") 是从 HTTP 请求头里取出 Authorization 字段
        //取出来的内容长这样：
        //Bearer xxxxxx.yyyyyy.zzzzzz
        //这个不是 JWT 的 Header 部分，是 HTTP 请求头里的 Authorization 字段，里面包含了完整的 JWT Token
        //所以 authHeader = "Bearer xxxxxx.yyyyyy.zzzzzz" 整个字符串

        //这个请求是客户端生成的，用户不可能会这些，不过客户端会从用户输入的一些信息去转化
        //用户只管输入用户名密码，前端（客户端）负责把 Token 存起来，每次发请求的时候自动加上 Authorization: Bearer xxx 这个请求头，用户完全感知不到。

        final String jwt;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            //意思是放行，交给下一个过滤器继续处理。过滤器链里有很多过滤器，这行就是说"我这里处理完了，传给下一个
            //没有 Token 不会去"拿 Token"，拿 Token 是登录的事，过滤器不管这个
            return;
        }
        jwt = authHeader.substring(7);
        //substring(7) 是把前7个字符截掉，数一下：
        //B-e-a-r-e-r-空格 正好7个字符，截掉之后剩下的是完整的 JWT Token：
        //xxxxxx.yyyyyy.zzzzzz
        //B-e-a-r-e-r-空格 正好7个字符，截掉之后剩下的是完整的 JWT Token：
        //xxxxxx.yyyyyy.zzzzzz

        //然后 jwtService.extractUsername(jwt) 是把这个完整 JWT 传给 JwtService，从里面解析出用户名（邮箱）
        //不是只有 Payload，是整个 JWT 三段都在。

        userEmail = jwtService.extractUsername(jwt);
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null)
            //SecurityContextHolder 是 Security 用来存放当前请求已认证用户信息的地方。
            //你可以理解为：这个请求认证通过了，就把用户信息放进去，后续任何地方都能从这里取。
            //userEmail != null：Token 里成功解析出了用户名
            //SecurityContextHolder.getContext().getAuthentication() == null：这个请求还没有被认证过
            //两个条件合在一起：有用户名，但还没认证过，才进去验证。防止同一个请求被重复认证。
        {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
                //验证通过之后，Security 需要知道"这个请求是谁发的，他有什么权限"，这些信息要主动告诉它，它不会自己去找。
                //所以这段做了两件事：
                //把用户信息和权限打包成一个 UsernamePasswordAuthenticationToken 对象
                //放进 SecurityContextHolder，告诉 Security：这个请求已经认证通过了，用户是 ta，权限是这些
            }
        }
        filterChain.doFilter(request, response);

        //JwtAuthenticationFilter 整个流程你现在都理解了，总结一下它做的事：
        //从请求头取出 Token
        //格式不对直接放行
        //从 Token 解析出用户名
        //去数据库查用户，确认用户真实存在且合法
        //验证 Token 有效
        //把用户信息放进 SecurityContextHolder，标记为已认证
        //放行

    }
}
