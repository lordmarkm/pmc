package com.pmc.service.custom;

import java.util.List;

import com.pmc.dto.RegistrationTokenDto;
import com.pmc.model.RegistrationToken;
import com.pmc.service.base.TyraelJpaServiceCustom;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public interface RegistrationTokenServiceCustom extends TyraelJpaServiceCustom<RegistrationToken, RegistrationTokenDto> {

    List<RegistrationTokenDto> generate(int count);

}
