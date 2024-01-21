package com.example.boot_camel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HAPInterfaceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String request;

    @OneToOne
    @JoinColumn(name = "requestId")
    private HAPServiceRequest serviceRequest;
}