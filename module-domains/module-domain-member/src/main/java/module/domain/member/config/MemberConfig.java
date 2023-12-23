package module.domain.member.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("module.domain.member.persistence")
@EnableJpaRepositories("module.domain.member.persistence")
@ComponentScan("module.domain.member")
@Configuration
public class MemberConfig {
}
