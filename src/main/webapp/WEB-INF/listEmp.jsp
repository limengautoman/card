<%@page pageEncoding="utf-8"
contentType="text/html;charset=utf-8"%>
<%@page import="dao.*,entity.*,java.util.*,java.text.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>工作证管理系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
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
						欢迎
					</h1>
					<table class="table">
						<tr class="table_header">
						    
							<td>
								姓名
							</td>
							<td>
								性别
							</td>
							<td>
								年龄
							</td>
							<td>
								单位
							</td>
							<td>
								职务
							</td>
							<td>
								出发站
							</td>
							<td>
								终到站
							</td>
							<td>
								工作证号
							</td>
							<td>
								身份证
							</td>
							<td>
								乘车证号
							</td>
							<td>
								操作
							</td>
						</tr>
					    <%
					   //强转
	List<Card> employees= (List<Card>)request.getAttribute("employees");
					  for(int i=0;i<employees.size();i++){
						  Card e=employees.get(i);
						  %>
						  <tr class="row1<%=i%2+1 %>">
						     
							<td>
								<%=e.getName() %>
							</td>
							<td>
								<%=e.getSex() %>
							</td>
							<td>
							    <%=e.getAge() %>
							</td>
							<td>
								<%=e.getDept() %>
							</td>
							<td>
								<%=e.getJob() %>
							</td>
							<td>
								<%=e.getFrom() %>
							</td>
							<td>
							   <%=e.getTo() %>
							</td>
							<td>
								<%=e.getJobId() %>
							</td>
							<td>
								<%=e.getIdNo() %>
							</td>
							<td>
							<%=e.getCardId() %>
							</td>
							
							<td>
								<a href="del.do?id=<%=e.getId()%>"onclick="return confirm('确定删除<%=e.getName()%>吗？');">删除</a>&nbsp;
								<a href="load.do?id=<%=e.getId()%>">修改</a>
							</td>
						</tr>
						  <%  
						  
					  }
					  %>
					   
						
					</table>
					<p>
						<input type="button" class="button" value="增加员工" onclick="location='toAdd.do'"/>
					</p>
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
