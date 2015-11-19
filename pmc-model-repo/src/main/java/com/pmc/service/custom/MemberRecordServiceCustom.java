package com.pmc.service.custom;

import com.pmc.dto.MemberRecordDto;
import com.pmc.model.MemberRecord;
import com.pmc.service.base.TyraelJpaServiceCustom;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public interface MemberRecordServiceCustom extends TyraelJpaServiceCustom<MemberRecord, MemberRecordDto> {

    MemberRecordDto register(String registrationToken, MemberRecordDto registrant);

}
