package com.example.boot_camel.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InquirePayloadDto {

    String id;
    String personBirthDate;
}
