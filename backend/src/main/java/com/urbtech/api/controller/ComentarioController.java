package com.urbtech.api.controller;

import com.urbtech.api.dto.ComentarioDto;
import com.urbtech.api.dto.request.ComentarioRequest;
import com.urbtech.domain.service.ComentarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("comentario")
public class ComentarioController {

    private ComentarioService comentarioService;

    @PostMapping("comentar")
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioRequest comentar(@Valid @RequestBody ComentarioDto comentarioDto){
        return this.comentarioService.comentar(comentarioDto);
    }

}