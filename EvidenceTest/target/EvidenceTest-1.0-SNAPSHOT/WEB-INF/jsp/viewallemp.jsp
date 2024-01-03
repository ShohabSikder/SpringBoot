<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! All Emp</h1>

        <table>
            <thead>
                <tr>
                    <th>EMP ID</th>                
                    <th>Name</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="emp" items="${empList}">
                    <tr>
                        <td>${emp.emid}</td>                     
                        <td>${emp.name}</td> 
                        <td>${emp.department}</td> 
                        <td>${emp.salary}</td> 
                         
                        <td><a href="/empeditform/${emp.emid}">Edit</a> 
                            <a href="/deleteemp/${emp.emid}">Delete</a></td> 
                    </tr>                  

                </c:forEach>


            </tbody>

        </table>
    </body>
</html>
