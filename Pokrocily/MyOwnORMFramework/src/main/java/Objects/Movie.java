package main.java.Objects;

import main.java.Annotations.Column;
import main.java.Annotations.ID;
import main.java.Annotations.Table;

@Table("MOVIE")
public class Movie {

    @ID
    @Column("ID")
    private Long id;

    @Column("TITLE")
    private String title;

    @Column("YEAR")
    private Long year;

    @Column("PHASE")
    private String phase;

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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", phase='" + phase + '\'' +
                '}';
    }
}
