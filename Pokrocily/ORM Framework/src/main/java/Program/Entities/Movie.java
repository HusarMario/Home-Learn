package Program.Entities;

import Anotations.Bar;
import Anotations.ID;
import Anotations.Table;

@Table("Movie")
public class Movie {
    @ID
    @Bar("ID")
    private Long id;

    @Bar("Title")
    private String title;

    @Bar("Director")
    private String director;

    @Bar("Starring")
    private String starring;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }
}
