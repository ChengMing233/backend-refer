package top.amfun.refer.handler;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.amfun.refer.common.R;
import top.amfun.refer.common.ResultCodeEnum;

/**
 * Create By chengming on 2020/2/15 8:40
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //1.全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("出现了异常");
    }

    //2.特定异常类
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        e.printStackTrace();
        return R.codeEnum(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    //3.自定义异常类
    @ExceptionHandler(ReferException.class)
    @ResponseBody
    public R error(ReferException r){
        r.printStackTrace();
        return R.error().message(r.getMessage()).code(r.getCode());
    }
}
