<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>   

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

    <f:form method="post" action="/editstusave"  modelAttribute="student">

        <f:hidden  path="sid" />
        <table class="table table-striped">
            <tr>
                <td>
                    Roll
                </td>
                <td>                        
            <f:input path="roll"></f:input>
            </td>
            </tr>

            <tr>
                <td>
                    Name
                </td>
                <td>                        
            <f:input path="name"></f:input>
            </td>
            </tr>

            <tr>
                <td>
                    Department
                </td>
                <td>                        
                    <select name="department">
                        <option value="DDD">DDD</option>
                        <option value="JAVA">JAVA 2</option>
                        <option value="GAVE">GAVE</option>
                        <!-- Add more options as needed -->
                    </select>
                </td>
            </tr>

            <tr>
                <td>
                    Marks
                </td>
                <td>                        
            <f:input path="marks"></f:input>
            </td>
            </tr>
            <tr>
                <td>                      
                    <input  type="submit" value="Update"/>
                </td>
            </tr>

        </table>
    </f:form>


</body>
</html>
