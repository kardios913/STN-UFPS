<%-- 
    Document   : FormProfesor
    Created on : 30/11/2018, 01:52:05 AM
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
                            Pagina Principal<br>
                            <small>Seleccion una Opción</small>
                        </center>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <div class="row">

                        <div class="col-lg-3 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">

                                    <p>Registrar Materia </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="MenuSistema.do?var=1"  class="small-box-footer">Acceder <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-xs-6">

                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">

                                    <p>Listar Materias </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="MenuSistema.do?var=2" class="small-box-footer">Acceder <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>

   <div class="col-lg-3 col-xs-6">

                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">

                                    <p>Sustentacion </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="MenuSistema.do?var=3" class="small-box-footer">Acceder <i class="fa fa-arrow-circle-right"></i></a>
                            </div>
                        </div>                        
                </section>
                <!-- /.content -->
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </div>
</body>
</html>