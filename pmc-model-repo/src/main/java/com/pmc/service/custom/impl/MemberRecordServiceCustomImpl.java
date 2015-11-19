package com.pmc.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
        Preconditions.checkNotNull(token);
        Preconditions.checkArgument(token.getMemberRecord() == null);

        MemberRecord record = toEntity(registrant);
        record.setRegToken(token);
        record = repo.save(record);

        token.setMemberRecord(record);

        return toDto(record);
    }

}
