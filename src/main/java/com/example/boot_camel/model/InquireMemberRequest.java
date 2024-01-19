package com.example.boot_camel.model;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@XmlRootElement(name = "inquireMemberRequest")
public class InquireMemberRequest {
    @XmlElement(name = "HapId")
    private HapId hapId;
    @XmlElement(name = "PersonBirthDate")
    private PersonBirthDate personBirthDate;
    @XmlElement(name="InitiatedBy")
    private InitiatedBy initiatedBy;

    // getters and setters
}