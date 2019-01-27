package com.iliass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iliass.models.Publication;

public class DAOPublication {

	public List<Publication> getAllPosts(){
		
		List<Publication> listPosts = new ArrayList<Publication>() ;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetEE", "java", "iliass123") ;
			Statement st = con.createStatement() ;
			ResultSet rs = st.executeQuery("select * from Postes") ;
			
			
			while (rs.next()) {
				Publication publication = new Publication() ;
				publication.setIdPublication(rs.getInt("id_Poste"));
				publication.setTitre(rs.getString("Titre"));
				publication.setDescription(rs.getString("Description"));
				
				listPosts.add(publication) ;
 			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		return listPosts ;
	}

}