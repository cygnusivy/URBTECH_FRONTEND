package com.urbtech.api.mapper;

import com.urbtech.api.dto.ComentarioDto;
import com.urbtech.api.dto.request.ComentarioRequest;
import com.urbtech.domain.model.ComentarioModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComentarioMapper {

    private ModelMapper modelMapper;

    public ComentarioModel dtoToModel(ComentarioDto comentarioDto){
        return this.modelMapper.map(comentarioDto, ComentarioModel.class);
    }

    public ComentarioRequest modelToRequest(ComentarioModel comentarioModel){
        return this.modelMapper.map(comentarioModel, ComentarioRequest.class);
    }

}