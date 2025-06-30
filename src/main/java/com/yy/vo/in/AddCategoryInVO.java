package com.yy.vo.in;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/*********************************************************
 ** 新增文章分类请求参数
 ** <br><br>
 ** @ClassName: AddCategoryInVO
 ** @author: yangfeng
 ** @date: 2025/6/30 11:18
 ** @version: 1.0.0
 *********************************************************/
@Data
public class AddCategoryInVO {
    @NotBlank(message = "文章分类名称不可为空")
    private String categoryName; // 分类名称
    @NotBlank(message = "文章分类别名不可为空")
    private String categoryAlias; // 分类别名
}
