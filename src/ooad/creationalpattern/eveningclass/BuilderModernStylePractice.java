
import java.util.List;

class Author{
    private Integer id;
    private String uuid;
    private String name;
    private String profile;
    private Author(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.uuid = builder.uuid;
        this.profile = builder.profile;
    }
    public class Builder{
        private Integer id;
        private String uuid;
        private String name;
        private String profile;
        //
        public Builder(){}
        public Builder id(Integer id){
            this.id = id;
            return this;
        }
        public Builder uuid(String uuid){
            this.uuid = uuid;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder profile(String profile){
            this.profile = profile;
            return this;
        }
        public Author build(){
            return new Author(this);
        }
    }
}
class Movie{
    private Integer id;
    private String uuid;
    private String title;
    private String[] images;
    private List<Author>authors;
    public Movie(Builder builder){
        this.id = builder.id;
        /**
         * ..... more attribute here
         */
        this.authors =builder.authors;
    }
    public  class Builder{
        private Integer id;
        private String uuid;
        private String title;
        private String[] images;
        private List<Author>authors;
        //
        public Builder(){}
        public Builder id(Integer id){
            this.id = id;
            return this;
        }
        /*
        ... more method
         */
        public Builder authors(List<Author> authors){
            this.authors = authors;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }
    }
}

void main(){

}