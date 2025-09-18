package com.tech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.jayway.jsonpath.JsonPath;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrackingNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetNextTrackingNumber() throws Exception {
        MvcResult result = mockMvc.perform(get("/next-tracking-number"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tracking_number").exists())
                .andExpect(jsonPath("$.created_at").exists())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        String trackingNumber = JsonPath.parse(responseBody).read("$.tracking_number");
        String createdAt = JsonPath.parse(responseBody).read("$.created_at");

        // Validate the tracking number format
        Pattern pattern = Pattern.compile("^[A-Z0-9]{1,16}$");
        assertTrue(pattern.matcher(trackingNumber).matches());

        // You can add more tests here, for example, to check the timestamp format
    }
}