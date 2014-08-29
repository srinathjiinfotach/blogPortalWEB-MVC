package ru.ildar.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Ildar2 on 8/29/14.
 */
@Entity
@Table(name = "MBWA_USERDETAILS", schema = "ILDAR", catalog = "")
public class UserDetails
{
    private long userId;
    private Timestamp birthDate;
    private String location;
    private String languages;
    private String email;
    private String about;
    private User user;

    @Id
    @Column(name = "USERID")
    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userid)
    {
        this.userId = userid;
    }

    @Basic
    @Column(name = "BIRTHDATE")
    public Timestamp getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthdate)
    {
        this.birthDate = birthdate;
    }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Basic
    @Column(name = "LANGUAGES")
    public String getLanguages()
    {
        return languages;
    }

    public void setLanguages(String languages)
    {
        this.languages = languages;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "ABOUT")
    public String getAbout()
    {
        return about;
    }

    public void setAbout(String about)
    {
        this.about = about;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetails that = (UserDetails) o;

        if (userId != that.userId) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (languages != null ? !languages.equals(that.languages) : that.languages != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "USERID", referencedColumnName = "ID", nullable = false)
    public User getUser()
    {
        return user;
    }

    public void setUser(User userByUserid)
    {
        this.user = userByUserid;
    }
}
