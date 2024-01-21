package com.example.boot_camel.service;

import com.example.boot_camel.model.HAPInterfaceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HAPInterfaceLogRepository extends JpaRepository<HAPInterfaceLog, Long> {
}
