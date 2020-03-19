package web.webapp.model;

import lombok.Data;

@Data
public class Project {
    private String url;
    private String owner;
    private int numberOfStars;

}
