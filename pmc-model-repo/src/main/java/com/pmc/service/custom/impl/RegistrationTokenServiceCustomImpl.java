package com.pmc.service.custom.impl;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import com.google.common.collect.Lists;
import com.pmc.dto.RegistrationTokenDto;
import com.pmc.model.RegistrationToken;
import com.pmc.service.RegistrationTokenService;
import com.pmc.service.base.TyraelJpaServiceCustomImpl;
import com.pmc.service.custom.RegistrationTokenServiceCustom;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public class RegistrationTokenServiceCustomImpl
    extends TyraelJpaServiceCustomImpl<RegistrationToken, RegistrationTokenDto, RegistrationTokenService>
    implements RegistrationTokenServiceCustom {

    @Override
    public List<RegistrationTokenDto> generate(int count) {
        List<RegistrationToken> tokens = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            RegistrationToken token = new RegistrationToken();
            token.setToken(nextToken());
            tokens.add(token);
        }
        return toDto(repo.save(tokens));
    }

    private String nextToken() {
        return RandomStringUtils.random(5).toLowerCase();
    }
}
