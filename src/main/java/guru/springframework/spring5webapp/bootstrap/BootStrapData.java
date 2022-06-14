package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Entities.Author;
import guru.springframework.spring5webapp.Entities.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorrepository;
    private final BookRepository bookrepository;

    public BootStrapData(AuthorRepository authorrepository, BookRepository bookrepository) {
        this.authorrepository = authorrepository;
        this.bookrepository = bookrepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","evans");
        Book life = new Book("beautiful life","767832");
        eric.getBooks().add(life);
        life.getAuthors().add(eric);


        authorrepository.save(eric);
        bookrepository.save(life);

        Author amish = new Author("Amish","tripathi");
        Book melluha = new Book("Melluha","786r732");
        amish.getBooks().add(melluha);
        melluha.getAuthors().add(amish);

        authorrepository.save(amish);
        bookrepository.save(melluha);

        System.out.println("Started In BootStrap:");
        System.out.println("number of books:"+bookrepository.count());




    }
}
