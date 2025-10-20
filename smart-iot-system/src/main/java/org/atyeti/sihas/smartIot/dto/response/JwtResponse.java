package org.atyeti.sihas.smartIot.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private String role;
}
