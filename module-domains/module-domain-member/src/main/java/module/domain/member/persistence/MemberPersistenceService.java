package module.domain.member.persistence;

import lombok.RequiredArgsConstructor;
import module.domain.member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberPersistenceService {

    private final SpringDataMemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public Member saveMember(Member member) {
        MemberJpaEntity memberJpaEntity = memberMapper.mapToJpaEntity(member);
        MemberJpaEntity saved = memberRepository.save(memberJpaEntity);
        return memberMapper.mapToDomainEntity(saved);
    }

    @Transactional(readOnly = true)
    public Member selectMemberByName(String name) {
        MemberJpaEntity memberJpaEntity = memberRepository.findByName(name).orElseThrow(() -> new RuntimeException("Member not found"));
        return memberMapper.mapToDomainEntity(memberJpaEntity);
    }
}
