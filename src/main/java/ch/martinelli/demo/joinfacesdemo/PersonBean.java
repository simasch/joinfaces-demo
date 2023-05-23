package ch.martinelli.demo.joinfacesdemo;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
public class PersonBean {

    public String heading() {
        return "JSF People Management";
    }

    public List<Person> getPersons() {
        return List.of(new Person("Simon", "Martinelli"), new Person("John", "Doe"));
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content");
    }

}
