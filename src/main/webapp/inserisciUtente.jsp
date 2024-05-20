<%-- 
    Document   : inserisciUtente
    Created on : 20 May 2024, 18:07:58
    Author     : ricky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inserisci Utente</title>
</head>
<body>
    <h2>Inserisci Nuovo Utente</h2>
    <form action="inserisciUtente" method="post">
        <label for="userid">userid:</label>
        <input type="text" id="userid" name="userid" required><br><br>
        
        <label for="username">username:</label>
        <input type="username" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Inserisci">
    </form>
</body>
</html>
