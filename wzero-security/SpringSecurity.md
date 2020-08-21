
#Spring Sesurity

## 一、原理了解

##### 1、执行链过滤结构
    UsernamePassword AuthenticationFilter
    Authentication Manager
    Dao AuthenticationProvider
    UserDetailService
    UserDetail
##### 2、


## 二、配置使用

##### 1、基础条件
    properties包     - 建用于接收 yml 文件的属性值的对象；
    config包         - 配置自动接收属性值；
    authentication包 - 建登录成功或失败、退出成功等处理器；
    pojo包           - 直接使用 UserDetails或扩展用户对象属性；
    service包        - 实现 UserDetailsService接口，实现登录验证；
    ecception包      - 用于自定义的异常抛出；
    config包         - 配置 SecurityConfig文件，简单的实现权限验证登录；
##### 2、扩展
    authentication包 - 添加用于短信验证的验证逻辑，仿照本身的执行链结构；
    session包        - 用于配置 Session会话过期和失效的文件；
    validate包       - 用于建通用的验证码过滤器、处理器，以及处理者；
                       后由验证方式图片和短信根据通用的分别建过滤器、处理器；
    authorize包      - 配置授权管理器和授权提供者；具体作用待看
    config包         - 将用到的所有 Bean全部统一配置，再配置SecurityConfig文件，
                       完善权限验证；
##### 3、注意

##### 问题（待解决），多为依赖注入
    RequestCache		-successHandler Controller
    RedirectStrategy	-AbstractSessionStrategy Controller
    AntPathMatcher		-ValidateCodeFilter
    
    authorizeConfigProviders -MyAuthorizeConfigManager
    validateCodeGenerators	-AbstractValidateCodeProcessor
    validateCodeProcessors	-ValidateCodeProcessorHolder