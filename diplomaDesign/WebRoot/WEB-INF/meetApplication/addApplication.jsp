<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>提交会议预约申请</title>
	</head>
	<body>
		<form action="addApplication" method="post">
			开始时间：<input type="text" name="start" />				<br /><br />
			结束时间：<input type="text" name="end" />	 			<br /><br />
			
			<!-- 如何将备注变成多行输入的形式？？ -->
			备注：&nbsp;&nbsp;<input type="text" name="remarks" />	<br /><br />
			申请人员: <input type="text" name="username" />         <br/><br/>
			<input type="submit" value="申请"/>
		</form>
	</body>
</html>

