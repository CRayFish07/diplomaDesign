<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>

	<head>
		<title>员工查询会议界面</title>
		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />
		
	</head>

	<body>
		<form class="form-inline definewidth m20" action="selectMeeing!getMeetingInfoList" method="get"> 
			查询部门会议： 
			<input type="text" name="rolename" id="rolename" class="abc input-default" placeholder="查询部门会议" value="">&nbsp;&nbsp;
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
			<s:iterator value="meetingList" var="list">
			<tr>
				<td><s:property value="#list.meeting_name"/></td>
				<td><s:property value="#list.meeting_start"/></td>
				<td><s:property value="#list.meeting_end"/></td>
				<td><s:property value="#list.meeting_order_time"/></td>
			</tr>
			</s:iterator>
		</table>
	</body>

</html>