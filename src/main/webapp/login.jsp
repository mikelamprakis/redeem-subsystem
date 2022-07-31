 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="css/pure-min.css">
    <link rel="stylesheet" href="css/custom.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbar-static/">
    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a27fadce28.js" crossorigin="anonymous"></script>
</head>
    <body>
    <div class="bg-dark text-secondary px-4 py-5">
            <br/>
    <div class="py-5">

    <div class="container">
    <div class="col-md-10 mx-auto col-lg-5">

        <sf:form action="loginSubmit" method="post" modelAttribute="user" class="p-4 p-md-5 border rounded-3 bg-light">

                <h2>Sign in</h2>
                <hr/>
                <div>
                <sf:label path="firstname">Firstname:</sf:label>
                <sf:input class="form-control" type="text" path="firstname" required="required"/>
                </div>

                <br/>

                <div>
                <sf:label path="lastname">Lastname:</sf:label>
                <sf:input class="form-control" type="text" path="lastname" required="required"/>
                </div>

                <br/>

                <div class="col">
                <button type="submit" class="btn btn-primary">Login</button>
                </div>

        </sf:form>
    <br/>
    <br/>
    </div>
    </div>
    </div>
    </div>

    </body>
</html>
