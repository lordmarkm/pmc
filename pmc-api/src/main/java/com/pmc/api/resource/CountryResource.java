package com.pmc.api.resource;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmc.dto.CountryDto;
import com.pmc.dto.base.OperationResult;

@RestController
@RequestMapping("/country")
public class CountryResource {

    @RequestMapping(method = POST)
    public ResponseEntity<OperationResult<CountryDto>> saveCountry(@RequestBody CountryDto country) {
        //TODO
        return null;
    }

}
