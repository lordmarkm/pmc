package com.pmc.service;

import com.pmc.model.RegistrationToken;
import com.pmc.service.base.TyraelJpaService;
import com.pmc.service.custom.RegistrationTokenServiceCustom;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public interface RegistrationTokenService extends RegistrationTokenServiceCustom,
    TyraelJpaService<RegistrationToken> {

    RegistrationToken findByToken(String registrationToken);

}
