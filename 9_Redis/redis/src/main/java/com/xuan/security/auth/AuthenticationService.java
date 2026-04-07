package com.xuan.security.auth;

import com.xuan.security.config.JwtService;
import com.xuan.security.entity.Role;
import com.xuan.security.entity.User;
import com.xuan.security.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        //register 完整流程是三步：
        //把用户信息取出来，密码加密
        //存进数据库
        //生成 token 返回给前端
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        //验证用户名和密码是否正确
        //具体是把用户输入的 email 和 password 交给 AuthenticationManager，
        //它内部会调用之前 ApplicationConfig 里配置的 AuthenticationProvider，去数据库查用户，然后比对密码，密码不对直接抛异常
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

        //完整流程是三步：
        //1.验证用户名和密码
        //2.生成JwtToken
        //3.返回token
    }
}
