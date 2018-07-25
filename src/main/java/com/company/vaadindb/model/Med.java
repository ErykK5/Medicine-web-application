package com.company.vaadindb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "list1")
public class Med {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String numb;

    public Med(Long id, String numb, String name) {
        this.id = id;
        this.numb = numb;
        this.name = name;
    }

    public Med() {
    }

    public Med( Long id ){
        this.id = id;
    }

    public Med( String name, String numb ){
        this.name = name;
        this.numb = numb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
