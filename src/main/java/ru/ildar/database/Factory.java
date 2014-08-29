package ru.ildar.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ildar.database.dao.ArticleDAO;
import ru.ildar.database.dao.UserDAO;

@Service
public class Factory
{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ArticleDAO articleDAO;

    public Factory() { }

    public UserDAO getUserDAO()
    {
        return userDAO;
    }
    public ArticleDAO getArticleDAO()
    {
        return articleDAO;
    }
}
