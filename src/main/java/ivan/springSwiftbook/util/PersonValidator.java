package ivan.springSwiftbook.util;

import ivan.springSwiftbook.dto.PersonDAO;
import ivan.springSwiftbook.models.Person;
import ivan.springSwiftbook.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        // есть ли человек с таким же именем в БД
        if (peopleService.getPersonByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("full_name","", "Человек с ФИО уже зарегистрирован");
        }
    }
}
