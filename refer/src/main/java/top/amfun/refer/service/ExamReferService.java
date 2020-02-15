package top.amfun.refer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.amfun.refer.entity.ExamRefer;
import com.baomidou.mybatisplus.extension.service.IService;
import top.amfun.refer.entity.query.ExamReferQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-02-14
 */
public interface ExamReferService extends IService<ExamRefer> {

    void pageListCondition(Page<ExamRefer> referPage, ExamReferQuery examReferQuery);
}
