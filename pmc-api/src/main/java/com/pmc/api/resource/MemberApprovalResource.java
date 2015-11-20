package com.pmc.api.resource;

import com.pmc.dto.MemberRecordDto;
import com.pmc.dto.base.OperationResult;
import com.pmc.service.MemberApprovalService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * Created by mbmartinez on 11/20/15.
 */
@RestController
@RequestMapping("/member-approval")
public class MemberApprovalResource {

    @Autowired
    private MemberApprovalService service;

    @RequestMapping(method = PUT)
    public ResponseEntity<OperationResult<MemberRecordDto>> approveMember(@RequestParam String regToken, @RequestParam DateTime expirationDate) {
        OperationResult<MemberRecordDto> result = new OperationResult<>(service.approve(regToken, expirationDate));
        return new ResponseEntity<OperationResult<MemberRecordDto>>(result, OK);
    }

    @RequestMapping(value = "/renew", method = PUT)
    public ResponseEntity<OperationResult<MemberRecordDto>> renewMember(@RequestParam String regToken, @RequestParam DateTime expirationDate) {
        OperationResult<MemberRecordDto> result = new OperationResult<>(service.renew(regToken, expirationDate));
        return new ResponseEntity<OperationResult<MemberRecordDto>>(result, OK);
    }

}
