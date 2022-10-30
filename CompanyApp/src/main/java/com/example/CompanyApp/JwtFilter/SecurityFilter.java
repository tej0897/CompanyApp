package com.example.CompanyApp.JwtFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String authHeader = httpServletRequest.getHeader("authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer")){
            throw new ServletException("Missing or Invalid Authentication header");
        }

        String jwtToken = authHeader.substring(7); // to remove the bearer part and get only token

        System.out.println(authHeader);

        // claims will have some key with some value
        // claims the token body, signed with the serial key
        // secret key with token -> Claims holds
        // whenever claims is referred, it will be associated with secret key and jwt token

        Claims claims = Jwts.parser().setSigningKey("secret key").parseClaimsJws(jwtToken).getBody();

        httpServletRequest.setAttribute("empName", claims);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
