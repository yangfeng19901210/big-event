package com.yy.vo.out;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yy.common.entity.BaseEntity;
import lombok.Data;

/*********************************************************
 ** 分章分类列表返回参数
 ** <br><br>
 ** @ClassName: CategoryListOutVO
 ** @author: yangfeng
 ** @date: 2025/7/1 15:44
 ** @version: 1.0.0
 *********************************************************/
@Data
public class CategoryListOutVO extends BaseEntity {
    /**
     * ID
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类别名
     */
    private String categoryAlias;
}
