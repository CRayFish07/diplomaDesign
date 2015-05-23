<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>办公室管理系统登录</title>
		<script type="text/javascript">
			function check(){
				var checkInput = document.getElementsByTagName("input");
				var i;
				for(i=0; i<checkInput.length; i++){
					if(checkInput[i].value == ""){
						alert(checkInput[i].name + " can't be null");
						return false;
					}
				}
				return true;
			}
		</script>
		
		<style type="text/css">
			div#log{   /*整体界面的背景设置*/
				background-color: #000080;
				height: 650px;  /*设置浏览器高度*/
				width: 1350px;	/*设置浏览器宽度*/
				margin: 0 auto; /*设置div居中显示*/
			}
			div#log_area{ /*中间登录部分的周围框架的表现*/
				background-color: #0000CD;
				width: 500px;
				height:300px;				
				position: absolute;
				margin-left: 400px;
				margin-top: 200px;
				
				box-shadow: 20px 10px 15px #2F4F4F;/*设置阴影*/
				border-radius: 20px;
			}
			div#log_input{ /*表单提交部分的页面表现*/
				position: absolute;
 				margin-left: 150px;
				margin-top: 50px;
			}
			
			input{ 
				border-radius: 5px;
			}
				
		</style>
		
	</head>
	<body>
		
		<div id="log">
			<div id="log_area">
				<h2 style="color: white; text-align: center;">办公室管理系统</h2>
				
				<div id="log_input">
					<div id="log_input_left">
						<!--<img src="img/lock.jpg"/>-->
					</div>
					<div id="log_input_right">
						<form action="log" onsubmit="return check()" method="post" id="log_form" style="color: white; font-family: '黑体';">
							用户名：<input type="text" name="name" id="name" />           						<br /><br />
							密码：&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password" />   	<br /><br />
							管理员： <input type="radio" name="radio" value="admin" />
							&nbsp;总经理:&nbsp;&nbsp;&nbsp;<input type="radio" name="radio" value="manager" />	<br/>
							部门经理:<input type="radio" name="radio" value="deptManager"/>
							&nbsp;普通职员:<input type="radio" name="radio" value="emp" checked="checked" /> 							<br />
							<input type="submit" value="登录" style="margin-left: 190px; font-family: '黑体';"/>
						</form>	
					</div>
				</div>
				
			</div>
		</div>
	</body>
</html>
