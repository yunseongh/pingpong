<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title> SringBoard</title>
	<script type="text/javascript"> 
		function doSubmit() {
			if(boardFrm.id.value == "") {
				alert("아이디를 입력해주세요.");
				return;
			}
			if(boardFrm.pw.value == "") {
				alert("비밀번호을 입력해주세요.");
				return;
			}
			if(boardFrm.name.value == "") {
				alert("이름을 입력해주세요.");
				return;
			}
			
			boardFrm.submit()
		}
		
	</script>

</head>
<table border="1" width="600px" >
<form name="boardFrm" action="writeProc.do" method="post">
<tr>
	<td height="30" width="10%" bgcolor="#dddddd" align="center">
		아이디
	</td>
	<td align="left" height="30">				
		<input type="text" size="80" maxLength="150" name="id">
	</td>
</tr>
<tr>
	<td height="30" bgcolor="#dddddd" align="center">
		비밀번호
	</td>
	<td>
		<input type="text" size="80" maxLength="150" name="pw"></textarea><br/><br/>
	</td>	
</tr>
<tr>
	<td height="30" bgcolor="#dddddd" align="center">
		이름
	</td>
	<td>
		<input type="text" size="80" maxLength="150" name="name"></textarea><br/><br/>
	</td>	
</tr>
<tr>
	<td height="30" bgcolor="#dddddd" align="center">
		전공
	</td>
	<td>
		<input type="text" size="80" maxLength="150" name="major"></textarea><br/><br/>
	</td>	
</tr>
<tr>
	<td height="30" bgcolor="#dddddd" align="center">
		학교
	</td>
	<td>
		<input type="text" size="80" maxLength="150" name="school"></textarea><br/><br/>
	</td>	
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="button" value="전송" onclick="doSubmit()">
	</td>
</tr>
</form>
</table>
</html>