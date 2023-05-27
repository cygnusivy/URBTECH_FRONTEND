package com.urbtech.api.mapper;

import com.urbtech.api.dto.PostDto;
import com.urbtech.api.dto.request.PostRequest;
import com.urbtech.domain.model.PostModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostMapper {

    private ModelMapper modelMapper;

    public PostModel dtoToEntity (PostDto postDto){
        return modelMapper.map(postDto, PostModel.class);
    }

    public PostRequest entityToRequest (PostModel postModel){
        return this.modelMapper.map(postModel, PostRequest.class);
    }

}