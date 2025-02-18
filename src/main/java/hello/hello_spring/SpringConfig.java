package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @PersistenceContext
//    private final EntityManager em;
//    private final DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.em = em;
//        this.dataSource = dataSource;
//    }

//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(em);
//    }

    // 여기서는 컴포넌트 스캔 사용
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
