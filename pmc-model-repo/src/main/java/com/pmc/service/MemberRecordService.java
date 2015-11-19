package com.pmc.service;

import com.pmc.model.MemberRecord;
import com.pmc.service.base.TyraelJpaService;
import com.pmc.service.custom.MemberRecordServiceCustom;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public interface MemberRecordService extends MemberRecordServiceCustom, TyraelJpaService<MemberRecord> {

}
