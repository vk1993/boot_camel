package com.example.boot_camel.service;

import com.example.boot_camel.model.HAPServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HAPServiceRequestRepository extends JpaRepository<HAPServiceRequest,Long> {
}
