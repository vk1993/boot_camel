package com.example.boot_camel.model;

import jakarta.persistence.*;


@Entity
public class HAPInterfaceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;
    
    @ManyToOne
    private HAPServiceRequest request;
    
    private String logDetails;
    // other fields and getters/setters as needed
}