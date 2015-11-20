package com.pmc.service;

import com.pmc.model.MemberRecord;
import com.pmc.service.base.TyraelJpaService;
import com.pmc.service.custom.MemberRecordServiceCustom;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public interface MemberRecordService extends MemberRecordServiceCustom, TyraelJpaService<MemberRecord> {

    Page<MemberRecord> findByApprovedDate(DateTime approvalDate, Pageable page);
    MemberRecord findByRegTokenToken(String token);

}
