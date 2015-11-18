package com.pmc.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmc.service.RegistrationTokenService;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
@RestController
@RequestMapping("/regtoken")
public class RegistrationTokenResource {

    @Autowired
    private RegistrationTokenService service;


}
