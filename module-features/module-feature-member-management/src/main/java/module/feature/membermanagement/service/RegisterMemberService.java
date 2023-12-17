package module.feature.membermanagement.service;

import lombok.RequiredArgsConstructor;
import module.domain.member.Member;
import module.domain.member.persistence.MemberPersistenceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMemberService {

    private final MemberPersistenceService memberPersistenceService;

    public RegisterMember registerMember(String name, Integer age) {
        Member member = new Member(null, name, age);

        Member savedMember = memberPersistenceService.saveMember(member);

        return RegisterMember.of(savedMember);
    }
}
