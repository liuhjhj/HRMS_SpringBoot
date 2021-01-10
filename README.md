# HRMS_SpringBoot
基于SpringBoot+Thymeleaf+Mybatis开发Restful风格的人事管理系统，网页UI组件基于Bootstrap

使用的技术栈：SpringBoot，Thymeleaf，Mybatis，jquery，Bootstrap

涵盖以下知识点：

1. Spring Boot相关，包括Maven基本配置，Yml配置文件编写，定制错误页面，国际化以及网页拦截器等知识点

```java
//网页拦截器
@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        Object username = request.getSession().getAttribute("username");
        if (username == null){
            request.setAttribute("error","please_login");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
```

```java
//添加网页拦截器
@Override
public void addInterceptors(InterceptorRegistry registry) {
        //拦截器要对静态资源放行,否则css样式无法加载
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/","/index","/index.html","/asserts/**","/webjars/**")
        .excludePathPatterns("/login");
        MvcLocaleChangeInterceptor mvcLocaleChangeInterceptor = new MvcLocaleChangeInterceptor();
        registry.addInterceptor(mvcLocaleChangeInterceptor.localeChangeInterceptor());
        }
```
    
2. 使用Bootstrap编写前端界面，URI是Restful风格 
>get 获取数据    /user  <br>
>post 添加数据   /user  <br>
>put 更新数据    /user/id   <br>
>delete 删除数据 /user/id
 
3. Thymeleaf相关语法，包括选择器（链接，变量，消息，*号），网页部分组件重用（th:replace）,以及其他语法（其他标签th属性，内置对象的使用和if判断等等）
> '${}' 变量表达式<br>
> '#{}' 消息表达式<br>
> '*{}' 变量表达式<br>
> '@{}' 链接表达式<br>

4. Mybatis进行增删查改，包括关联查询，Mapper文件的使用，设置查询别名等等
   
5. jquery的使用，包括发送不同的表单请求（Put，Delete，Get，Post），不同选择器的使用（id，class），为网页DOM节点绑定事件（点击，提交等等），修改DOM节点属性和动态添加其他DOM节点等其他语法