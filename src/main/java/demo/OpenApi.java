package demo;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ResponseBody
public @interface OpenApi {

    String value() default "";
    //需要参与签名的请求参数
    String[] params() default {};

    RequestMethod method() default RequestMethod.GET;
}
