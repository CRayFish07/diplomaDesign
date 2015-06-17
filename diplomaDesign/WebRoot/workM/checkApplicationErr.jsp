<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />
		<script type="text/javascript" src="../javascript/checkInput.js"></script>
		
	</head>

	<body>
		<form class="form-inline definewidth m20" action="selectApplication!checkApplicationByTime" method="get">
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
			<s:iterator value="applicationList" var="list">
			<tr>
				<td><s:property value="#list.application_start"/></td>
				<td><s:property value="#list.application_end"/></td>
				<td><s:property value="#list.application_remarks"/></td>
				<td><s:property value="#list.application_time"/></td>
				<td><s:property value="#list.log_name"/></td>
				<td>
					<a href="addMeeting?id=${list.application_id}" onclick="return passConfirm();">通过</a>
				</td>
			</tr>
			</s:iterator>
		</table>
	 <label style="color:red;">您查询的数据异常，或者输入的数据异常</label>
	</body>
</html>
