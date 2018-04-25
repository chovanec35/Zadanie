<%-- 
    Document   : test
    Created on : 25.4.2018, 13:42:41
    Author     : jchovanec
--%>

<%@page contentType="text/html" pageEncoding="windows-1250"%>
<!DOCTYPE html>
<html>
    <head>
        <TITLE>Crunchify - Spring MVC Example with AJAX call</TITLE>

        <style type="text/css">
            body {
                background-image:
                    url('https://cdn.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
            }
        </style>
        <script type="text/javascript"
        src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script type="text/javascript">
            function crunchifyAjax() {
                $.ajax({
                    url: 'ajaxtest.html',
                    success: function (data) {
                        $('#result').html(data);
                    }
                });
            }
        </script>

        <script type="text/javascript">
            var intervalId = 0;
            intervalId = setInterval(crunchifyAjax, 3000);
        </script>
    </head>

    <body>
        <div align="center">
            <br> <br> ${message} <br> <br>
            <div id="result"></div>
            <br>
            <p>
                by <a href="https://crunchify.com">Crunchify.com</a>
            </p>
        </div>
    </body>
</html>