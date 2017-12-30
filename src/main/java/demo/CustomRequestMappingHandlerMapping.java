package demo;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;


/**
 * @author HODO
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if (mappingInfo != null) {
            return mappingInfo;
        }
        OpenApi openApi = AnnotatedElementUtils.findMergedAnnotation(method, OpenApi.class);
        return openApi == null ? null : RequestMappingInfo.paths(openApi.value()).methods(openApi.method()).build();
    }
}
