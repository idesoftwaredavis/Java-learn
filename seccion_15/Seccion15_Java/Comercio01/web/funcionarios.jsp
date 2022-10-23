<%-- 
    Document   : funcionarios
    Created on : Jan 31, 2022, 6:47:33 PM
    Author     : acidsulfurico
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Funcionarios"%>
<%@page import="control.FuncionarosControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Funcionarios</h1>
        
        <br>
        <%
          FuncionarosControl funcionariosControl = new FuncionarosControl();
          Funcionarios funcionariosObj = null;
          if( request.getParameter("reg") == null ){ 
        %>
        <table width="90%" border="1" align="center">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>CI</th>
                <th>Cargo</th>
                <th>Sueldo</th>
                <th width="70px"> <a href="?reg=si">Nuevo</a></th>
                <th>Eliminar</th>
            </tr>
            <%
                
                
                List<Funcionarios> lista =  funcionariosControl.listar();
                // recorra la lista y para cada una de las filas, cargue en f el resultado.
                for (Funcionarios f : lista ){   
            %>
            <tr>
                <td><% out.print(f.getId()); %></td>
                <td><%= f.getNombre() %></td>
                <td><%= f.getApellido() %></td>
                <td><%= f.getCi() %> </td>
                <td><%= f.getCargo() %></td>
                <td><%= f.getSueldo() %></td>
                <td align="center"><a href="?reg=si&id=<%= f.getId() %>">Mod</a></td>
                <td align="center"><a href="#"
                                      onclick="if(confirm('estas seguro?')){
                                          window.location.href = 'SFuncionarios?del=si&id=<%= f.getId() %>';
                                      }">Del</a>
                </td>                                
            </tr>   
            <%     
            }
            %>
        </table>
        
            <%
                }else{

                if ( request.getParameter("id") != null){
                    funcionariosObj = new Funcionarios(Integer.parseInt(request.getParameter("id")));
                    // Accedo al metodo de la clase funcionarosControl 
                    funcionariosObj = funcionariosControl.buscar(funcionariosObj);
                    out.print(funcionariosObj.getApellido());
                    //funcionariosObj = funcionariosControl.buscar(f);
                }
            %>
        <br>
        <br>
        <br>
        
        <form action="SFuncionarios" method="POST">
            <table border="1" align="center">
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%
                       if ( funcionariosObj != null){
                           out.print(funcionariosObj.getId());
                       } 
                        %>" readonly="true"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%
                       if ( funcionariosObj != null){
                           out.print(funcionariosObj.getNombre());
                       } 
                    %>"/>
                    </td>
                </tr>
               
                <tr>
                    <td>Apellido</td>
                   <td><input type="text" name="apellido" value="<%
                            if ( funcionariosObj != null){
                           out.print(funcionariosObj.getApellido());
                       } 
                     %>"/>
                </tr>
                
                <tr>
                    <td>CI</td>
                    <td><input type="number" name="CI" value="<%
                            if ( funcionariosObj != null){
                           out.print(funcionariosObj.getCi());
                       } 
                     %>"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Cargo</td>
                    <td><input type="text" name="cargo" value="<%
                        if ( funcionariosObj != null){
                           out.print(funcionariosObj.getCargo());
                       } 
                    %>"/>                   
                    </td>
                </tr>
                
                <tr>
                    <td>Sueldo</td>
                    <td><input type="number" name="sueldo" value="<%
                        if ( funcionariosObj != null){
                           out.print(funcionariosObj.getSueldo());
                       } 
                        
                        %>"/>
                    
                    
                    </td>
                </tr>
                
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="enviar"/> <br>
                        <a href="funcionarios.jsp">Cancelar</a>
                    </td>

                    
                </tr>
            </table>
        </form>
        <%
            }
         %>
    </body>
</html>
