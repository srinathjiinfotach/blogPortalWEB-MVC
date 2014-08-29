package ru.ildar.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Ildar2 on 8/29/14.
 */
@Entity
@Table(name = "MBWA_ARTICLE", schema = "ILDAR", catalog = "")
public class Article
{
    private long id;
    private String name;
    private String content;
    private Timestamp publicationDate;
    private User user;

    @Id
    @Column(name = "ID")
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "PUBLICATIONDATE")
    public Timestamp getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationdate)
    {
        this.publicationDate = publicationdate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article that = (Article) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (publicationDate != null ? !publicationDate.equals(that.publicationDate) : that.publicationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
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
