package cn.auntec.framework.components.starter.web.response.webmvc;

import cn.auntec.framework.components.starter.web.config.GlobalResponseConfig;
import cn.auntec.framework.components.starter.web.response.DisableTransResultResponse;
import cn.auntec.framework.components.starter.web.response.NoGlobalResponse;
import cn.auntec.framework.components.starter.web.response.core.ResponseHandleChainPattern;
import cn.auntec.framework.components.util.constant.FeignConst;
import cn.auntec.framework.components.util.value.data.ObjectUtil;
import cn.auntec.framework.components.util.value.url.UrlFilterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 全局统一返回值格式
 *
 * @author 蒋时华
 * @date 2018/11/22
 */
@Slf4j
public class ReturnResponseHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;
    private final GlobalResponseConfig globalResponseConfig;
    private final ResponseHandleChainPattern responseHandleChainPattern;

    public ReturnResponseHandler(HandlerMethodReturnValueHandler delegate, GlobalResponseConfig globalResponseConfig, ResponseHandleChainPattern responseHandleChainPattern) {
        this.delegate = delegate;
        this.globalResponseConfig = globalResponseConfig;
        this.responseHandleChainPattern = responseHandleChainPattern;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue,
                                  MethodParameter returnType,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        if (globalResponseConfig == null || globalResponseConfig.getEnable()) {
            boolean validPath = false;
            try {
                // 原request
                HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);
                // 当前路径包含在NotTransResultList的集合中，不进行全局替换。
                validPath = UrlFilterUtil.valid(ObjectUtil.isNull(globalResponseConfig) ? new ArrayList<>() : globalResponseConfig.getNotTransResultList()
                        , nativeRequest.getServletPath());
            } catch (Exception e) {
                log.error("返回值处理异常：", e);
            }
            // 使用 全局返回值
            NoGlobalResponse noGlobalResponseMethod = returnType.getMethod().getAnnotation(NoGlobalResponse.class);
            NoGlobalResponse noGlobalResponseClass = returnType.getMethod().getClass().getAnnotation(NoGlobalResponse.class);
            if (!validPath && noGlobalResponseMethod == null && noGlobalResponseClass == null) {
                // 判断是否支持feign
                String useFeign = webRequest.getHeader(FeignConst.USE_FEIGN_NAME);
                if (FeignConst.USE_FEIGN_VALUE.equals(useFeign)
                        && ObjectUtil.isNotNull(globalResponseConfig)
                        && !globalResponseConfig.getSupportFeign()) {
                    // 不支持feign调用返回值的封装
                } else {
                    DisableTransResultResponse disableTransResultResponseMethod = returnType.getMethod().getAnnotation(DisableTransResultResponse.class);
                    DisableTransResultResponse disableTransResultResponseClass = returnType.getMethod().getClass().getAnnotation(DisableTransResultResponse.class);
                    boolean transResultResponse = disableTransResultResponseMethod == null && disableTransResultResponseClass == null;
                    returnValue = responseHandleChainPattern.execute(returnValue, transResultResponse);
                }
            }
        }
        delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
