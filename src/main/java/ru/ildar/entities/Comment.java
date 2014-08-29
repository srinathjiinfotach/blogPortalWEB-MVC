package ru.ildar.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Ildar2 on 8/29/14.
 */
@Entity
@Table(name = "MBWA_COMMENT", schema = "ILDAR", catalog = "")
public class Comment
{
    private long id;
    private String content;
    private Timestamp publicationDate;
    private Article article;
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

        Comment that = (Comment) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (publicationDate != null ? !publicationDate.equals(that.publicationDate) : that.publicationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ARTICLEID", referencedColumnName = "ID", nullable = false)
    public Article getArticle()
    {
        return article;
    }

    public void setArticle(Article articleByArticleid)
    {
        this.article = articleByArticleid;
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
