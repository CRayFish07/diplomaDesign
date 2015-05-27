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
		<form class="form-inline definewidth m20" action="selectEmployeeD" method="post">
			删除员工名称：
			<input type="text" name="name" id="rolename" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
		<br/><br/>
		<label style="color:red;">删除异常！</label>
	</body>
</html>