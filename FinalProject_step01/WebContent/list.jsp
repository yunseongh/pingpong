<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="pingpong.model.PingPongBean" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String major = request.getParameter("major");
			String school = request.getParameter("school");
-->

<%
 	PingPongBean [] list=(PingPongBean[])request.getAttribute("list");
 %>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">ID(Email)</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">name</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">major</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">school</span></b></font></p>
        </td>
    </tr>
    
 <c:if test="${requestScope.list == null || fn:length(requestScope.list) == 0}">
	<tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 회원이 없습니다.</span></b></p>
        </td>
    </tr>
</c:if>

<c:forEach items="${requestScope.list}" var="data">
		<tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${data.email}</span></p>
		        </td>
		        <td bgcolor="">
					 <p align="center"><span style="font-size:9pt;">
		            ${data.name}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
						<a href="mailto: ${data.email}">
						${data.major}</a>
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${data.school}</span></p>
		        </td>
		    </tr>
</c:forEach>

    <tr>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;"></span></p>
        </td>
        <td bgcolor="">
			<p><span style="font-size:9pt;"><a href="ReadAContent.jsp?num= "></a></span></p>
        </td>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;">
				<a href="mailto:"></a>
			</span></p>
        </td>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;"></span></p>
        </td>
        <td bgcolor="">
            <p align="center"><span style="font-size:9pt;"></span></p>
        </td>
    </tr>

</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="LoginView.html">가입하기</a>&gt;</span></div>

