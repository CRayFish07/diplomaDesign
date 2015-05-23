<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改房间信息</title>
	</head>
	<body>
		<form action="updateRoom" method="post">
			房间id：&nbsp;<input type="text" name="id" /> <br /><br />
			房间名： &nbsp;<input type="text" name="name" /><br /><br />
			房间地址： <input type="text" name="address" /><br /><br />
			房间容量： <input type="text" name="capacity" /><br /><br />
			<input type="submit" value="修改"/>
		</form>
	</body>
</html>
