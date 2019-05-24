<%-- 
    Document   : FormAgregarEstudianteL
    Created on : 17/12/2018, 07:49:32 PM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String codigo = (String) session.getAttribute("CodMateriaEstudianteL");
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
                                <form role="form" method="POST" enctype="multipart/form-data"  action="CargarEstduiantes.do?codMateriaL=<%=codigo%>" name='agregarListado'>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Listado </label>
                                            <input type="file" class="form-control" name="Listado" placeholder="Txt estudiantes"  required>
                                        </div>
                                        
                                    </div>
                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary">Cargar</button>
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


