/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Estudiante;
import DAO.EstudianteDAO;
import DAO.MateriaDAO;
import DAO.MatexestuDAO;
import DAO.NotaDAO;
import Modelo.Materia;
import Modelo.Matexestu;
import Modelo.MatexestuPK;
import Modelo.Nota;
import Modelo.NotaPK;
import java.util.ArrayList;
import java.util.List;
/*Envio Email*/
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author KRLOS
 */
public class STN {

    public STN() {
    }

    /**
     * *************************
     * METODOS TABLA ESTUDIANTE* *************************
     */
    public boolean InsertarEstudiante(int codigo, String nombre, String email, String password) {
        try {
            Estudiante estudiante = new Estudiante(codigo, nombre, email, password);
            EstudianteDAO est = new EstudianteDAO();
            est.create(estudiante);
            String asunto = "Contraseña STN";
            String cuerpo = "para el ingreso al sistema de terceras notas STN\n"
                    + "Usuario : " + nombre + "\n"
                    + "Contraseña : " + password;
            this.enviarConGMail(email, asunto, cuerpo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean logEstudiante(int codestudiante, String Pass) {

        EstudianteDAO est = new EstudianteDAO();
        Estudiante estu = est.findEstudiante(codestudiante);
        if (estu != null) {
            if (estu.getPassword().equalsIgnoreCase(Pass)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String buscarEmail(int codestudiante) {
        String email = "";
        EstudianteDAO est = new EstudianteDAO();
        Estudiante estu = est.findEstudiante(codestudiante);
        email = estu.getEmail();
        return email;
    }

    public Estudiante buscarEstudiante(int cod) {
        EstudianteDAO est = new EstudianteDAO();
        return est.findEstudiante(cod);
    }

    /**
     * **********************
     * METODOS TABLA MATERIA* **********************
     */
    public boolean RegistrarMateria(int codigo, String nombre) {
        try {
            Materia materia = new Materia(codigo, nombre);
            MateriaDAO mat = new MateriaDAO();
            mat.create(materia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean EditarMateria(int codigo, String nombre) {
        try {
            Materia materia = new Materia();
            materia.setCodigo(codigo);
            materia.setNombre(nombre);
            MateriaDAO mat = new MateriaDAO();
            mat.edit(materia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean EliminarMateria(int codMat) {
        try {

            MateriaDAO mat = new MateriaDAO();
            mat.destroy(codMat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public String ListarMateriasE(int codE) {
        String cad = "";
        try {
            ArrayList<Integer> m = this.ListaMateriaEst(codE);
            MateriaDAO mat = new MateriaDAO();

            cad = "<table id='mytable' class='table table-bordred table-striped'>\n"
                    + " <thead>\n"
                    + "            <tr>"
                    + "                <th>Codigo</th>"
                    + "                <th>Materia</th>"
                    + "                <th>Notas</th>"
                    + "            </tr>\n"
                    + "</thead>\n"
                    + "<tbody>\n";
            if (m.size() == 0) {
                cad += "<tr>\n"
                        + "<td>No Tienes Materias Matriculadas</td>"
                        + "<td></td>"
                        + "</tr>"
                        + "</tbody>\n</table>\n";
            } else {
                for (int i = 0; i < m.size(); i++) {

                    cad += "<tr>\n"
                            + "<td>" + mat.findMateria(m.get(i)).getCodigo() + "</td>"
                            + "<td>" + mat.findMateria(m.get(i)).getNombre() + "</td>"
                            + "<td><a class='btn btn-success' href='VerNota.do?codMat=" + mat.findMateria(m.get(i)).getCodigo() + "&codE=" + codE + "' role='button'><i class='fa fa-search'></i></a></td>"
                            + "</tr>";

                }
                cad += "</tbody>\n</table>\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cad;
    }

    public String ListarMaterias() {
        String cad = "";
        try {
            MateriaDAO mat = new MateriaDAO();
            List<Materia> l = mat.findMateriaEntities();
            cad = "<table id='mytable' class='table table-bordred table-striped'>\n"
                    + " <thead>\n"
                    + "            <tr>"
                    + "                <th>Codigo</th>"
                    + "                <th>Materia</th>"
                    + "                <th>Editar</th>"
                    + "                <th>Eliminar</th>"
                    + "                <th>Estudiantes</th>"
                    + "            </tr>\n"
                    + "</thead>\n"
                    + "<tbody>\n";
            if (l.size() == 0) {
                cad += "<tr>\n"
                        + "<td>No Hay Materias Matriculadas</td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "</tr>"
                        + "</tbody>\n</table>\n"
                        + "<div class='box-footer'>\n"
                        + "<a class='btn btn-primary' href='MenuSistema.do?var=1' role='button'>Registrar Materia <i class='fa fa-edit'></i></a>"
                        + "</div>";
            } else {
                for (Materia mate : l) {
                    cad += "<tr>\n"
                            + "<td>" + mate.getCodigo() + "</td>"
                            + "<td>" + mate.getNombre() + "</td>"
                            + "<td><a class='btn btn-primary' href='AdministrarMaterias.do?am=0&codMat=" + mate.getCodigo() + "' role='button'><i class='fa fa-edit'></i></a></td>"
                            + "<td><a class='btn btn-danger' href='AdministrarMaterias.do?am=1&codMat=" + mate.getCodigo() + "' role='button'><i class='fa fa-close'></i></a></td>"
                            + "<td><a class='btn btn-success' href='AdministrarMaterias.do?am=2&codMat=" + mate.getCodigo() + "' role='button'><i class='fa fa-search'></i></a></td>"
                            + "</tr>";

                }
                cad += "</tbody>\n</table>\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cad;
    }

    /**
     * *********************************
     * METODOS TABLA MATERIAXESTUDIANTE* *********************************
     */
    public boolean InsertarMateriaxEstudiante(int codigoM, int codigoE) {
        try {
            MatexestuPK mxepk = new MatexestuPK();
            Matexestu mxe = new Matexestu(codigoM, codigoE);
            MatexestuDAO mxeDAO = new MatexestuDAO();
            mxeDAO.create(mxe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean eliminarmxeMateria(int codMat) {
        try {

            MatexestuDAO mat = new MatexestuDAO();
            List<Matexestu> l = mat.findMatexestuEntities();
            for (Matexestu m : l) {
                if (m.getMatexestuPK().getCodmate() == codMat) {
                    MatexestuPK mxe = new MatexestuPK(codMat, m.getMatexestuPK().getCodestu());
                    mat.destroy(mxe);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean eliminarEstudiantexMateria(int codEst, int codMat) {
        try {

            MatexestuDAO mat = new MatexestuDAO();
            MatexestuPK mxe = new MatexestuPK(codMat, codEst);
            mat.destroy(mxe);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean matexestuVacio(int codMat) {
        try {

            MatexestuDAO mat = new MatexestuDAO();
            if (mat.getMatexestuCount() > 0) {
                List<Matexestu> l = mat.findMatexestuEntities();
                for (Matexestu m : l) {
                    if (m.getMatexestuPK().getCodmate() == codMat) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        return true;
    }

    public ArrayList<Integer> ListaMateriaEst(int codE) {
        MatexestuDAO mat = new MatexestuDAO();
        ArrayList<Integer> materias = new ArrayList<>();
        if (mat.getMatexestuCount() > 0) {
            List<Matexestu> l = mat.findMatexestuEntities();
            for (Matexestu m : l) {
                if (m.getMatexestuPK().getCodestu() == codE) {
                    materias.add(m.getMatexestuPK().getCodmate());
                }
            }
        }
        return materias;
    }

    public ArrayList<Integer> ListaEstudianteMateria(int codMat) {
        MatexestuDAO mat = new MatexestuDAO();
        ArrayList<Integer> estudiantes = new ArrayList<>();
        if (mat.getMatexestuCount() > 0) {
            List<Matexestu> l = mat.findMatexestuEntities();
            for (Matexestu m : l) {
                if (m.getMatexestuPK().getCodmate() == codMat) {
                    estudiantes.add(m.getMatexestuPK().getCodestu());
                }
            }
        }
        return estudiantes;
    }

    public String ListarEstudiantesMateria(int codMat) {
        String cad = "";
        try {

            if (this.matexestuVacio(codMat)) {
                cad = "<table id='mytable' class='table table-bordred table-striped'>\n"
                        + " <thead>\n"
                        + "            <tr>"
                        + "                <th>Codigo</th>"
                        + "                <th>Nombre</th>"
                        + "                <th>Promedio</th>"
                        + "                <th>Eliminar</th>"
                        + "            </tr>\n"
                        + "</thead>\n"
                        + "<tbody>\n"
                        + "<tr>"
                        + "<td>No Hay Estudiantes Matriculados</td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td></td>"
                        + "</tr>"
                        + "</tbody>\n</table>\n"
                        + "<div class='box-footer'>\n"
                        + "<a class='btn btn-primary' href='AgregarEstudiantes.do?am=0&codMat=" + codMat + "' role='button'>Agregar Estudiante <i class='fa fa-user'></i></a>\t\t\t\t"
                        + "<a class='btn btn-primary' href='AgregarEstudiantes.do?am=1&codMat=" + codMat + "' role='button'>Cargar Listado <i class='fa fa-book'></i></a>"
                        + "</div>";
            } else {
                ArrayList<Integer> e = this.ListaEstudianteMateria(codMat);
                EstudianteDAO est = new EstudianteDAO();

                cad = "<table id='mytable' class='table table-bordred table-striped'>\n"
                        + " <thead>\n"
                        + "            <tr>"
                        + "                <th>Codigo</th>"
                        + "                <th>Nombre</th>"
                        + "                <th>Promedio</th>"
                        + "                <th>Eliminar</th>"
                        + "            </tr>\n"
                        + "</thead>\n"
                        + "<tbody>\n";
                for (int i = 0; i < e.size(); i++) {

                    cad += "<tr>"
                            + "<td>" + est.findEstudiante(e.get(i)).getCodigo() + "</td>"
                            + "<td>" + est.findEstudiante(e.get(i)).getNombre() + "</td>"
                            + "<td>" + this.calcularPromedio(est.findEstudiante(e.get(i)).getCodigo(), codMat) + "</td>"
                            + "<td><a class='btn btn-danger' href='EliminarEstudianteNota.do?&codEst=" + est.findEstudiante(e.get(i)).getCodigo() + "&codMat=" + codMat + "' role='button'><i class='fa fa-close'></i></a></td> "
                            + "</tr>";
                }
                cad += "</tbody>\n</table>\n"
                        + "<div class='box-footer'>\n"
                        + "<a class='btn btn-primary' href='AgregarEstudiantes.do?am=0&codMat=" + codMat + "' role='button'>Agregar Estudiante <i class='fa fa-user'></i></a>\t\t\t\t"
                        + "<a class='btn btn-primary' href='AgregarEstudiantes.do?am=2&codMat=" + codMat + "' role='button'>Notas <i class='fa fa-book'></i></a>"
                        + "</div>";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cad;
    }

    /**
     * *******************
     * METODOS TABLA NOTA* *******************
     */
    public boolean insertNota(int codmateria, int codestudiante, float nota) {
        try {
            NotaDAO nd = new NotaDAO();
            int id = 1;
            NotaPK npk = new NotaPK(codmateria, codestudiante, id);
            while (nd.findNota(npk) != null) {
                id++;
                npk = new NotaPK(codmateria, codestudiante, id);
            }
            Nota n = new Nota(npk, nota);
            nd.create(n);
            String email = this.buscarEmail(codestudiante);
            String asunto = "Nueva Nota " + codmateria + " STN";
            String cuerpo = "Tienes una Nueva Nota\n"
                    + "Materia : " + codmateria + "\n"
                    + "Nota : " + nota;
            this.enviarConGMail(email, asunto, cuerpo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public float calcularPromedio(int codEst, int codmat) {
        float promedio = 0;
        float nota = 0;
        int cantNotas = this.ListarNotasMateriEstudiante(codEst, codmat).size();
        for (int i = 0; i < cantNotas; i++) {
            nota += this.ListarNotasMateriEstudiante(codEst, codmat).get(i);
        }
        return promedio = nota / cantNotas;
    }

    public ArrayList<Float> ListarNotasMateriEstudiante(int codEstu, int codMat) {
        NotaDAO n = new NotaDAO();
        ArrayList<Float> notas = new ArrayList<>();
        List<Nota> l = n.findNotaEntities();
        for (Nota nota : l) {
            if (nota.getNotaPK().getCodestudiante() == codEstu && nota.getNotaPK().getCodmateria() == codMat) {
                notas.add(nota.getNota());
            }
        }

        return notas;
    }

    public String ListarNotasEstudiante(int codMat) {
        String cad = "";

        ArrayList<Integer> codEstu = this.ListaEstudianteMateria(codMat);//Integer
        int cantNotas = this.ListarNotasMateriEstudiante(codEstu.get(0), codMat).size();
        try {
            cad = "<table id='mytable' class='table table-bordred table-striped'>\n"
                    + " <thead>\n"
                    + "            <tr>"
                    + "                <th>Codigo</th>";
            for (int i = 1; i <= cantNotas; i++) {
                cad += "<th>Nota " + i + "</th>";
            }
            cad += "</tr>\n"
                    + "</thead>\n"
                    + "<tbody>\n";
            for (int j = 0; j < codEstu.size(); j++) {

                cad += "<tr>"
                        + "<th>" + codEstu.get(j) + "</th>";
                if (this.faltanNotas(codMat, codEstu.get(j)) != 0 || this.ListarNotasMateriEstudiante(codEstu.get(j), codMat).size() == 0) {
                    for (int k = 0; k < this.faltanNotas(codMat, codEstu.get(j)); k++) {
                        cad += "<th><a class='btn btn-primary' href='AdministrarNota.do?am=1&codMat=" + codMat + "&codEst=" + codEstu.get(j) + "' role='button'><i class='fa fa-plus'></i></a></th>";
                    }
                }
                for (int k = 0; k < cantNotas; k++) {
                    cad += "<th>" + this.ListarNotasMateriEstudiante(codEstu.get(j), codMat).get(k) + "</th>";
                }
                cad += "</tr>";
            }
            cad += "</tbody></table>"
                    + "<div class='box-footer'>\n"
                    + "<a class='btn btn-primary' href='AdministrarNota.do?am=0&codMat=" + codMat + "&codEst=" + 000 + "' role='button'>Agregar Nota <i class='fa fa-plus'></i></a>"
                    + "</div>";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cad;
    }

    public String ListarNotasEstud(int codMat, int codE) {
        String cad = "";

        int cantNotas = this.ListarNotasMateriEstudiante(codE, codMat).size();
        try {
            cad = "<table id='mytable' class='table table-bordred table-striped'>\n"
                    + " <thead>\n"
                    + "            <tr>"
                    + "                <th>Codigo</th>";
            for (int i = 1; i <= cantNotas; i++) {
                cad += "<th>Nota " + i + "</th>";
            }

            cad += "<th>Promedio</th>"
                    + "</tr>\n"
                    + "</thead>\n"
                    + "<tbody>\n"
                    + "<tr>"
                    + "<th>" + codE + "</th>";

            for (int k = 0; k < cantNotas; k++) {
                cad += "<th>" + this.ListarNotasMateriEstudiante(codE, codMat).get(k) + "</th>";
            }

            cad += "<td>" + this.calcularPromedio(codE, codMat) + "</td>"
                    + "</tr>"
                    + "</tbody></table>";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cad;
    }

    public int faltanNotas(int codMat, int codEst) {
        int n = 0;
        ArrayList<Integer> codEstu = this.ListaEstudianteMateria(codMat);//Integer
        int cantNotas = this.ListarNotasMateriEstudiante(codEstu.get(0), codMat).size();
        n = cantNotas - this.ListarNotasMateriEstudiante(codEst, codMat).size();
        return n;
    }

    public String AgregarNotasEstudiante(int codMat) {
        String cad = "";

        ArrayList<Integer> codEstu = this.ListaEstudianteMateria(codMat);//Integer

        try {
            cad = "<form role='form' method='GET' action='GuardarNotas.do' >\n"
                    + "<div class='form-group'>\n"
                    + "<input type='hidden' name='codMateria' class='form-control' value='" + codMat + "' placeholder='Codigo Materia' readonly=''>\n"
                    + "</div>"
                    + "<div class='table-responsive' id='ListadoNotas'>"
                    + "<table id='mytable' class='table table-bordred table-striped'>\n"
                    + " <thead>\n"
                    + "<tr>"
                    + "<th>Codigo</th>"
                    + "<th>Nota</th>"
                    + "</tr>\n"
                    + "</thead>\n"
                    + "<tbody>\n";
            for (int j = 0; j < codEstu.size(); j++) {
                cad += "<tr><th>" + codEstu.get(j) + "</th>"
                        + "<td><input type='number' name='nota" + codEstu.get(j) + "' id='nota'step='0.01' placeholder='nota' min = '0' max='5' required></td>"
                        + "</tr>";
            }
            cad += "</tbody>\n</table>\n"
                    + "<div class='box-footer'>\n"
                    + "<button type='submit' class='btn btn-primary'>Guardar</button>"
                    + "</div>"
                    + " </div>"
                    + " </form>";

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cad;
    }

    public boolean eliminarNotaEstudiante(int codEstu, int codMat) {
        try {

            NotaDAO n = new NotaDAO();
            List<Nota> l = n.findNotaEntities();
            for (Nota nota : l) {
                if (nota.getNotaPK().getCodestudiante() == codEstu) {
                    NotaPK npk = new NotaPK(codMat, codEstu, nota.getNotaPK().getId());
                    n.destroy(npk);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean eliminarNotaMateria(int codMat) {
        try {

            NotaDAO n = new NotaDAO();
            List<Nota> l = n.findNotaEntities();
            for (Nota nota : l) {
                if (nota.getNotaPK().getCodmateria() == codMat) {
                    NotaPK npk = new NotaPK(codMat, nota.getNotaPK().getCodestudiante(), nota.getNotaPK().getId());
                    n.destroy(npk);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /*
    SIMULACION CASCADA
     */
    public boolean ELiminarMateriaCascada(int codMat) {
        if (this.EliminarMateria(codMat) && this.eliminarmxeMateria(codMat) && eliminarNotaMateria(codMat)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ELiminarEstudianteMateriaCascada(int codMat, int codEstu) {
        if (this.eliminarEstudiantexMateria(codEstu, codMat) && eliminarNotaEstudiante(codEstu, codMat)) {
            return true;
        } else {
            return false;
        }
    }

    private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("votacionesufps@gmail.com", "votaciones2018");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("votacionesufps@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertarEstudianteMateria(int codM, int codigo, String nombre, String email) {
        if (this.buscarEstudiante(codigo) != null) {
            if (this.InsertarMateriaxEstudiante(codM, codigo)) {
                System.out.println("Estudiante Matriculado a La materia");
                return true;
            } else {
                System.out.println("Estudiante ya matriculado en la materia");
                return false;
            }
        } else {
            if (this.InsertarEstudiante(codigo, nombre, email, String.valueOf(codigo) + "STN")
                    && this.InsertarMateriaxEstudiante(codM, codigo)) {
                return true;
            } else {
                return false;
            }

        }
    }

    public boolean insertarListaEstudiantes(int codMat, String txt) {
        boolean inset = false;
        String datos[] = txt.toString().split(";");
        for (int j = 1; j < datos.length - 1; j++) {
            String estudiante[] = datos[j].split(",");
            if (this.insertarEstudianteMateria(codMat, Integer.parseInt(estudiante[0].replace("\\s","").trim()), estudiante[1], estudiante[2])) {
                inset = true;
            } else {
                return false;
            }
        }
        return inset;
    }
public ArrayList<Integer> Sustentacion(int codE){
MatexestuDAO mat = new MatexestuDAO();
        ArrayList<Integer> materias = new ArrayList<>();
        if (mat.getMatexestuCount() > 0) {
            List<Matexestu> l = mat.findMatexestuEntities();
            for (Matexestu m : l) {
                if (m.getMatexestuPK().getCodestu() != codE) {
                    materias.add(m.getMatexestuPK().getCodmate());
                }
            }
        }
        return materias;
}
    
}
