<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

	<head>
		<title></title>
		<meta charset="UTF-8">

		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />
		<link rel="stylesheet" href="../css/add.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="../utilLib/bootstrap.min.css" type="text/css" media="screen" />
		
	</head>

	<body>
		<form class="form-inline definewidth m20" action="selectApplication" method="post" >
			<div class="control-group" >
				<label class="laber_from" >申请状态：</label>
				<div class="controls" >
					<select class="input_select" name="status">
						<option selected="selected" value="0">未审批</option>
						<option value="1">审批通过</option>
						<option value="2">无会议室</option>
						<option value="3">禁止会议</option>
					</select>
					&nbsp;&nbsp;<button type="submit" class="btn btn-primary" >查询</button>
				</div>
			</div>
		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>会议主题</th>
					<th>申请时间</th>
					<th>申请人</th>
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
					<a href="????">撤销</a>
				</td>
			</tr>
			</s:iterator>
		</table>
	
	</body>

</html>