package com.yy.vo.in;

import com.yy.anno.ArticleState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

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
    @Size(min = 1, max = 10, message = "文章标题需在1-10字符之间")
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
    @URL(message = "文章封面图格式不正确")
    private String coverImg;

    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     * 需要自定义注解进行校验
     */
    @ArticleState
    private String state;

    /**
     * 文章分类ID
     */
    @NotNull(message = "文章分类id不可为空")
    private Integer categoryId;
}
