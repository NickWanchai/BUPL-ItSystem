package itsystem.demo.Model;

public class Case {

    private String subject;
    private String description;

    public Case() {
    }

    public Case(String subject, String description) {
        this.subject = subject;
        this.description = description;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
