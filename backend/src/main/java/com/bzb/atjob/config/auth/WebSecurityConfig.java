// package com.bzb.atjob.config.auth;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;

// @Configuration
// @EnableWebSecurity
// // @EnableConfigurationProperties(CustomConfig.class)
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//     // 禁用 csrf：引入 spring-boot-starter-security 后会自动启用 csrf，导致所有非 get 请求被阻止，
//     //           由于此后端仅用作提供 web api，所以可以禁用 csrf
//     http.csrf()
//         .disable()
//         // 禁止创建 Session，否则会占用内存
//         .sessionManagement()
//         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//   }

//   /**
//    * 授权管理.
//    *
//    * @return 认证管理对象
//    * @throws Exception 认证异常信息
//    */
//   @Override
//   @Bean
//   public AuthenticationManager authenticationManagerBean() throws Exception {
//     return super.authenticationManagerBean();
//   }
// }
