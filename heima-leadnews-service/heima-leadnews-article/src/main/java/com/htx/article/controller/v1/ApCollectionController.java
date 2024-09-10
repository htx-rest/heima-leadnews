package com.htx.article.controller.v1;

import com.htx.article.service.ApCollectionService;
import com.htx.model.article.dtos.CollectionBehaviorDto;
import com.htx.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/collection_behavior")
public class ApCollectionController {

    @Autowired
    private ApCollectionService apCollectionService;


    @PostMapping
    public ResponseResult collection(@RequestBody CollectionBehaviorDto dto) {
        return apCollectionService.collection(dto);
    }
}