/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.crud.dao.Query;
import com.crud.model.Album;
 
public class AlbumController extends HttpServlet {
    
    private Query query;
    private static String FORM = "/form.jsp";
    private static String LIST = "/list.jsp";
    
 
    public AlbumController() {
        super();
        query = new Query();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String view="";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("delete")){
            
            String id = request.getParameter("id");
            query.deleteAlbum(id);
            view = LIST;
            request.setAttribute("albums", query.getAllAlbums());
            
        } else if (action.equalsIgnoreCase("edit")){
            
            view = FORM;
            String id = request.getParameter("id");
            Album albums = query.getAlbumById(id);
            request.setAttribute("albums", albums);
            
        } else if (action.equalsIgnoreCase("list")){
            
            view = LIST;
            request.setAttribute("albums", query.getAllAlbums());
            
        } else {
            //request.setAttribute("action", "insert");
            view = FORM;
        }
 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Album album = new Album();
        album.setAlbum(request.getParameter("album"));
        album.setComposer(request.getParameter("composer"));
        album.setGenre(request.getParameter("genre"));
        album.setGenre(request.getParameter("number"));
        try {
            Date reg = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("date"));
            System.out.println("rrrrrrrrrrr"+ reg);
            album.setRelease(reg);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if("edit" == request.getParameter("action"))
            query.updateAlbum(album);
        else
            query.createAlbum(album);
                    
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("albums", query.getAllAlbums());
        view.forward(request, response);
    }
}
