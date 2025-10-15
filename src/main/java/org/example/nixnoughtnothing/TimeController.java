package org.example.nixnoughtnothing;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("/now")
    public ResponseEntity<Instant> getNow() {
        return ResponseEntity.ok(Instant.now());
    }
}
