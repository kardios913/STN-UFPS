<%-- 
    Document   : FormVerNota
    Created on : 13/12/2018, 05:23:08 AM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String msg = (String) session.getAttribute("Notas");
    %>
    <jsp:include page="heap.jsp"/>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <jsp:include page="headerE.jsp"/>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        <center>
                            Reporte Notas<br>
                            <small></small>
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