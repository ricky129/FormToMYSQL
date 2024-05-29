/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ricky
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/java/inserisciUtenteServlet")
public class InserisciUtenteServlet extends HttpServlet {
    
    public static String stringToSHA2(String input) {
        try {
            //ottieni un'istanza di MessageDigest per l'algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Calcola l'hash della stringa di input
            byte[] hashBytes = digest.digest(input.getBytes());

            //Converte l'array di byte dell'hash in una rappresentazione esadecimale
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hashBytes.length; i++) {
                byte hashByte = hashBytes[i];
                //Calcoliamo la rappresentazione esadecimale hex di hashByte come nel codice originale
                String hex = Integer.toHexString(0xff & hashByte);
                /*
                Se la lunghezza della stringa hex è 1 (cioè rappresenta un solo carattere 
                esadecimale), aggiungiamo uno zero all'inizio per assicurarci che ciascun 
                byte sia rappresentato da due caratteri esadecimali
                 */
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String cognome = request.getParameter("cognome");
        String datadinascita = request.getParameter("datadinascita");
        int tel = Integer.parseInt(request.getParameter("tel"));
        String password = stringToSHA2(request.getParameter("password"));

        String jdbcURL = "jdbc:mysql://localhost:3306/users";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String sql = "INSERT INTO UTENTI (userid, username, cognome, datadinascita, tel, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userid);
            statement.setString(2, username);
            statement.setString(3, cognome);
            statement.setString(4, datadinascita);
            statement.setString(5, String.valueOf(tel));
            statement.setString(6, password);

            if (statement.executeUpdate() > 0)
                System.out.println("Un nuovo utente è stato inserito con successo.");

            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("successo.jsp");
    }
}
