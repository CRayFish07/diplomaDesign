<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

	<head>
		<title></title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="../js/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="../js/style.css" />

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
		<form class="form-inline definewidth m20" action="selectEmployeeU" method="post">
			修改员工姓名：
			<input type="text" name="name" id="rolename" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
			
		</form>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<!--  
					<th>员工id</th>
					-->
					<th>员工名字</th>
					<th>性别</th>
					<th>电话</th>
					<th>QQ</th>
					<th>公司</th>
					<th>邮箱</th>
					<th>地址</th>
					<th>职位</th>
					<th>部门</th>
					<th>操作</th>
				</tr>
			</thead>
				<s:iterator value="employeeList" var="list">
    			<tr>
    				<!-- 
    				<td><s:property value="#list.emp_id"/></td>
    				 -->
    				<td><s:property value="#list.emp_name"/></td>
    				<td><s:property value="#list.emp_sex"></s:property></td>
    				<td><s:property value="#list.emp_phone_number"></s:property></td>
    				<td><s:property value="#list.emp_QQ"></s:property></td>
    				<td><s:property value="#list.emp_company"></s:property></td>
    				<td><s:property value="#list.emp_email"></s:property></td>
    				<td><s:property value="#list.emp_address"></s:property></td>
    				<td><s:property value="#list.emp_authority"></s:property></td>
    				<td><s:property value="#list.emp_dept_id"></s:property></td>
    				<td><a href="selectEmployeeById?id=${list.emp_id}">修改</a></td>
    			</tr>
    			</s:iterator>
		</table>
	</body>
</html>