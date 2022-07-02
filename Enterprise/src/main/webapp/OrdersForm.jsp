<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Orders</title>
</head>
<body>
<center>
        <h1>Orders Management</h1>
        <h2>
            <a href="newOrders">Add New Orders</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listOrders">List All Orders</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${orders != null}">
            <form action="updateOrders" method="post">
        </c:if>
        <c:if test="${orders == null}">
            <form action="insertOrders" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${orders != null}">
                        Edit Orders
                    </c:if>
                    <c:if test="${orders == null}">
                        Add New Orders
                    </c:if>
                </h2>
            </caption>
                <c:if test="${orders != null}">
                    <input type="hidden" name="ordNo" value="<c:out value='${orders.ordNo}' />" />
                </c:if>           
            <tr>
                <th>Purchase: </th>
                <td>
                    <input type="number" name="purchase" size="45"
                            value="<c:out value='${orders.purchase}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Data: </th>
                <td>
                    <input type="date" name="ordDate" size="45"
                            value="<c:out value='${orders.ordDate}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Id: </th>
                <td>
                    <input type="number" name="customerId" size="5"
                            value="<c:out value='${orders.customerId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salesman Id: </th>
                <td>
                    <input type="number" name="salesmanId" size="5"
                            value="<c:out value='${orders.salesmanId}' />"
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