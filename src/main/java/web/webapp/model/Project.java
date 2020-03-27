package web.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String url;
    @Column
    private String owner;
    @Column
    private int numberOfStars;

    public Project(String url, String owner, int numberOfStars){
        this.url = url;
        this.owner = owner;
        this.numberOfStars = numberOfStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return numberOfStars == project.numberOfStars &&
                url.equals(project.url) &&
                owner.equals(project.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, owner, numberOfStars);
    }

}
