package com.example.boot_camel.model;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class InquireMemberRequest {
    private HapId hapId;
    private PersonBirthDate personBirthDate;
    private InitiatedBy initiatedBy;

    // getters and setters
}