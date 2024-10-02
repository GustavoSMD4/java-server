package com.spring.spring.caixa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.caixa.entity.CaixaEntity;
import com.spring.spring.caixa.entity.CaixaMovEntity;
import com.spring.spring.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.caixa.repository.CaixaMovRepository;
import com.spring.spring.dto.caixa.CaixaMovDTO;

@Service
public class CaixaMovService extends ServiceAbstract<CaixaMovEntity, Long> {
    private CaixaMovRepository repository;
    private CaixaService caixaService;
    private CaixaTipoMovService caixaTipoMovService;

    public CaixaMovService(CaixaMovRepository repository, CaixaService caixaService, CaixaTipoMovService caixaTipoMovService) {
        super(repository);
        this.repository = repository;
        this.caixaService = caixaService;
        this.caixaTipoMovService = caixaTipoMovService;
    }

    public List<CaixaMovEntity> create(CaixaMovDTO caixaMovDTO) throws Exception{
        CaixaMovEntity caixaMovEntity = new CaixaMovEntity();
        CaixaEntity caixaEntity = caixaService.consultarPorId(caixaMovDTO.getIdCaixa());
        CaixaTipoMovEntity caixaTipoMovEntity = caixaTipoMovService.consultarPorId(caixaMovDTO.getIdTipo());

        caixaMovEntity.setCaixa(caixaEntity);
        caixaMovEntity.setDescricao(caixaMovDTO.getDescricao());
        caixaMovEntity.setTipo(caixaTipoMovEntity);
        caixaMovEntity.setValor(caixaMovDTO.getValor());

        repository.save(caixaMovEntity);
        return repository.findAll();
    }

    public List<CaixaMovEntity> update(CaixaMovDTO caixaMovDTO) throws Exception{
        CaixaMovEntity caixaMovEntity = new CaixaMovEntity();
        CaixaEntity caixaEntity = caixaService.consultarPorId(caixaMovDTO.getIdCaixa());
        CaixaTipoMovEntity caixaTipoMovEntity = caixaTipoMovService.consultarPorId(caixaMovDTO.getIdTipo());

        caixaMovEntity.setId(caixaMovDTO.getId());
        caixaMovEntity.setCaixa(caixaEntity);
        caixaMovEntity.setDescricao(caixaMovDTO.getDescricao());
        caixaMovEntity.setTipo(caixaTipoMovEntity);
        caixaMovEntity.setValor(caixaMovDTO.getValor());

        repository.save(caixaMovEntity);
        return repository.findAll();
    }

}
