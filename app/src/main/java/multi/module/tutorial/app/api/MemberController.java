package multi.module.tutorial.app.api;

import lombok.RequiredArgsConstructor;
import multi.module.tutorial.app.service.RegisterMember;
import multi.module.tutorial.app.service.RegisterMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final RegisterMemberService registerMemberService;

    @PostMapping(value = "/member")
    public ResponseEntity<RegisterMember> registerMember(@RequestBody MemberRegisterForm form) {
        RegisterMember registerMember = registerMemberService.registerMember(form.name(), form.age());
        return ResponseEntity.ok(registerMember);
    }
}
