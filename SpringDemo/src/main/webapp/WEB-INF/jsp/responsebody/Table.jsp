<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<table>  
    <tr>  
        <td>id</td>  
        <td><input id="id" /></td>  
    </tr>  
    <tr>  
        <td>name</td>  
        <td><input id="name" /></td>  
    </tr>  
    <tr>  
        <td>birthday</td>  
        <td><input id="birthday" /></td>  
    </tr>  
    <tr>  
        <td><input type="button" id="profile" value="Profile——GET" /></td>  
        <td><input type="button" id="login" value="Login——POST" /></td>  
    </tr>  
</table>  
<script>
$(document).ready(function() {  
    $("#profile").click(function() {  
        profile();  
    });  
    $("#login").click(function() {  
        login();  
    });  
});  
function profile() {  
    var url = 'http://localhost:8080/${pageContext.request.contextPath}/integrate/user/';  
    var query = $('#id').val() + '/' + $('#name').val() + '/'  
            + $('#birthday').val();  
    url += query;  
    alert(url);  
    $.get(url, function(data) {  
        alert("id: " + data.id + "\nname: " + data.name + "\nbirthday: "  
                + data.birthday);  
    });  
}  
function login() {  
    var mydata = '{"name":"' + $('#name').val() + '","id":"'  
            + $('#id').val() + '","birthday":"' + $('#birthday').val() + '"}';  
    alert(mydata);  
    $.ajax({  
        type : 'POST',  
        contentType : 'application/json',  
        url : 'http://localhost:8080/${pageContext.request.contextPath}/integrate/user',  
        processData : false,  
        dataType : 'json',  
        data : mydata,  
        success : function(data) {  
            alert("id: " + data.id + "\nname: " + data.name + "\nbirthday: "  
                    + data.birthday);  
        },  
        error : function() {  
            alert('Err...');  
        }  
    });  
}
</script>
</body>
</html>