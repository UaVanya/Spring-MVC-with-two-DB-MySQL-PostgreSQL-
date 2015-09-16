<%@ page import="java.util.Map" %>
<%@ page import="com.spilnasprava.entity.mysql.User" %>
<%@ page import="com.spilnasprava.entity.postgresql.Area" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.spilnasprava.object.AreaType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body bgcolor="#fafad2">
<table align="center" border="0" width="300">
    <tr border="0">
        <td border="0"><a href="adduser.jsp">Add user</a></td>
    </tr>
</table>

<table align="center" border="" width="300">
    <tr>
        <th width="170">Name</th>
        <th width="170">E-mail</th>
        <th width="170">Area</th>
    </tr>
    <%Iterator iter;%>
    <% Map<User, Area> result = (Map<User, Area>) request.getAttribute("result");
        Set<User> users = (Set<User>) result.keySet();
        if (result != null && !result.isEmpty()) {
            for (User user : users) {
                Area area = result.get(user);
    %>
    <tr>
        <td width="170"><%=user.getName()%>
        </td>
        <td width="170"><%=user.getEmail()%>
        </td>
        <td width="170"><%=area.getArea().name()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>