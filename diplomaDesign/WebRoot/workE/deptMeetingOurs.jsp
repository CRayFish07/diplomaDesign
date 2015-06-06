<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title>员工查询会议界面</title>
		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />
		
	</head>

	<body>
		<form class="form-inline definewidth m20" action="index.html" method="get">
			自己参加的会议：
			<input type="text" name="rolename" id="rolename" class="abc input-default" placeholder="自己参加的会议" value="">&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>会议主题</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>申请时间</th>
				</tr>
			</thead>
			<tr>
				<td>5</td>
				<td>管理员</td>
				<td>1</td>
				<td>time</td>
			</tr>
		</table>
	</body>

</html>