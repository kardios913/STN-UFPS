<%-- 
    Document   : FormEstudiante
    Created on : 13/12/2018, 04:12:53 AM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    String msg = (String) session.getAttribute("usuario");
    %>
    <jsp:include page="heap.jsp"/>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <jsp:include page="headerE.jsp"/>
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

                                    <p>Listar Materias </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="MenuSitemaE.do?var=1&codE=<%=msg%>" class="small-box-footer">Acceder <i class="fa fa-arrow-circle-right"></i></a>
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