<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>增加房间</title>
	</head>
	<body>
		<form action="addRoom" method="post">
		房间号：&nbsp;<input type="text" name="name" id="name"  /> <br /><br />
		房间地址：<input type="text" name="address" id="address" /><br /><br />
		房间容量：<input type="text" name="capacity" id="capacity" /><br /><br />
			<input type="submit" value="增加"/>
		</form>
	</body>
</html>
