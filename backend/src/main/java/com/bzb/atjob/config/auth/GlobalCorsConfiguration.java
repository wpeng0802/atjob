// package com.bzb.atjob.config.auth;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;

// @Configuration
// public class GlobalCorsConfiguration {
//   @Bean
//   public CorsFilter corsFilter() {
//     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     source.registerCorsConfiguration("/**", buildConfig());
//     return new CorsFilter(source);
//   }

//   private CorsConfiguration buildConfig() {
//     CorsConfiguration corsConfiguration = new CorsConfiguration();
//     corsConfiguration.addAllowedOrigin("*");
//     corsConfiguration.addAllowedHeader("*");
//     corsConfiguration.addAllowedMethod("*");
//     return corsConfiguration;
//   }
// }
