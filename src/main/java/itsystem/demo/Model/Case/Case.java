package itsystem.demo.Model.Case;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Case {

    @Id
    @Column("case_id")
    private Long id;

    private String caseOwner;

    private String assigned;

    private String subject;
    private String description;

    public Case() {
    }

    public Case(Long id, String caseOwner, String assigned, String subject, String description) {
        this.id = id;
        this.caseOwner = caseOwner;
        this.assigned = assigned;
        this.subject = subject;
        this.description = description;
    }

    public Case(Long id, String subject, String description) {
        this.id = id;
        this.subject = subject;
        this.description = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseOwner() {
        return caseOwner;
    }

    public void setCaseOwner(String caseOwner) {
        this.caseOwner = caseOwner;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }
}
