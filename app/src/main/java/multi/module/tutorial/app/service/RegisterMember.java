package multi.module.tutorial.app.service;


import module.domain.member.Member;

public record RegisterMember(Long memberId, String name, Integer age) {

    public static RegisterMember of(Member member) {
        return new RegisterMember(member.getMemberId().getValue(), member.getName(), member.getAge());
    }
}
