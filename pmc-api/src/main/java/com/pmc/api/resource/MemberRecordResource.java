package com.pmc.api.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmc.dto.MemberRecordDto;
import com.pmc.dto.base.OperationResult;
import com.pmc.dto.base.PageInfo;
import com.pmc.service.MemberRecordService;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
@RestController
@RequestMapping("/member")
public class MemberRecordResource {

    private static Logger LOG = LoggerFactory.getLogger(MemberRecordResource.class);

    @Autowired
    private MemberRecordService service;

    @RequestMapping(value = "/for-approval", method = GET)
    public ResponseEntity<PageInfo<MemberRecordDto>> forApproval(Pageable page) {
        return null;
    }

    @RequestMapping(value = "/register/{registrationToken}", method = POST)
    public ResponseEntity<OperationResult<MemberRecordDto>> register(@PathVariable String registrationToken, @RequestBody MemberRecordDto registrant) {
        LOG.debug("Registration request. token={}, registrant={}", registrationToken, registrant);
        return new ResponseEntity<>(new OperationResult<MemberRecordDto>().withData(service.register(registrationToken, registrant)), OK);
    }

}
