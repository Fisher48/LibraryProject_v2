package ivan.springSwiftbook.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @Size(min = 2, max = 255, message = "ФИО должно быть минимум 2 символа и максимум 255")
    @NotEmpty(message = "ФИО не может быть пустым")
    private String fullName;

    @Column(name = "birthdate")
    @Min(value = 1900, message = "Год рождения должен быть выше 1900")
    private Integer birthdate;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person() { }

    public Person(int id, String fullName, Integer birthdate) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Integer birthdate) {
        this.birthdate = birthdate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}


