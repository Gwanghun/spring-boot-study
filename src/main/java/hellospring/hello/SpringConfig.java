package hellospring.hello;

import hellospring.hello.repository.MemberRepository;
import hellospring.hello.repository.MemoryMemberRepository;
import hellospring.hello.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
