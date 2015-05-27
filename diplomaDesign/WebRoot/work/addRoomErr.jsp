<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加房间</title>

<script type="text/javascript" src="js/jquery.min.js"></script>

<link rel="stylesheet" href="../css/add.css" type="text/css" media="screen" />
<link rel="stylesheet" href="../utilLib/bootstrap.min.css" type="text/css" media="screen" />

</head>
<body>
<div class="div_from_aoto" style="width: 500px;">
	<form action="addRoom" method="post">
		<div class="control-group">
			<label class="laber_from">房间号</label>
			<div  class="controls" ><input class="input_from" type="text" placeholder=" 请输入房间号" name="name"><p class=help-block></p></div>
		</div>
		<div class="control-group">
			<label class="laber_from">房间地址</label>
			<div class="controls">
				<input class="input_from" type="text" placeholder="请输入房间地址" name="address"/>
			</div>
		</div>
		<div class="control-group">
			<label class="laber_from">房间容量</label>
			<div class="controls">
				<input type="text" name="capacity" class="input_from" placeholder="请输入房间容量" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="laber_from"></label>
			<div class="controls">
				<button  class="btn btn-success" style="width:100px;" >提交</button>
				<button  class="btn btn-success" style="width:100px;" >取消</button>
			</div>
		</div>
	</form>
	
	<label style="color:red;">增加房间异常</label>
</div>
</body>
</html>