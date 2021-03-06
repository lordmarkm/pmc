package com.pmc.service.custom.impl;

import com.pmc.dto.base.PageInfo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.pmc.dto.MemberRecordDto;
import com.pmc.model.MemberRecord;
import com.pmc.model.RegistrationToken;
import com.pmc.service.MemberRecordService;
import com.pmc.service.RegistrationTokenService;
import com.pmc.service.base.TyraelJpaServiceCustomImpl;
import com.pmc.service.custom.MemberRecordServiceCustom;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
@Transactional
public class MemberRecordServiceCustomImpl
    extends TyraelJpaServiceCustomImpl<MemberRecord,  MemberRecordDto,  MemberRecordService>
    implements MemberRecordServiceCustom {

    @Autowired
    private RegistrationTokenService registrationTokenService;

    @Override
    public MemberRecordDto register(String registrationToken, MemberRecordDto registrant) {

        RegistrationToken token = registrationTokenService.findByToken(registrationToken);
        Preconditions.checkNotNull(token, "Registration token not found");
        Preconditions.checkArgument(token.getMemberRecord() == null, "Registration token is already in use");

        MemberRecord record = toEntity(registrant);
        record.setRegToken(token);
        record = repo.save(record);

        token.setMemberRecord(record);

        return toDto(record);
    }

    @Override
    public PageInfo<MemberRecordDto> findInfoByApprovalDate(DateTime approvalDate, Pageable page) {
        return toPageInfo(repo.findByApprovedDate(approvalDate, page));
    }

}
