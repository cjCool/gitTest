<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function(){
		
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath }/item/findJson.action",
			contentType:"application/json;charset=utf-8",
			//typeData:'json',
			data:'{"name":"测试商品","price":99.9}',
			success:function(data){
				alert(JSON.stringify(data));
			}
			
		})
	})
</script>

</body>
</html>