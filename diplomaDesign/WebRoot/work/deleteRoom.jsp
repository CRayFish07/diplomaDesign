<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

	<head>
		<title>删除房间</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />
		
		<script type="text/javascript" src="../javascript/checkInput.js"></script>

		<style type="text/css">
			body {
			            padding-bottom: 40px;
			        }
			        .sidebar-nav {
			            padding: 9px 0;
			        }
			
			        @media (max-width: 980px) {
			            /* Enable use of floated navbar text */
			            .navbar-text.pull-right {
			                float: none;
			                padding-left: 5px;
			                padding-right: 5px;
			            }
			        }
		</style>
	</head>

	<body>
		<form class="form-inline definewidth m20" action="selectRoomD" method="post">
			删除房间：
			<input type="text" name="name" id="rolename" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
			
		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<!--  
					<th>员工id</th>
					-->
					<th>房间名</th>
					<th>房间地址</th>
					<th>房间容量</th>
					<th>操作</th>
				</tr>
			</thead>
				<s:iterator value="roomList" var="list">
    			<tr>
    				<!-- 
    				<td><s:property value="#list.room_id"/></td>
    				 -->
    				<td><s:property value="#list.room_name"/></td>
    				<td><s:property value="#list.room_address"></s:property></td>
    				<td><s:property value="#list.room_capacity"></s:property></td>
    				<td><a href="deleteRoom?id=${list.room_id}" conclick="return deleteConfirm();">删除</a></td>
    			</tr>
    			</s:iterator>
		</table>
	</body>
</html>