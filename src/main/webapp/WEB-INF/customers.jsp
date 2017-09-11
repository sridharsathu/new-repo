<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>Id</td>
                    <td>FirstName</td>
                    <td>LastName</td>
                </tr>
                <c:forEach items="${customerData}" var="element">

                    <tr>
                        <td><c:out value="${element.id}" /></td>
                        <td><c:out value="${element.firstName}" /></td>

                        <td><c:out value="${element.lastName}" /></td>

                       <!--   <td>display Department Name here </td>-->

                       <!--  <td><a
                            href="<c:url value="editEmployee.htm">  
                    <c:param name="emp_id" value="${element.id}"/>  
        </c:url>  
    ">Edit</a>
                            <a
                            href="<c:url value="deleteEmployee.htm">  
                    <c:param name="emp_id" value="${element.id}"/>  
        </c:url>  
    ">Delete</a>

                        </td> --> 
                    </tr>
                </c:forEach>
            </table>
</body>
</html>