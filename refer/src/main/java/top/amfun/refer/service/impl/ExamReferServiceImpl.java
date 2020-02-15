package top.amfun.refer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import top.amfun.refer.entity.ExamRefer;
import top.amfun.refer.entity.query.ExamReferQuery;
import top.amfun.refer.mapper.ExamReferMapper;
import top.amfun.refer.service.ExamReferService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-02-14
 */
@Service
public class ExamReferServiceImpl extends ServiceImpl<ExamReferMapper, ExamRefer> implements ExamReferService {

    //条件查询带分页
    @Override
    public void pageListCondition(Page<ExamRefer> referPage, ExamReferQuery examReferQuery) {
        if(examReferQuery == null){
            baseMapper.selectPage(referPage,null);
        }
        String name = examReferQuery.getName();
        String begin = examReferQuery.getBegin();
        String end = examReferQuery.getEnd();

        QueryWrapper<ExamRefer> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(begin)){
            queryWrapper.like("begin",begin);
        }
        if(!StringUtils.isEmpty(end)){
            queryWrapper.like("end",end);
        }
        baseMapper.selectPage(referPage,queryWrapper);
    }
}
