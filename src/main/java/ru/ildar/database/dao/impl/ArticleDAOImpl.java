package ru.ildar.database.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.ildar.database.HibernateUtil;
import ru.ildar.database.dao.ArticleDAO;
import ru.ildar.entities.Article;
import ru.ildar.entities.Comment;
import ru.ildar.entities.User;

import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO
{
    @Override
    @SuppressWarnings("unchecked")
    public List<Article> retrieveLatestArticles(int count, int offset)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Article> articles = session.createCriteria(Article.class)
                    .setMaxResults(count).setFirstResult(offset).list();
            session.getTransaction().commit();
            return articles;
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void addArticle(Article article, User user)
    {
        if(article.getUser() == null)
            article.setUser(user);

        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Comment> getComments(Article article, int count, int offset)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Comment> comments = session.createCriteria(Comment.class)
                    .add(Restrictions.eq("article", article))
                    .setMaxResults(count).setFirstResult(offset).list();
            session.getTransaction().commit();
            return comments;
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void addComment(Comment comment, User user, Article article)
    {
        if(comment.getUser() == null)
            comment.setUser(user);
        if(comment.getArticle() == null)
            comment.setArticle(article);

        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(comment);
            session.getTransaction().commit();
        }
        finally
        {
            if(session != null && session.isOpen())
                session.close();
        }
    }
}
