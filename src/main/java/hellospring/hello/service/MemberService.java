package hellospring.hello.service;

import hellospring.hello.domain.Member;
import hellospring.hello.repository.MemberRepository;
import hellospring.hello.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X

        // 위와 같은 동작을 하는 코드
        validateDuplicateMember(member);   // 중복회원 검사
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        });*/
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /**
     * 전체회원조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
