package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

// 새로운 AppConfig
@Configuration
// 컴포넌트 스캔은 이름 그대로 @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
// 이제 @Component를 붙여주자
@ComponentScan(
        // AppConfig를 스캔하지 않도록 하기 위해 @Configuration 애노테이션은 제외(일반적으로는 필요 없는 과정)
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다!
}