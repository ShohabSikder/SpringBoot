<%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    </head>
    <body>
        <h1>Hello World!</h1>


    <f:form method="post" action="/stusave"  modelAttribute="student">
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
                    <input  type="submit" value="Save"/>
                </td>
            </tr>

        </table>
    </f:form>




</body>


</html>
