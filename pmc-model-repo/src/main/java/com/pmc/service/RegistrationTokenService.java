package com.pmc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmc.model.RegistrationToken;

public interface RegistrationTokenService extends JpaRepository<RegistrationToken, Long> {

}
