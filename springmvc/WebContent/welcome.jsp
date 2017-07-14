<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@ include file="/common/header.jsp"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.0.js"></script>	
<title>Insert title here</title>
<script type="text/javascript">

function diao(){
	$.ajax({
		  url: "wel/getUserInfo",
		  async: false,
		  type:"post",
		  data:"id=1",
		  success: function(data){
		    console.log(data);
		  }
		});
}
</script>
</head>
<body>
welcome
<input type="button" onclick="diao()" />
</body>
</html>