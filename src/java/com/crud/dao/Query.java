/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.dao;

import java.sql.*;
import java.util.*;
import com.crud.model.Album;
import com.crud.util.ConnectionToDb;
 
public class Query {
 
    private Connection connection;
 
    public Query() {
        connection = ConnectionToDb.getConnection();
    }
 
    public void createAlbum(Album album) {
        try {
            PreparedStatement prepare = connection.prepareStatement(
                    "insert into albums(album, composer, genre, number, release_date) value(?, ?, ?, ?, ? )");
            prepare.setString(1, album.getAlbum());
            prepare.setString(2, album.getComposer());
            prepare.setString(3, album.getGenre());
            prepare.setInt(4, album.getNumber());
            prepare.setDate(5, new java.sql.Date(album.getRelease().getTime()));
            prepare.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteAlbum(String id) {
        try {
            PreparedStatement prepare = connection.prepareStatement("delete from albums where id=?");
            // Parameters start with 1
            prepare.setString(1, id);
            prepare.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /*public void checkUser(Album user) {
        try {
            PreparedStatement prepare = connection.prepareStatement("select album from albums where album = ?");
            prepare.setString(1, user.getAlbum());
            ResultSet rs = prepare.executeQuery();
            if (rs.next()) // found
            {
                updateUser(user);
            } else {
                createAlbum(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }*/
    public void updateAlbum(Album album) {
        try {
            PreparedStatement prepare = connection.prepareStatement("update albums set album=?, composer=?, genre=?, number=?, release_date=?"
                    + "where id=?");
            prepare.setString(1, album.getAlbum());
            prepare.setString(2, album.getComposer());
            prepare.setString(3, album.getGenre());
            prepare.setInt(4, album.getNumber());
            prepare.setDate(5, new java.sql.Date(album.getRelease().getTime()));
            prepare.setInt(5, album.getId());
            prepare.executeUpdate();
            System.out.println(new java.sql.Date(album.getRelease().getTime()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Album getAlbumById(String id) {
        Album album = new Album();
        try {
            PreparedStatement prepare = connection.prepareStatement("select * from albums where id=?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
 
            if (result.next()) {
                album.setId(result.getInt("id"));
                album.setAlbum(result.getString("album"));
                album.setComposer(result.getString("composer"));
                album.setGenre(result.getString("genre"));
                album.setNumber(result.getInt("number"));
                album.setRelease(result.getDate("release_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return album;
    }
 
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<Album>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from albums");
            while (result.next()) {
                Album album = new Album();
                album.setId(result.getInt("id"));
                album.setAlbum(result.getString("album"));
                album.setComposer(result.getString("composer"));
                album.setGenre(result.getString("genre"));
                album.setNumber(Integer.parseInt(result.getString("number")));
                album.setRelease(result.getDate("release_date"));
                albums.add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return albums;
    }
 
}
