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
                    <th>ID</th>
                    <th>Roll</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Marks</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="stu" items="${stuList}">
                    <tr>
                        <td>${stu.sid}</td> 
                        <td>${stu.roll}</td> 
                        <td>${stu.name}</td> 
                        <td>${stu.department}</td> 
                        <td>${stu.marks}</td> 
                         
                        <td><a href="/empeditform/${stu.sid}">Edit</a> 
                            <a href="/deleteemp/${stu.sid}">Delete</a></td> 
                    </tr>                  

                </c:forEach>


            </tbody>

        </table>
    </body>
</html>
