package jeronimo.teste.brasilprev.service;

import io.smallrye.jwt.build.Jwt;
import jeronimo.teste.brasilprev.beans.requestTO.RoleJwtRequestTO;
import jeronimo.teste.brasilprev.beans.responseTO.JwtResponseTO;
import org.eclipse.microprofile.jwt.Claims;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Singleton
public class JWTService {

    public JwtResponseTO generateJwt( String clientName, String clientEmail, RoleJwtRequestTO to){
        JwtResponseTO responseTO = new JwtResponseTO();
        if(!to.getRole().equalsIgnoreCase("user")&& !to.getRole().equalsIgnoreCase("admin") && !to.getRole().equalsIgnoreCase("dev")){
            to.setRole("user");
        }
        Set<String> roles = new HashSet<>(
                List.of(to.getRole())
        );
        long duration = System.currentTimeMillis() + 3600;
        String token = Jwt.issuer("brasilprev-jwt")
                .subject("brasilprev-jwt")
                .groups(roles)
                .claim(Claims.full_name.name(), clientName)
                .claim(Claims.email.name(), clientEmail)
                .expiresAt(duration)
                .sign();
        responseTO.setToken(token);
        responseTO.setStatus(true);
        return  responseTO;
    }
}
