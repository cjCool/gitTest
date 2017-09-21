<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<body>
	<form >
		<label>用户名：</label>
		<br>
		<input type="text" name="username" id ="username">
		<input type="button" value="提交" onclick="login()">
	
	</form>
	<script type="text/javascript">
		function login(){
			alert($("#username").val());
			$.ajax({
				url:"${pageContext.request.contextPath}/user/findByUsernameAndPassword",
				type:"post",
				dataType:'json',
				data:'{"username":"'+$("#username").val()+'"}',
				contentType:"application/json;charset=utf-8",
				success:function(data){
					if(data.success){
						location.href="${pageContext.request.contextPath}/item/findByAll";
					}else{
						alert(data.message)
					}
				}
			})
		}
	</script>
</body>
</html>