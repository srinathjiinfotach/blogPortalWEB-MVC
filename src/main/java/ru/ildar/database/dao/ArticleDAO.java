package ru.ildar.database.dao;

import org.springframework.stereotype.Repository;
import ru.ildar.entities.Article;
import ru.ildar.entities.Comment;
import ru.ildar.entities.User;

import java.util.List;

@Repository
public interface ArticleDAO
{
    List<Article> retrieveLatestArticles(int count, int offset);
    void addArticle(Article article, User user);
    List<Comment> getComments(Article article, int count, int offset);
    void addComment(Comment comment, User user, Article article);
}
