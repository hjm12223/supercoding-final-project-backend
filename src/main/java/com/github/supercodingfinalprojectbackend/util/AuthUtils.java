package com.github.supercodingfinalprojectbackend.util;

import com.github.supercodingfinalprojectbackend.entity.type.UserRole;
import com.github.supercodingfinalprojectbackend.exception.errorcode.ApiErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AuthUtils {
    private AuthUtils() {};

    public static Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw ApiErrorCode.NOT_AUTHENTICATED.exception();
        return Long.parseLong((String) authentication.getPrincipal());
    }

    public static UserRole getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw ApiErrorCode.NOT_AUTHENTICATED.exception();
        Set<GrantedAuthority> authorities = new HashSet<>(authentication.getAuthorities());
        String roleName =  Objects.requireNonNull(authorities.stream().findFirst().orElse(null)).getAuthority();
        return UserRole.valueOf(roleName);
    }
}