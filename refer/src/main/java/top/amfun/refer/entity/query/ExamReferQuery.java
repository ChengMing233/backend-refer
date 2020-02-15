package top.amfun.refer.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Create By chengming on 2020/2/15 0:21
 */
@Data
@ApiModel(value = "条件查询")
public class ExamReferQuery {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "查询开始时间")
    private String begin;

    @ApiModelProperty(value = "查询结束时间")
    private String end;
}
