package com.pmc.service;

import com.pmc.dto.MemberRecordDto;
import org.joda.time.DateTime;

/**
 * Created by mbmartinez on 11/20/15.
 */
public interface MemberApprovalService {

    MemberRecordDto approve(String regToken, DateTime expirationDate);
    MemberRecordDto renew(String regToken, DateTime expirationDate);

}
