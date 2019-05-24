<%-- 
    Document   : FormAgregarNota
    Created on : 13/12/2018, 12:27:44 AM
    Author     : KRLOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%
        String msg = (String) session.getAttribute("Notas");
       
    %>
    <jsp:include page="heap.jsp"/>
    <body class="hold-transition skin-red sidebar-mini">
        <div class="wrapper">
            <jsp:include page="header.jsp"/>
            <div class="content-wrapper">
                <section class="content-header">
                    <h1>
                        <center>
                            Agregar Notas<br>
                            <small>diligencie el formulario</small>
                        </center>
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="box box-danger">
                                
                                        <%=msg%>
                                   
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

