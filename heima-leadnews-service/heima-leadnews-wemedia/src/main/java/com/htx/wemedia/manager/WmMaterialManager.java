package com.htx.wemedia.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htx.file.service.FileStorageService;
import com.htx.model.common.dtos.PageResponseResult;
import com.htx.model.common.dtos.ResponseResult;
import com.htx.model.common.enums.AppHttpCodeEnum;
import com.htx.model.wemedia.dtos.WmMaterialDto;
import com.htx.model.wemedia.pojos.WmMaterial;
import com.htx.utils.thread.WmThreadLocalUtil;
import com.htx.wemedia.service.IWmMaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/9/8 21:13
 */
@Slf4j
@Service
public class WmMaterialManager {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private IWmMaterialService wmMaterialService;

    public ResponseResult uploadPicture(MultipartFile file) {
        //1.检查参数
        if(file == null || file.getSize() == 0){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        //2.上传图片到minIO中
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = file.getOriginalFilename();
        String postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileId = null;
        try {
            fileId = fileStorageService.uploadImgFile("", fileName + postfix, file.getInputStream());
            log.info("上传图片到MinIO中，fileId:{}",fileId);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("WmMaterialServiceImpl-上传文件失败");
        }

        //3.保存到数据库中
        WmMaterial wmMaterial = new WmMaterial();
        wmMaterial.setUserId(WmThreadLocalUtil.getUser().getId());
        wmMaterial.setUrl(fileId);
        wmMaterial.setIsCollection((short)0);
        wmMaterial.setType((short)0);
        wmMaterial.setCreatedTime(new Date());

        //4.返回结果
        return ResponseResult.okResult(wmMaterialService.insert(wmMaterial));
    }

    public ResponseResult findList(WmMaterialDto dto) {
        //1.检查参数
        dto.checkParam();

        //2.分页查询
        IPage page = new Page(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<WmMaterial> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //是否收藏
        if(dto.getIsCollection() != null && dto.getIsCollection() == 1){
            lambdaQueryWrapper.eq(WmMaterial::getIsCollection,dto.getIsCollection());
        }

        //按照用户查询
        lambdaQueryWrapper.eq(WmMaterial::getUserId,WmThreadLocalUtil.getUser().getId());

        //按照时间倒序
        lambdaQueryWrapper.orderByDesc(WmMaterial::getCreatedTime);


        page = wmMaterialService.page(page,lambdaQueryWrapper);

        //3.结果返回
        ResponseResult responseResult = new PageResponseResult(dto.getPage(),dto.getSize(),(int)page.getTotal());
        responseResult.setData(page.getRecords());
        return responseResult;
    }
}
