package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Entities.Author;
import guru.springframework.spring5webapp.Entities.Book;
import guru.springframework.spring5webapp.Entities.Publisher;
import guru.springframework.spring5webapp.Entities.PublisherRepository;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorrepository;
    private final BookRepository bookrepository;

    private final PublisherRepository publisherrepository;

    public BootStrapData(AuthorRepository authorrepository, BookRepository bookrepository, PublisherRepository publisherrepository) {
        this.authorrepository = authorrepository;
        this.bookrepository = bookrepository;
        this.publisherrepository = publisherrepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","evans");
        Book life = new Book("beautiful life","767832");
        eric.getBooks().add(life);
        life.getAuthors().add(eric);

        Publisher penguin = new Publisher("Penguin","Guregaon","Mumbai","Maharashtra","89u897");


        authorrepository.save(eric);
        bookrepository.save(life);
        publisherrepository.save(penguin);

        Author amish = new Author("Amish","tripathi");
        Book melluha = new Book("Melluha","786r732");
        Publisher holands = new Publisher("holands","ontario","London","United Kingdom","98889");

        holands.getBooks().add(life);
        penguin.getBooks().add(melluha);
        amish.getBooks().add(melluha);
        melluha.getAuthors().add(amish);

        authorrepository.save(amish);
        bookrepository.save(melluha);
        publisherrepository.save(holands);

        System.out.println("Started In BootStrap:");
        System.out.println("number of books:"+bookrepository.count());

        System.out.println("number of publishers:"+publisherrepository.count());
        System.out.println("number of Books for Publisher:"+holands.getBooks().size());





    }
}
