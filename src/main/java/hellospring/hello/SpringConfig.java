package hellospring.hello;

import hellospring.hello.repository.MemberRepository;
import hellospring.hello.repository.jpaMemberRepository;
import hellospring.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*private final DataSource dataSource;
    private final EntityManager em;*/

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


    /*@Autowired
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }*/

    /*@Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }*/

    /*@Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new jdbcTemplateMemberRepository(dataSource);
        return new jpaMemberRepository(em);
    }*/
}
