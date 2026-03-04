package org.example.nixnoughtnothing.order;

import lombok.Builder;

@Builder
public record Order(
        Long id,
        String reference
) {
}
