package com.alexmegremis.vaadindemo;

import com.alexmegremis.vaadindemo.persistence.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ViewPermissionsService {

    private final PermissionsRepo repo;

    public ViewPermissionsService(final PermissionsRepo repo) {
        this.repo = repo;
    }

    public List<DispositionDTO> findAll(int offset, int limit, Map<String, Boolean> sortOrders) {
        int page = offset / limit;
        List<Sort.Order> orders = sortOrders.entrySet()
                                            .stream()
                                            .map(e -> new Sort.Order(e.getValue() ? Sort.Direction.ASC : Sort.Direction.DESC, e.getKey()))
                                            .collect(Collectors.toList());

        PageRequest                 pageRequest = PageRequest.of(page, limit, Sort.by(orders));
        List<ViewPermissionsEntity> items       = repo.findAll(pageRequest).getContent();

        List<DispositionDTO> DTOs = items.stream()
                               .map(p -> DispositionDTO.builder()
                                                       .idPerson(p.getIdPerson())
                                                       .idPrincipal(p.getIdPrincipal())
                                                       .idRepo(p.getIdRepo())
                                                       .nameFirst(p.getNameFirst())
                                                       .nameLast(p.getNameLast())
                                                       .permission(p.getPermission())
                                                       .permissionBits(p.getPermissionBits())
                                                       .repo(p.getRepo())
                                                       .build())
                               .collect(Collectors.toList());

        return DTOs.subList(offset % limit, items.size());
    }

    public Integer count() {
        return Math.toIntExact(repo.count());
    }
}
