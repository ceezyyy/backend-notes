<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quickstart</title>

    <script src="js/jquery-3.5.1.min.js"></script>

    <script>
        $(function () {
            $("button").click(function(){
                $.ajax({
                    url: "user/testAjax",
                    dataType: "json",
                    contentType:"application/json; charset=utf-8",
                    data: JSON.stringify({
                        "name":"LBJ",
                        "age":22,
                        "city":"LA"
                    }),
                    type: "POST",
                    // A function to be run when the request succeeds
                    success: function(data){
                        alert(data.name);
                        alert(data.age);
                        alert(data.city);
                    }
                });
            });
        })
    </script>
</head>
<body>
<h1>Index</h1>
<button id="button">CLICK ME!</button>
</body>
</html>
