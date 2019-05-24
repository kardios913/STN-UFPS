<%-- 
    Document   : FormListarMateriaE
    Created on : 13/12/2018, 04:56:21 AM
    Author     : KRLOS
--%>

<!DOCTYPE html>
<html>
    <%
        String msg = (String) session.getAttribute("cad");
    %>
    <jsp:include page="heap.jsp"/>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <jsp:include page="headerE.jsp"/>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        <center>
                            Materias Registradas<br>
                            <small>Seleccion una Opción</small>
                        </center>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="box box-danger">
                                <form role="form" method="GET">
                                    <div class="table-responsive" id="ListadoMateria">
                                        <%=msg%>
                                    </div>
                                </form>
                            </div>
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
