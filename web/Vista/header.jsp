<%-- 
    Document   : header
    Created on : 4/12/2018, 11:30:44 AM
    Author     : KRLOS
--%>


<!DOCTYPE html>
<header class="main-header">

    <a href="MenuSistema.do?var=0" class="logo">
        <!-- logo for regular state and mobile devices -->
        <span class="logo-mini"> <img src="./imagen/logo_ufps.png"/></span>
        <span  class="logo-lg" ><b>UFPS</b> Tercera Nota</span>
        <!--     
              <img  class="logo-lg img-responsive " src="../imagen/logo_votaciones2.png"/>-->

    </a>


    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!--empieza-->
                <li class='dropdown user user-menu'>
                    <!-- Menu Toggle Button -->
                    <a href='#' class='dropdown-toggle' data-toggle='dropdown'>
                        <!-- The user image in the navbar-->
                        <img src="./imagen/avatar.png" class='user-image' alt='User Image'>
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class='hidden-xs'>${sessionScope.usuario}</span>
                    </a>
                    <ul class='dropdown-menu'>
                        <!-- The user image in the menu -->
                        <li class='user-header'>
                            <img src='./imagen/avatar.png' class='img-circle' alt='User Image'>

                            <p>
                                ${sessionScope.usuario}
                                <small>UFPS</small>
                            </p>
                        </li>

                        <!-- Menu Footer-->
                        <li class='user-footer'>
                            <div class='pull-right'>
                                <form name="cerrarsession" action="CerrarSession.do" method="post">
                                    <input type="submit" class="btn btn-primary btn-flat" value="Cerrar Session" name="cerrarSession" />   
                                </form>
                            </div>
                        </li>
                    </ul>
                </li>        
                <!--Termina-->       
            </ul>
        </div>
    </nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header"><center>Menu del Sistema</center></li>
            <li><a href="MenuSistema.do?var=0"><i class="fa fa-home"></i> <span>Inicio</span></a></li>
            <li><a href="MenuSistema.do?var=1" ><i class="fa fa-edit"></i> <span>Registrar Materia</span></a></li>
            <li><a href="MenuSistema.do?var=2"><i class="fa fa-book"></i> <span>Listar Materia </span></a></li>
            <li><a href="MenuSistema.do?var=3"><i class="fa fa-book"></i> <span>Sustentacion </span></a></li>
           
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
