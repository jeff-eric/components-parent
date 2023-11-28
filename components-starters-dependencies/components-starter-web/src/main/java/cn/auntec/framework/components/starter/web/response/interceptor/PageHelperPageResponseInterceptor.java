package cn.auntec.framework.components.starter.web.response.interceptor;

import cn.auntec.framework.components.core.common.response.PageListResult;
import cn.auntec.framework.components.core.common.response.core.IResult;
import cn.auntec.framework.components.starter.web.response.core.ResponseHandlerInterceptor;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author 蒋时华
 * @date 2020-05-08 13:50:54
 */
@Configuration
@Slf4j
public class PageHelperPageResponseInterceptor implements ResponseHandlerInterceptor {

    private int isPageInfoExist = -1;

    @Override
    public IResult execute(Object returnValue, boolean transResultResponse) {
        if (this.isPageInfoExist == -1) {
            try {
                Class.forName("com.github.pagehelper.PageInfo");
                this.isPageInfoExist = 1;
            } catch (ClassNotFoundException e) {
                this.isPageInfoExist = 0;
            }
        }
        if (isPageInfoExist == 1 && returnValue instanceof PageInfo) {
            PageInfo pageInfo = (PageInfo) returnValue;
            // 使用 PageHelper 分页的
            return PageListResult.Builder.success(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), pageInfo.getList());
        }
        return null;
    }
}
