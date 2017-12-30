package demo;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.TreeMap;

/**
 * @author HODO
 */
public class OpenApiSupportInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = ((HandlerMethod) handler);
            OpenApi openApi = AnnotatedElementUtils.getMergedAnnotation(handlerMethod.getMethod(), OpenApi.class);
            if (openApi != null && !checkSign(request, openApi.params())) {
                response.getWriter().write("签名失败");
                return false;
            }
        }
        return true;
    }


    private boolean checkSign(HttpServletRequest request, String[] params) {

        //get signKey check sign
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
