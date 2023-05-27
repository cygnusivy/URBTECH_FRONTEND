package com.urbtech.api.controller;

import com.urbtech.api.dto.ComunidadeDto;
import com.urbtech.api.dto.request.PostRequest;
import com.urbtech.domain.model.ComunidadeModel;
import com.urbtech.domain.service.ComunidadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("comunidade")
public class ComunidadeController {

    private ComunidadeService comunidadeService;

    @PostMapping("abrirComunidade")
    public ComunidadeModel criarNovaComunidade(@Valid @RequestBody ComunidadeDto comunidadeDto){
        return this.comunidadeService.salvar(comunidadeDto);
    }

    @GetMapping("selecionaPostagensDaComunidade/{id}")
    public List<PostRequest> selecionaPostagensDaComunidade(@Valid @PathVariable Long id){
        return this.comunidadeService.postRequestList(id);
    }

}