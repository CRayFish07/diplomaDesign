<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>办公室管理系统登录</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">

<!--必要样式-->
<link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

</head>
<body>

<section class="login-form-wrap">
  <h1>办公司管理系统</h1>
  <form action="log" class="login-form" method="post">
	  <label><input type="name" name="name" required placeholder="用户名"></label>
	  <label><input type="password" name="password" required placeholder="密码"></label>
	  <label>管理员<input type="radio" name="radio" value="admin"/>
	  		总经理<input type="radio" name="radio" value="manager"/>
	  </label>
	  <br />
	  <label>
	  		部门经理<input type="radio" name="radio" value="deptManager"/>
	  		普通员工<input type="radio" name="radio"  checked="checked" value="emp"/>
	  </label>
	  <input type="submit" value="登录">
  </form>
 <!-- <h5><a href="#">忘记密码</a></h5> -->
  <br/>
  <label style="color:red;">用户名或密码填写错误！</label>
</section>

</body>
</html>
