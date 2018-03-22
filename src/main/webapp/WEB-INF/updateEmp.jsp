<%@page pageEncoding="utf-8"
contentType="text/html; charset=utf-8"%>
<%@page import="dao.*,entity.*,java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%
							Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				out.print(sdf.format(date))	;		
							
							
							%>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">工作证管理系统</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						修改员工:
					</h1>
					<% 
					//强转 
					Card e=(Card)request.getAttribute("e");
					
					
					%>
					<form action="modify.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name"
									 value="<%=e.getName()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="sex"
									 value="<%=e.getSex()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri"
									 name="age" value="<%=e.getAge()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									单位:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="dept" 
									value="<%=e.getDept()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									职务:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="job"
									 value="<%=e.getJob()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									出发站:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="from"
									 value="<%=e.getFrom()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									终到站:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri"
									 name="to" value="<%=e.getTo()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工作证号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="jobId" 
									value="<%=e.getJobId()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									身份证号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri"
									 name="idNo" value="<%=e.getIdNo()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									乘车证号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="cardId" 
									value="<%=e.getCardId()%>"/>
								</td>
							</tr>
						</table>
						<!-- 隐藏域 -->
						<input type="hidden" name="id" value="<%=e.getId()%>"/>
						<p>
							<input type="submit" class="button" value="确定" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					邮箱:limeng365@163.com &nbsp &nbsp &nbsp &nbsp 电话:15901300678
				</div>
			</div>
		</div>
	</body>
</html>
