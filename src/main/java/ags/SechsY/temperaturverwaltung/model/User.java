package ags.SechsY.temperaturverwaltung.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    public static String ENTITY_NAME = "User";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "phonenumber", nullable = false)
    private String phonenumber;

    @Column(name = "admin", nullable = false)
    private boolean admin;

    public User() {
    }

    public User(String name, String nickname, String phonenumber, boolean isAdmin) {
        this.name = name;
        this.nickname = nickname;
        this.phonenumber = phonenumber;
        this.admin = isAdmin;
    }
}