<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="<c:url value='/css/Pub.css'/>"></link>
  	<script type="text/javascript" src="<c:url value='/js/login.js'/>"></script>
  	<script type="text/javascript">
  		var path = "<c:url value='/'/>";//项目的根/book
  	</script>
  	<style type="text/css">
  		table{
  			font-size:10pt;
  			width:330px;
  		}
  		.txt{
  			border:0px;
  			border-bottom:1px solid blue;
  			width:200px;
  		}
  		td{
  			padding:5px;
  		}
  	</style>
  </head>
  <body style="text-align:center;">
  		<br/><br/>
  		<form name="f1" method="post" action="${pageContext.request.contextPath}/user?action=login" onsubmit="return validate()" target="_parent">
  		<table>
			  <tr style="background:#7D7DFF;">
			  	<td colspan="2" align="center">
			  		用户登录
			  	</td>
			  </tr>
			  <tr>
			  	<td>
			  		姓名<font color="red">*</font>：
			  	</td>
			  	<td>
			  		<input class="txt" type="text" name="name"/>
			  	</td>
			  </tr>	
			   <tr>
			  	<td>
			  		密码<font color="red">*</font>：
			  	</td>
			  	<td>
			  		<input class="txt" type="password" name="password"/>
			  	</td>
			  </tr>	
			  <tr>
			  	<td>
			  		验证码<font color="red">*</font>：
			  	</td>
			  	<td>
			  		<input class="txt" type="text" style="width:100px;" name="code"/>
			  		<img id="imagecode" src="${pageContext.request.contextPath }/ImageCode" title="看不清，点击换一张！" onclick="changeCode()"></img>
			  	</td>
			  </tr>
			  <tr>
			  	<td id="msg" colspan="2" style="color:red;" align="center">
			  	</td>
			  </tr>
			  <tr>
			  	<td colspan="2" align="center">
			  		<input type="submit" class="OperBtn" value="登录" style="margin:5px;"/>
			  		<button class="OperBtn" style="margin:5px;">取消</button>
			  		<a href="${pageContext.request.contextPath }/jsp/front/user/reg.jsp">现在去注册一个新用户</a>
			  	</td>
			  </tr>	
  		</table>
  		</form>
  		
  		<script type="text/javascript">
  		function changeCode(){
  		 // window.document.write("changge");
  		  var code  =document.getElementById("imagecode");
  		code.src="${pageContext.request.contextPath }/ImageCode";
  		
  		}
  		
  		
  		</script>
  </body>
</html>
  		
