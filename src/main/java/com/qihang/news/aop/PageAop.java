package com.qihang.news.aop;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qihang.news.dto.PageFilter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.ObjectUtils;



/**
 * @program: rems
 * @description: 分页逻辑织入
 **/
//声明当前类是配置类
@Configuration
//标注当前类是Aop切面类
@Aspect
@Slf4j
//开启Aop增强
@EnableAspectJAutoProxy
public class PageAop<T> {


    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.qihang.news.annotation.Page)")
    public void annotation() {
    }

    /**
     * 环绕增强
     */
    @Around("annotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
         // 当前页码
      String pageNum="1";
          //每页记录数
       String pageSize="10";
        PageFilter<T> pageFilter=null;
        //获取被增强方法的参数
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if(arg instanceof PageFilter) {
               pageFilter= (PageFilter<T>) arg;
                pageNum=ObjectUtils.isEmpty(pageFilter.getPageNum())? pageNum:pageFilter.getPageNum();
                pageSize=ObjectUtils.isEmpty(pageFilter.getPageSize())? pageSize:pageFilter.getPageSize();
            }
        }
        Object result = null;
        try {
            //调用分页插件传入开始页码和页面容量
            Page<Object> page = PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            //执行被增强的方法，不写，则被增强方法不执行
            result = proceedingJoinPoint.proceed(args);
            //获取并封装分页后的参数
            assert pageFilter != null;
            pageFilter.setPageNum(String.valueOf(page.getPageNum()));
            pageFilter.setPages(page.getPages());
            pageFilter.setPageSize(String.valueOf(page.getPageSize()));
            pageFilter.setTotal(page.getTotal());


        } catch (Exception e) {
            log.info("查询数据库异常",e);
        }
        return result;
    }
}