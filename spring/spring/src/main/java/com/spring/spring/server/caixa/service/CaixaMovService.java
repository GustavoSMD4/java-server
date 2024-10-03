package com.spring.spring.server.caixa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.spring.abstracts.ServiceAbstract;
import com.spring.spring.dto.caixa.CaixaMovDTO;
import com.spring.spring.server.caixa.entity.CaixaEntity;
import com.spring.spring.server.caixa.entity.CaixaMovEntity;
import com.spring.spring.server.caixa.entity.CaixaTipoMovEntity;
import com.spring.spring.server.caixa.repository.CaixaMovRepository;

@Service
public class CaixaMovService extends ServiceAbstract<CaixaMovEntity, Long, CaixaMovRepository> {
    private CaixaService caixaService;
    private CaixaTipoMovService caixaTipoMovService;

    public CaixaMovService(CaixaService caixaService, CaixaTipoMovService caixaTipoMovService) {
        this.caixaService = caixaService;
        this.caixaTipoMovService = caixaTipoMovService;
    }

    public List<CaixaMovEntity> consultarPorIdCaixa(long idCaixa) throws Exception {
        return repository.findAllByCaixa(caixaService.consultarPorId(idCaixa));
    }

    public List<CaixaMovEntity> create(CaixaMovDTO caixaMovDTO) throws Exception {
        CaixaMovEntity caixaMovEntity = new CaixaMovEntity();
        CaixaEntity caixaEntity = caixaService.consultarPorId(caixaMovDTO.getIdCaixa());
        CaixaTipoMovEntity caixaTipoMovEntity = caixaTipoMovService.consultarPorId(caixaMovDTO.getIdTipo());

        caixaMovEntity.setCaixa(caixaEntity);
        caixaMovEntity.setDescricao(caixaMovDTO.getDescricao());
        caixaMovEntity.setTipo(caixaTipoMovEntity);
        caixaMovEntity.setValor(caixaMovDTO.getValor());

        CaixaEntity caixa = this.updateSaldoCaixa(caixaMovEntity, "create");

        repository.save(caixaMovEntity);
        caixaService.salvar(caixa);
        return repository.findAllByCaixa(caixaMovEntity.getCaixa());
    }

    public List<CaixaMovEntity> update(CaixaMovDTO caixaMovDTO) throws Exception {
        CaixaMovEntity caixaMovEntity = new CaixaMovEntity();
        CaixaEntity caixaEntity = caixaService.consultarPorId(caixaMovDTO.getIdCaixa());
        CaixaTipoMovEntity caixaTipoMovEntity = caixaTipoMovService.consultarPorId(caixaMovDTO.getIdTipo());

        caixaMovEntity.setId(caixaMovDTO.getId());
        caixaMovEntity.setCaixa(caixaEntity);
        caixaMovEntity.setDescricao(caixaMovDTO.getDescricao());
        caixaMovEntity.setTipo(caixaTipoMovEntity);
        caixaMovEntity.setValor(caixaMovDTO.getValor());

        CaixaEntity caixa = this.updateSaldoCaixa(caixaMovEntity, "update");

        repository.save(caixaMovEntity);
        caixaService.salvar(caixa);
        return repository.findAllByCaixa(caixaMovEntity.getCaixa());
    }

    public CaixaEntity updateSaldoCaixa(CaixaMovEntity movimentacao, String status) throws Exception {

        CaixaEntity caixa = caixaService.consultarPorId(movimentacao.getCaixa().getId());
        CaixaTipoMovEntity tipoAtualizar = caixaTipoMovService.consultarPorId(movimentacao.getTipo().getId());

        float saldoAtual = caixa.getSaldo();
        float saldoAtualizado = 0;

        if (status == "create") {
            saldoAtualizado = saldoAtual += movimentacao.getValor();
            caixa.setSaldo(saldoAtualizado);
        } else {
            Optional<CaixaMovEntity> movimentacaoAntesAtualizar = repository.findById(movimentacao.getId());

            if (!movimentacaoAntesAtualizar.isPresent()) {
                throw new Exception("Movimentação do caixa não localizada!");
            }

            CaixaTipoMovEntity tipoAntesAtualizar = caixaTipoMovService
                    .consultarPorId(movimentacaoAntesAtualizar.get().getTipo().getId());

            if (tipoAntesAtualizar.isEntrada() != tipoAtualizar.isEntrada()) {
                throw new Exception("A movimentação não pode ser atualizada de entrada para saída!");
            }

            if (status == "update") {
                float diferenca = movimentacaoAntesAtualizar.get().getValor() - movimentacao.getValor();
                saldoAtualizado = saldoAtual + diferenca;
            }

            if (status == "delete") {
                float valorAtualizar = tipoAntesAtualizar.isEntrada() ? (movimentacao.getValor() * -1)
                        : movimentacao.getValor();
                saldoAtualizado = saldoAtual + valorAtualizar;
            }
        }

        if (saldoAtualizado < 0) {
            throw new Exception("Falha ao atualizado o saldo: o saldo do caixa não pode ficar negativo!");
        }

        caixa.setSaldo(saldoAtualizado);
        return caixa;

    }

}
