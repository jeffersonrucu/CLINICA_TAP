<%@ page import="sistema.controller.ControllerLogin" %>

<%
    Boolean token = false;
    String username = "";
    String password = "";

    if (request.getParameter("username") != null && request.getParameter("password") != null) {
        username = request.getParameter("username");
        password = request.getParameter("password");

        token = new ControllerLogin().valid(username, password);
    }
%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Materialize -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <!-- Custom -->
        <link rel="stylesheet" href="assets/index.css">

        <title>Consultorios</title>
    </head>

    <body>
    <header>
        <nav class="blue darken-1">
            <div class="nav-wrapper">
                <div class="container">
                    <a href="/" class="brand-logo">Studio STG</a>

                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <% if (token) { %>
                            <li><a href="${pageContext.request.contextPath}">Cargos</a></li>
                            <li><a href="${pageContext.request.contextPath}">Funcionarios</a></li>
                            <li><a href="${pageContext.request.contextPath}">Pacientes</a></li>
                            <li><a href="${pageContext.request.contextPath}">Consultas</a></li>
                        <% } else { %>
                            <li><a href="${pageContext.request.contextPath}/index.jsp">Realizar Login</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
