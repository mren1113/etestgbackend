<%-- 
    Document   : LoginTest
    Created on : Sep 16, 2020, 1:41:13 PM
    Author     : ru-com7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etest Test form</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    </head>
    <body>
        <h1>Test!</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <form method="post" action="/etestgbackend/TestForm">
                        <div class="form-group">
                            <label for="exampleInputPassword1">student code </label>
                            <input type="text" class="form-control" id="exampleInputPassword1" name="stdcode" required="true" maxlength="10">
                        </div> 
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>

        </div>

    </body>
</html>
