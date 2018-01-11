package com.lanou3g.admin.Category.service;

import com.lanou3g.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryService",urlPatterns = "/admin")
public class CategoryService extends BaseServlet {

    public String findAll(HttpServletRequest request,HttpServletResponse response){

        System.out.println("a");


        return "/adminjsps/admin/category/list.jsp";
    }
}
