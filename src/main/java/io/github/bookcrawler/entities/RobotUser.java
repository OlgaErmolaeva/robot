package io.github.bookcrawler.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
public class RobotUser implements Serializable {

    @Id
    @NotEmpty
    @NotNull
    private String login;
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String password;
    private String matchingPassword;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "robotuser_profile", joinColumns = @JoinColumn(name = "user_login"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private Set<Profile> profiles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public Set<Profile> getProfile() {
        return profiles;
    }
}
