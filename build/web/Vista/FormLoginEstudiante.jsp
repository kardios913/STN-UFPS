<%-- 
    Document   : FormLoginEstudiante
    Created on : 13/12/2018, 03:49:49 AM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
        <title>Estudiante-Terceras Notas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CSS/MiStilo.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <section class="container-fluid">
            <div class="row justify-content-center  ">

                <div class="col-3 rounded border shadow p-3 mb-5 bg-white " id="col-Login" >
                    <ul id="top-bar" class="nav nav-tabs nav-justified">
                        <li class="active"><a class='btn btn-default' id='loginpro' href='#' role='button' >Login Estudiante</a></li>
                        <li><a class='btn btn-default' id="LoginEstudiante" href='LoginEstudiante.do?var=1' role='button' >Login Profesor</a></li>
                    </ul>
                    <form class="login-form" action="LogProfesor.do" method="POST">
                        <div class="form-group" id="errorLogin" >
                        </div>
                        <div class="form-group">
                            <label >Username</label>
                            <input type="text" id="userE" name="userE" class="form-control" placeholder="Usuario" required>    
                        </div>
                        <div class="form-group">
                            <label >Password</label>
                            <input type="password" class="form-control"  id="passwordE" name="passwordE"  placeholder="Password" required>
                        </div>
                        <div class="form-group">
                            <button type="submit" id="LoginEstudiante" class="btn btn-default float-right">Entrar</button>                              
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
