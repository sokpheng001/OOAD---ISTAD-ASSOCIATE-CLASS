package ooad.creationalpattern.morningclass.builderpattern;

import java.time.LocalDate;
import java.util.Arrays;

// Product
class Movie{
    private Integer id;
    private String title;
    private String des;
    private LocalDate releasedDate;
    private String [] author;
    private Movie(Builder builder){
        id = builder.id;
        title = builder.title;
        des = builder.des;
        releasedDate = builder.releasedDate;
        author = builder.author;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", releasedDate=" + releasedDate +
                ", author=" + Arrays.toString(author) +
                '}';
    }

    // Builder
    public static class Builder{
        private Integer id;
        private String title;
        private String des;
        private LocalDate releasedDate;
        private String [] author;
        public Builder(){}
        public Builder id(Integer id){
            this.id = id;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder des(String des){
            this.des = des;
            return this;
        }
        public Builder releasedDate(LocalDate releasedDate){
            this.releasedDate = releasedDate;
            return this;
        }
        public Builder authors(String [] authors){
            this.author = authors;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }

    }
}

public class BuilderPatternFluentStyle {
    public static void main(String[] args) {
        Movie movie = new Movie.Builder()
                .id(1)
                .title("Apple Builder")
                .authors(new String[]{"jame","jelly"})
                .releasedDate(LocalDate.of(2027,7,7))
                .build();
        System.out.println(movie);
    }
}
