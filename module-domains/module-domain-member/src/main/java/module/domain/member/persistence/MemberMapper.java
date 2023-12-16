package module.domain.member.persistence;

import module.domain.member.Member;
import module.domain.member.Member.MemberId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberMapper {

    public Member mapToDomainEntity(MemberJpaEntity memberJpaEntity) {
        Long id = memberJpaEntity.getId();
        String name = memberJpaEntity.getName();
        Integer age = memberJpaEntity.getAge();

        MemberId memberId = new MemberId(id);

        return new Member(memberId, name, age);
    }

    public MemberJpaEntity mapToJpaEntity(Member member) {
        Optional<MemberId> optionalMemberId = Optional.ofNullable(member.getMemberId());

        Long id = optionalMemberId.map(MemberId::getValue).orElse(null);
        String name = member.getName();
        Integer age = member.getAge();

        return new MemberJpaEntity(id, name, age);
    }
}
