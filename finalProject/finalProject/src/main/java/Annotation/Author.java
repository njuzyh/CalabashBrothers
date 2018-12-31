package Annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Author{
    //以下无参方法实际上定义的是注解的属性
    //其返回值可以是所有基本类型、String、Class、enum、Annotation或以上类型的数组
    String name() default "Zhou Yuhang";
    //default关键字可以定义该属性的默认值，如果没有指定默认值在使用注解时必须显示指定属性值
    String website() default "cn.edu.nju";
    int revision() default 1;
}