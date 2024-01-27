package com.example.boot_camel.model;


import lombok.Data;


@Data
public class InquireMemberRequest {
    private HapId hapId;
    private PersonBirthDate personBirthDate;
    private InitiatedBy initiatedBy;

    // getters and setters
}