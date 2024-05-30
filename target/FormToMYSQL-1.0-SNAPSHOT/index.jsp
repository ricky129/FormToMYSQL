<%-- 
    Document   : newjsp
    Created on : 20 May 2024, 18:03:55
    Author     : ricky
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h2>Inserisci Nuovo Utente</h2>
    <form action="inserisciUtente" method="post">
        <label for="userid">userid:</label>
        <input type="text" id="userid" name="userid" required value="1"><br><br>

        <label for="username">username:</label>
        <input type="username" id="username" name="username" required value="ricky2"><br><br>

        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required value="ricky3"><br><br>

        <label for="datadinascita">Data di nascita:</label>
        <input type="text" id="datadinascita" name="datadinascita" required value="29-05-2024"><br><br>

        <label for="tel">Telefono:</label>
        <input type="tel" id="tel" name="tel" required value="1234567890"><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required value="1234"><br><br>

        <input type="submit" value="Inserisci">
    </form>
</body>
</html>
