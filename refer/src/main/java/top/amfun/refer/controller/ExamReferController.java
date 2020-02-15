package top.amfun.refer.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.amfun.refer.common.R;
import top.amfun.refer.entity.ExamRefer;
import top.amfun.refer.entity.query.ExamReferQuery;
import top.amfun.refer.service.ExamReferService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-02-14
 */
@Api(value = "管理接口示例")
@RestController
@RequestMapping("/refer")
public class ExamReferController {

    @Autowired
    private ExamReferService examReferService;

    @ApiOperation(value = "返回全部查询数据")
    @GetMapping
    public R list(){
        List<ExamRefer> referList = examReferService.list(null);
        return R.ok().data("items",referList);
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
         boolean flag = examReferService.removeById(id);
         return R.ok();
    }

    @ApiOperation(value = "分页查询数据")
    @GetMapping("/pageList/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page",value = "当前页数",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页大小",required = true)
            @PathVariable Long limit){

        Page<ExamRefer> referPage = new Page<>(page,limit);

        examReferService.page(referPage,null);
        List<ExamRefer> records = referPage.getRecords();
        Long total = referPage.getTotal();

        return R.ok().data("total",total).data("row",records);
    }

    @ApiOperation(value = "条件查询分页")
    @PostMapping("/moreConditonPageList/{page}/{limit}")
    public R getMoreConditionPageList(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) ExamReferQuery examReferQuery){

        Page<ExamRefer> referPage = new Page<>(page,limit);

        examReferService.pageListCondition(referPage,examReferQuery);
        List<ExamRefer> records = referPage.getRecords();
        Long total = referPage.getTotal();

        return R.ok().data("total",total).data("row",records);
    }

    @ApiOperation(value = "添加")
    @PostMapping("/add")
    public R save(@RequestBody ExamRefer examRefer){
        boolean flag = examReferService.save(examRefer);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("/getById/{id}")
    public R getById(@PathVariable Long id){
        ExamRefer examRefer = examReferService.getById(id);
        if (examRefer!=null){
            return R.ok().data("item",examRefer);
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById/{id}")
    public R updateById(@PathVariable Long id,@RequestBody ExamRefer examRefer){
        boolean b = examReferService.updateById(examRefer);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

