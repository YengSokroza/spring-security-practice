package co.istad.springsecuritybasic.model.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        String id,
        String email,
        String password,
        Set<String> roles
) {
}
