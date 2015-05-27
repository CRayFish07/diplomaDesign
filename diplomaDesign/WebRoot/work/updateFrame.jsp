<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改员工信息</title>

<script type="text/javascript" src="js/jquery.min.js"></script>

<link rel="stylesheet" href="../css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
	<form action="updateEmployee" method="post">
		<div class="control-group">
			<label class="laber_from">姓名</label>
			<div  class="controls" ><input class="input_from" type="text" placeholder=" 请输入用户名" name="name" value="${employee.emp_name}"><p class=help-block></p></div>
		</div>
		<div class="control-group">
			<label class="laber_from">性别</label>
			<div class="controls">
				<select class="input_select" name="sex">
					<option selected="selected">男</option>
					<option>女</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">手机</label>
			<div class="controls">
				<input class="input_from" type="text" placeholder="请输入手机号码" name="phone" value="${employee.emp_phone_number }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">QQ</label>
			<div class="controls">
				<input type="text" name="QQ" class="input_from" placeholder="请输入QQ密码" value="${employee.emp_QQ }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">公司</label>
			<div class="controls">
				<input type="text" name="company" class="input_from" placeholder="请输入公司名称" value="${employee.emp_company }" />
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">Email</label>
			<div class="controls">
				<input type="text" name="email" class="input_from" placeholder="请输入Email" value="${employee.emp_email }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">住址</label>
			<div class="controls">
				<input type="text" name="address"  class="input_from" placeholder="请输入住址" value="${employee.emp_address }"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">部门</label>
			<div class="controls">
				<select name="department" class="input_select">
					<option value="1">研发部</option>        <!-- value中的值代表研发部 中的代码-->
	  				<option value="2">技术支持部</option>
	  				<option value="3">产品部</option>
	  				<option value="4">营销部</option>
	  				<option value="5">后勤部</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">职务</label>
			<div class="controls">
				<select class="input_select" name="position">
					<option value="1">总经理</option>
					<option value="5">部门经理</option>      <!-- value中的值代表数据库中的部门经理的代码 -->
	  				<option value="9">普通职员</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<input class="laber_from" value="${employee.emp_id}" name="id" style="display: none;"/>
		</div>
		<div class="control-group">
			<label class="laber_from"></label>
			<div class="controls">
				<button  class="btn btn-success" style="width:100px;" >修改</button>
				<button  class="btn btn-success" style="width:100px;" >取消</button>
			</div>
		</div>
	</form>
	
</div>
</body>
</html>