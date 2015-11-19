package com.pmc.service.base;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.pmc.dto.base.PageInfo;
import com.pmc.model.base.BaseEntity;

/**
 * @author mbmartinez
 * @param <E> Entity
 * @param <D> DTO
 */
@Transactional
public interface TyraelJpaServiceCustom<E extends BaseEntity, D> {

    D findOneInfo(Long id);
    D saveInfo(D dto);
    E saveInfoAndGetEntity(D dto);
    List<D> saveInfo(Iterable<D> dtos);
    List<E> saveInfoAndGetEntity(Iterable<D> dtos);

    PageInfo<D> pageInfo(Pageable page);

}
