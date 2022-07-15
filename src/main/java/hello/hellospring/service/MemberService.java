package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberReopository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemoryMemberReopository memberRepository){
        this.memberRepository = memberRepository;
    };
    public Long join(Member member){
        //Optional<Member> result = memberRepository.findByname(member.getName());
        //result.ifPresent(m->{
        //    throw  new IllegalStateException("이미 존재하는 회원입니다.")
        //});
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(m->{
                    throw  new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public List<Member> findMembers(){
        return memberRepository.findall();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findByid(memberId);
    }
}
