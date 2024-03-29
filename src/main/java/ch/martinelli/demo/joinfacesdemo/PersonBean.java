package ch.martinelli.demo.joinfacesdemo;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
public class PersonBean {

    public String heading() {
        return "Hello, " + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public List<Person> getPersons() {
        return List.of(new Person("Simon", "Martinelli"), new Person("John", "Doe"));
    }

    public void showInfo() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content"));
    }

}
