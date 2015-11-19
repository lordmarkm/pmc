package com.pmc.service.custom.impl;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.pmc.dto.RegistrationTokenDto;
import com.pmc.model.RegistrationToken;
import com.pmc.service.RegistrationTokenService;
import com.pmc.service.base.TyraelJpaServiceCustomImpl;
import com.pmc.service.custom.RegistrationTokenServiceCustom;
import com.pmc.util.DateUtil;

/**
 * 
 * @author Mark Martinez, Nov 19, 2015
 *
 */
public class RegistrationTokenServiceCustomImpl
    extends TyraelJpaServiceCustomImpl<RegistrationToken, RegistrationTokenDto, RegistrationTokenService>
    implements RegistrationTokenServiceCustom {

    @Override
    public List<RegistrationTokenDto> generate(String countryCode, int count) {
        String tokenSeries = DateTime.now().toString(DateUtil.DATETIME_FORMAT);
        List<RegistrationToken> tokens = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            RegistrationToken token = new RegistrationToken();
            token.setToken(nextToken(countryCode));
            token.setTokenSeries(tokenSeries);
            tokens.add(token);
        }
        return toDto(repo.save(tokens));
    }

    private String nextToken(String countryCode) {
        return new StringBuilder(countryCode).append("-").append(RandomStringUtils.randomAlphabetic(5).toLowerCase()).toString();
    }
}
