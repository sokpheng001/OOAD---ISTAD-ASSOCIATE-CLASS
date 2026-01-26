package collectionframework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Data
class Person{
    private Integer id;
    private String name;
    private String profile;
    private String bio;
}
class Author extends Person{}
class Character extends Person{}
@Data
@Builder
class Movie implements Comparable<Movie>{
    private Integer id;
    private String title;
    private String thumbnail;
    private LocalDate releasedDate;
    private Set<String> images;
    private Set<String> sponsors;
    private Set<Author> authors;
    private Set<Character> characters;

    @Override
    public int compareTo(Movie o) {
        return o.id-id;
    }
}
public class SetDemo {
    public static void main(String[] args) {
        TreeSet<Movie> movies = new TreeSet<>();
        Character character1 = new Character();
        character1.setId(1);
        character1.setName("Oady");
        Character character2 = new Character();
        character2.setId(2);
        character2.setName("seyha");
        Author author = new Author();
        author.setId(3);
        author.setName("Dana");
        Movie movie = Movie.builder()
                .id(1)
                .title("Return to the class late")
                .authors(Set.of(author))
                .characters(Set.of(character1,character2))
                .thumbnail("https://m.media-amazon.com/images/M/MV5BNTM3YmVkZmYtY2MxOS00MjliLTk1MDEtYzE0OTU4MWI4ZmIxXkEyXkFqcGc@._V1_.jpg")
                .releasedDate(LocalDate.of(2027,1,1))
                .sponsors(Set.of("ASUS","YOES"))
                .build();
        movies.add(movie);
        System.out.println(movies);
    }
}
