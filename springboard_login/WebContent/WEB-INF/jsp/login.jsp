<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head> <!-- login 성공하면 main.do로 넘어감->main.do의 소스들을 수정하면 될듯?. -->
	<title> SringBoard</title>
	<script type="text/javascript"> 
		function doLogin() {
			if(frm.j_username.value == "") {
				alert("아이디를 입력해주세요.");
				return;
			}
			if(frm.j_password.value == "") {
				alert("패스워드를 입력해주세요.");
				return;
			}
			
			frm.submit();
		}
		
		function doJoin() {
			 location.href="writeForm.jsp"
		}
		
	</script>	
</head>
<body>
<table>
<form name="frm" action="j_spring_security_check" method="post">
<tr>
	<td> 아이디(이메일)</td>
	<td> <input type="text" name="j_username"> </td>
</tr>
<tr>
	<td> 패스워드</td>
	<td> <input type="password"  name="j_password"> </td>
</tr>
<tr>
	<td> <input type="button" value="로그인" onclick="doLogin()"> <td>
</tr>
<tr>
	<td> <input type="button" value="회원가입" onclick="doJoin()"> <td>
</tr>
</form>
</table>

</body>
</html>
