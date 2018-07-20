package spittrtest.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Component
public class Spitter {
    private Long id;
    @NotNull
    @Size(min = 2,max = 30)
    private String lastname;
    @NotNull
    @Size(min = 2,max = 30)
    private String firstname;

    @NotNull
    @Size(min = 5,max = 16)
    private String username;
    @NotNull
    @Size(min = 5,max = 25)
    private String password;
}
