package web.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @NotNull(message = "Url cannot be null")
    private String url;
    @NotNull(message = "Owner cannot be null")
    private String owner;
    private int numberOfStars;

}
