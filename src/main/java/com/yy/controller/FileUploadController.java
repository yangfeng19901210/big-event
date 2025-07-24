package com.yy.controller;

import com.yy.common.response.Result;
import com.yy.utils.AliOssUtil;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/*********************************************************
 ** 文件上传controller
 ** <br><br>
 ** @ClassName: FileUploadController
 ** @author: yangfeng
 ** @date: 2025/7/11 11:20
 ** @version: 1.0.0
 *********************************************************/
@RestController
public class FileUploadController {
    @Resource
    private AliOssUtil aliOssUtil;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //保证文件的名字是唯一的,从而防止文件覆盖
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\files\\"+filename));
        String url = aliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
