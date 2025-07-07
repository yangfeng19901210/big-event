package com.yy.vo.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*********************************************************
 ** 更新文章信息
 ** <br><br>
 ** @ClassName: UpdateArticleInVO
 ** @author: yangfeng
 ** @date: 2025/7/7 13:50
 ** @version: 1.0.0
 *********************************************************/
@Data
public class UpdateArticleInVO extends AddArticleInVO{
    /**
     * 文章id
     */
    @NotNull(message = "文章id不能为空")
    private Integer id;
}
