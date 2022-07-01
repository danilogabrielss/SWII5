<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Salesman</title>
</head>
<body>
<center>
        <h1>Salesman Management</h1>
        <h2>
            <a href="newSalesman">Add New Salesman</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listSalesman">List All Salesman</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${salesman != null}">
            <form action="updateSalesman" method="post">
        </c:if>
        <c:if test="${salesman == null}">
            <form action="insertSalesman" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${salesman != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${salesman == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${salesman != null}">
                    <input type="hidden" name="id" value="<c:out value='${salesman.id}' />" />
                </c:if>           
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${salesman.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Cidade: </th>
                <td>
                    <input type="text" name="city" size="45"
                            value="<c:out value='${salesman.city}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Comissão: </th>
                <td>
                    <input type="text" name="commission" size="5"
                            value="<c:out value='${salesman.commission}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>