<%-- 
    Document   : FormRegistrarMateria
    Created on : 5/12/2018, 11:44:17 PM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                            Registro Materia<br>
                            <small>Digite el Formulario</small>
                        </center>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="box box-danger">
                                <form role="form" method="POST" action="RegistrarMateria.do" name='registroMateria'>
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Codigo</label>
                                            <input type="number" name="codMateria" class="form-control" placeholder="Codigo Materia" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre Materia</label>
                                            <input type="text" class="form-control" name="nomMateria" placeholder="Nombre Materia"  required>
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
