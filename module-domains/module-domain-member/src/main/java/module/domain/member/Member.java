package module.domain.member;

import lombok.Value;

@Value
public class Member {

    MemberId memberId;

    String name;

    Integer age;

    public boolean isOrderThan(Member member) {
        return this.age > member.age;
    }

    @Value
    public static class MemberId {
        Long value;
    }
}
