<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />
		
	</head>

	<body>
		<form class="form-inline definewidth m20" action="index.html" method="get">
			申请记录：
			<input type="text" name="rolename" id="rolename" class="abc input-default" placeholder="请输入查询时间" value="">
			<button type="submit" class="btn btn-primary">查询</button>
		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>会议主题</th>
					<th>申请时间</th>
					<th>申请人员</th>
					<th>操作</th>
				</tr>
			</thead>
			<tr>
				<td>5</td>
				<td>1</td>
				<td>管理员</td>
				<td>1</td>
				<td>tanoya</td>
				<td>
					<a href="addMeeting?id=${list.application_id}">通过</a>
				</td>
			</tr>
		</table>
	 <label style="color:red;">您查询的数据异常，或者输入的数据异常</label>
	</body>
</html>
