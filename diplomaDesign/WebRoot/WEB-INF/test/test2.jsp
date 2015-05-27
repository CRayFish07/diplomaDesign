<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <body>
    查询出现异常 <br>
    <p>hello, world</p>
    <table>
    <s:iterator value="employeeList" var="list">
    	<tr>
    		<td><s:property value="#list.emp_id"/></td>
    		<td><s:property value="#list.emp_name"/></td>
    	</tr>
    </s:iterator>
    </table>
    
  </body>
</html>
