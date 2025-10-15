package org.example.nixnoughtnothing.user;

import lombok.Builder;

@Builder
public record User(
        Long id,
        String name
) {
}
