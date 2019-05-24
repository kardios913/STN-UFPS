<%-- 
    Document   : FormAgregarEstudiante
    Created on : 12/12/2018, 04:08:08 PM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String codigo = (String) session.getAttribute("CodMateriaEstudiante");
    %>
    <jsp:include page="heap.jsp"/>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <jsp:include page="header.jsp"/>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">

                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        <center>
                            Registro Estudiante<br>
                            <small>Digite el Formulario</small>
                        </center>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="box box-danger">
                                <form role="form" method="POST" action="GuardarEstudiante.do" name='agregarEstudiante'>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <input type="hidden" name="codMateria" class="form-control" value="<%=codigo%>" placeholder="Codigo Materia" readonly="">
                                        </div>
                                        <div>
                                            <label>Codigo </label>
                                            <input type="number" name="codEstudiante" class="form-control" placeholder="Codigo" >
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre </label>
                                            <input type="text" class="form-control" name="nomEstudiante" placeholder="Nombre Estudiante"  required>
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="email" class="form-control" name="emailEstudiante" placeholder="email"  required>
                                        </div>
                                    </div>
                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>


