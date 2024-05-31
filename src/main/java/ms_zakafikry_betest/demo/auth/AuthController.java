package ms_zakafikry_betest.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestParam String username, @RequestParam String password) {
        // request jwt token using hardocoded username/pass for simplicity :)
        if ("zakafikry".equals(username) && "betest".equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
