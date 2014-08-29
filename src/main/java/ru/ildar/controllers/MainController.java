package ru.ildar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.ildar.database.Factory;

@Controller
public class MainController
{
    @Autowired
    private Factory factory;


}
