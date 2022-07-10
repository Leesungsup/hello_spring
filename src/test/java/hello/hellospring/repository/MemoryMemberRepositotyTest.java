package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositotyTest {
    MemoryMemberReopository repository = new MemoryMemberReopository();
    @AfterEach
    public void aftereach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findByid(member.getId()).get();
        Assertions.assertEquals(member,result);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByname("spring1").get();
        Assertions.assertEquals(member1,result);
    }
}
