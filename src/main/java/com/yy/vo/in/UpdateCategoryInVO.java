package com.yy.vo.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*********************************************************
 ** 更新文章分类请求参数
 ** <br><br>
 ** @ClassName: UpdateCategoryInVO
 ** @author: yangfeng
 ** @date: 2025/7/4 16:41
 ** @version: 1.0.0
 *********************************************************/
@Data
public class UpdateCategoryInVO extends AddCategoryInVO{
    @NotNull(message = "文章分类ID不可为空")
    private Integer id; // 分类ID
}
