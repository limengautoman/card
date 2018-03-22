package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDao;
import entity.Card;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request,
HttpServletResponse response)throws ServletException,IOException{
		 request.setCharacterEncoding("utf-8");
    	 response.setContentType("text/html;charset=utf-8");
    	 PrintWriter out = response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("action:"+action);
		if("/list".equals(action)){
			
        	 //获取输出流
        	//  PrintWriter out=response.getWriter();
        	  String id=request.getParameter("id");
        	  System.out.println(id);
        	  CardDao dao=new CardDao();
        	  //Employee e=new Employee();
        	  try{
        		  List<Card> employees=dao.findAll(); 
        		  //输出表格
        		  //因为servlet不擅长生成页面，我们转发给jsp生成页面
        		  //给jsp生成页面
        		  //step1 将处理结果绑定到request
        		  request.setAttribute("employees", employees);
        		  //step2.获得转发器
         RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/listEmp.jsp");
                 //step3 开始转发
                  rd.forward(request,response);
                  
                  
        		  
        	  }
        	   catch(Exception e1){
        		   
        		   e1.printStackTrace();
        		   out.println("系统繁忙,稍后重试");
        	   }
        	  out.close();
        	  
			
			///////////
		}else if("/toAdd".equals(action)){
			request.getRequestDispatcher("/WEB-INF/addEmp.jsp").forward(request, response);
			
			
			
			
			
			
		}
		else if("/emp".equals(action)){
			
			
			
			
			String name = 
					request.getParameter("name");
			//System.out.println("name:" + name);
			String sex=request.getParameter("sex");
			String age=request.getParameter("age");
			String dept=request.getParameter("dept");
			String job=request.getParameter("job");
			String from=request.getParameter("from");
			String to=request.getParameter("to");
			String jobId=request.getParameter("jobId");
			String idNo=request.getParameter("idNo");
			String cardId=request.getParameter("cardId");
			
			//将员工信息插入数据库
			CardDao dao=new CardDao();
			Card e=new Card(); 
			e.setName(name);
			e.setSex(sex);
			e.setAge(Integer.parseInt(age));
			e.setDept(dept);
			e.setJob(job);
			e.setFrom(from);
			e.setTo(to);
			e.setJobId(jobId);
			e.setIdNo(idNo);
			e.setCardId(cardId);
			try{
				dao.save(e);
				//out.println("插入成功");
			    response.sendRedirect("list.do");
				
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("系统繁忙,稍后重试");
				
			}
			

			
			
			//out.print(name);
			//out.print(salary);
			//out.print(age);
			//System.out.println(name);
			//System.out.println(salary);
	       // System.out.println(age);
			out.close();
			
			
		}
		else if("/del".equals(action)){
			String id=request.getParameter("id");
			CardDao dao=new CardDao();
			try{
			dao.delete(Integer.parseInt(id));
			response.sendRedirect("list.do");
			}
			catch(Exception e){
				e.printStackTrace();
				out.println("系统异常,稍后重试");
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
		}
		else if("/load".equals(action)){
			 String id=request.getParameter("id");
		       //依据员工ID 访问数据库
		      CardDao dao=new CardDao();
		      try{
		      Card e= dao.findById(Integer.parseInt(id));
		      //依据查询到的员工信息输出表单
		      request.setAttribute("e", e);
		      request.getRequestDispatcher("/WEB-INF/updateEmp.jsp").forward(request, response);
		      
		      }
		      catch(Exception e){
		    	  e.printStackTrace();
		    	  out.println("系统繁忙,稍后重试");
		    	  
		      }
		
			
			
			
			
			
			
		}
		else if("/modify".equals(action)){
			String id=request.getParameter("id");
			System.out.println(id);
			String name=request.getParameter("name");
			System.out.println(name);
			String sex=request.getParameter("sex");
			
			String age=request.getParameter("age");
			
			String dept=request.getParameter("dept");
			String job=request.getParameter("job");
			String from=request.getParameter("from");
			String to=request.getParameter("to");
			String jobId=request.getParameter("jobId");
			String idNo=request.getParameter("idNo");
			String cardId=request.getParameter("cardId");
			//访问数据库
			CardDao dao=new CardDao();
			Card e=new Card();
			//e.setId(Integer.parseInt(id));
			e.setName(name);
			//e.setSalary(Double.parseDouble(salary));
			e.setSex(sex);
			e.setAge(Integer.parseInt(age));
			e.setDept(dept);
			e.setJob(job);
			e.setFrom(from);
			e.setTo(to);
			e.setJobId(jobId);
			e.setIdNo(idNo);
			e.setCardId(cardId);
			e.setId(Integer.parseInt(id));
			try{
			 dao.modify(e);
			 response.sendRedirect("list.do");
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("系统异常,稍后重试");
				
				
			}
			
			
			
			
		}
		
	}

}
