package com.example.boot_camel.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InitiatedBy {
    // You may need to handle the CHOICE of 0ther and NPI here
    private String other;
    private String NPI;

    // getters and setters
}