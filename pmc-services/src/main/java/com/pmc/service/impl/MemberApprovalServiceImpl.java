package com.pmc.service.impl;

import com.google.common.base.Preconditions;
import com.pmc.dto.MemberRecordDto;
import com.pmc.model.MemberRecord;
import com.pmc.service.MemberApprovalService;
import com.pmc.service.MemberRecordService;
import com.pmc.service.base.MappingService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mbmartinez on 11/20/15.
 */
@Service
@Transactional
public class MemberApprovalServiceImpl extends MappingService<MemberRecord, MemberRecordDto>
        implements MemberApprovalService {

    @Autowired
    private MemberRecordService memberRecordService;

    @Override
    public MemberRecordDto approve(String regToken, DateTime expirationDate) {
        MemberRecord member = memberRecordService.findByRegTokenToken(regToken);
        Preconditions.checkNotNull(member, "No member has registered with the given registration token");
        Preconditions.checkArgument(!member.isApproved(), "Member has already been approved");
        Preconditions.checkArgument(expirationDate.isAfter(DateTime.now()), "Expiration date must be in the future");

        member.setApprovedDate(DateTime.now());
        member.setExpirationDate(expirationDate);

        return toDto(memberRecordService.save(member));
    }

    @Override
    public MemberRecordDto renew(String regToken, DateTime expirationDate) {
        MemberRecord member = memberRecordService.findByRegTokenToken(regToken);
        Preconditions.checkNotNull(member, "No member has registered with the given registration token");
        Preconditions.checkArgument(member.isApproved(), "Member has not yet been approved");
        Preconditions.checkArgument(expirationDate.isAfter(DateTime.now()), "Expiration date must be in the future");

        member.setExpirationDate(expirationDate);

        return toDto(memberRecordService.save(member));
    }

}
