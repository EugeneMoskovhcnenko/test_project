package com.social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Question")
public class Question extends Field {


    private Type type;
    private String label;
    private boolean active;
    private boolean required;



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    public User getUser() {
        return user;
    }
    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }

    public Question() {
    }

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
    private List<Answer> answer;

    public List<Answer> getAnswer() {
        return answer;
    }


    public void setAnswer(List<Answer> a, int n){
        this.answer = new ArrayList<>();
        this.answer.addAll(a);
    }

    public void setAnswer(List<Answer> answer) {
        this.answer.clear();
        this.answer.addAll(answer);
    }

    public void updateQuestion(Question q) {
        this.type = q.type;
        this.label = q.label;
        this.active = q.active;
        this.required = q.required;
        this.setInput(q.getInput());
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
