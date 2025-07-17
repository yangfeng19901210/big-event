package com.yy.validation;

import com.yy.anno.ArticleState;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: ArticleStateValidation
 ** @author: yangfeng
 ** @date: 2025/7/17 10:42
 ** @version: 1.0.0
 *********************************************************/
public class ArticleStateValidation implements ConstraintValidator<ArticleState,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(null ==value){
            return false;
        }
        if(value.equals("已发布") || value.equals("草稿")){
            return true;

        }
        return false;
    }
}
