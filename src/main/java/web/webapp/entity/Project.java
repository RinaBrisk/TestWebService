package web.webapp.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Project {

    private String url;

    public Project(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
