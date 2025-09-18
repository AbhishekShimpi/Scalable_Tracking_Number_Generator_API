package com.tech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.TrackingNumberGenerator;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackingNumberController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getNextTrackingNumber(
            @RequestParam(required = false) String origin_country_id,
            @RequestParam(required = false) String destination_country_id,
            @RequestParam(required = false) String weight,
            @RequestParam(required = false) String created_at,
            @RequestParam(required = false) String customer_id,
            @RequestParam(required = false) String customer_name,
            @RequestParam(required = false) String customer_slug
    ) {
        // Generate a new unique tracking number
        String trackingNumber = TrackingNumberGenerator.generate();

        // Get the current timestamp and format it in RFC 3339
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        String formattedCreatedAt = now.toString();

        // Create the JSON response body
        Map<String, String> response = new HashMap<>();
        response.put("tracking_number", trackingNumber);
        response.put("created_at", formattedCreatedAt);

        // Return the response as a JSON object with a 200 OK status
        return ResponseEntity.ok(response);
    }
}