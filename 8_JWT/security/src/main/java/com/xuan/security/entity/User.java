package com.xuan.security.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data//生成getter和setter
@Builder//帮助轻松构造对象
@NoArgsConstructor//生成无参构造方法
@AllArgsConstructor//生成全参构造方法
//这三个注解经常一起出现，是固定搭配
@Entity
@Table(name = "_user")
public class User implements UserDetails
//SpringSecurity不认你写的User类，你要让他认你，其中一个方法就是实现它的UserDeatails接口
{

    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {//这个方法要先把password改成pass，不然data会帮写get
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    //Spring Security 用 getUsername() 的返回值作为用户的唯一标识符去做验证，跟叫不叫"username"没关系。

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //这里全部硬编码返回 true，意思是这套代码暂时不做账号状态管理，所有用户默认都是正常状态。
    //真实项目里这些值应该从数据库里读，比如用户被封号了 isEnabled 就返回 false。

}
