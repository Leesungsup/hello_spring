package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberReopository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /*@Bean
    public MemberService memberService(){
        return new MemberService(memoryMemberReopository());
    }
    @Bean
    public MemoryMemberReopository memoryMemberReopository(){
        return new MemoryMemberReopository();
    }*/
}