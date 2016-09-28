package io.github.bookcrawler.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class RobotUser implements Serializable {

    @Id
    private String login;
    private String name;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="robotuser_profile", joinColumns=@JoinColumn(name="user_login"), inverseJoinColumns=@JoinColumn(name="profile_id"))
    private Set<Profile> profiles;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Set<Profile> getProfile() {
        return profiles;
    }
}
