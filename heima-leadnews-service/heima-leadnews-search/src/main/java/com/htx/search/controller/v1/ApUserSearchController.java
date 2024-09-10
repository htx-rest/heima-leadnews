package com.htx.search.controller.v1;

import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.search.dtos.HistorySearchDto;
import com.htx.search.service.ApUserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/history")
public class ApUserSearchController {

    @Autowired
    private ApUserSearchService apUserSearchService;

    @PostMapping("/load")
    public ResponseResult findUserSearch(){
        return apUserSearchService.findUserSearch();
    }

    @PostMapping("/del")
    public ResponseResult delUserSearch(@RequestBody HistorySearchDto dto){
        return apUserSearchService.delUserSearch(dto);
    }
}
