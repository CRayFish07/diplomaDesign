<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
    <form action="updateEmployee" method="post">
              姓名：<input type="text" name="name"/><br/>
	    性别：<input type="radio" name="sex" value="男" checked="checked"/>男<input type="radio" name="sex" value="女"/>女<br/>
	    手机：<input type="text" name="phone"/><br/> 
	  QQ:&nbsp;&nbsp; <input type="text" name="QQ"/><br>
	  公司: <input type="text" name="company"/><br/>
	  email:<input type="text" name="email"/><br/>
	    住址：<input type="text" name="address"/><br>
	    部门：<select name="department">
	  			<option value="1">研发部</option>        <!-- value中的值代表研发部 中的代码-->
	  			<option value="2">技术支持部</option>
	  			<option value="3">产品部</option>
	  			<option value="4">营销部</option>
	  			<option value="5">后勤部</option>
	  	  </select><br/> 
	     职务:&nbsp;<select name="position">
	  			<option value="5">部门经理</option>      <!-- value中的值代表数据库中的部门经理的代码 -->
	  			<option value="9">普通职员</option>
	  	</select><br/>
	  id：<input type="text" name="id"/> <br/>
	  <input type="submit" value="修改"/>
    </form>
  </body>
</html>
