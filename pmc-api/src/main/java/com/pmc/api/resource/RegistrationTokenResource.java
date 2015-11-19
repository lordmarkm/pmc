package com.pmc.api.resource;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmc.dto.RegistrationTokenDto;
import com.pmc.service.RegistrationTokenService;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
@RestController
@RequestMapping("/regtoken")
public class RegistrationTokenResource {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationTokenResource.class);

    @Autowired
    private RegistrationTokenService service;

    @RequestMapping(value = "/generate", method = GET)
    public ResponseEntity<List<RegistrationTokenDto>> generate(
            @ApiParam(allowableValues = "dbx,sdi") @RequestParam String countryCode,
            @ApiParam(defaultValue = "5") @RequestParam int count) {
        LOG.debug("Token generation request. countryCode={}, count={}", countryCode, count);
        return new ResponseEntity<>(service.generate(countryCode, count), OK);
    }

}

