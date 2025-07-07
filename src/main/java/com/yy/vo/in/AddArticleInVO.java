package com.yy.vo.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*********************************************************
 ** 新增文章请求参数
 ** <br><br>
 ** @ClassName: AddArticleInVO
 ** @author: yangfeng
 ** @date: 2025/7/7 9:43
 ** @version: 1.0.0
 *********************************************************/
@Data
public class AddArticleInVO {
    /**
     * 文章标题
     */
    @NotBlank(message = "文章标题不可为空")
    private String title;

    /**
     * 文章内容
     */
    @NotBlank(message = "文章内容不可为空")
    private String content;

    /**
     * 文章封面
     */
    @NotBlank(message = "文章封面图不可为空")
    private String coverImg;

    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    @NotBlank(message = "文章发布状态不可为空")
    private String state;

    /**
     * 文章分类ID
     */
    @NotNull(message = "文章分类id不可为空")
    private Integer categoryId;
}
