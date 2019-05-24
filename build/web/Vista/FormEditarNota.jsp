<%-- 
    Document   : FormEditarNota
    Created on : 13/12/2018, 02:10:30 AM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String msj = (String) session.getAttribute("codMateria");
         String[] cod = new String[2];
         cod=msj.split("/");
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
                            Editar Nota<br>
                            <small>Digite el Formulario</small>
                        </center>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="box box-danger">
                                <form role="form" method="POST" action="EditarNota.do" name='editarMateria'>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Codigo Materia</label>
                                            <input type="number" name="codMateria" class="form-control" value="<%=cod[0]%>" placeholder="Codigo Materia" readonly="">
                                        </div>
                                        <div class="form-group">
                                            <label>Codigo Estudiante</label>
                                            <input type="number" name="codEstudiante" class="form-control" value="<%=cod[1]%>" placeholder="Codigo Materia" readonly="">
                                        </div>
                                        <div class="form-group">
                                            <label>Nota</label>
                                            <input type="number" class="form-control" name="Nota" placeholder="Nota"  required>
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


