package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 기존 AppConfig
@Configuration
public class AppConfig {
    // 어디선가 AppConfig를 통해 MemberService를 불러다 사용할 것

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
        // 요청이 올 때마다 MemberServiceImpl 객체를 생성해서 반환
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
