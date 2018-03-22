package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Card;
import util.DBUtil;

public class CardDao {
	
		public void save(Card e){
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="INSERT INTO card Values(card_seq.nextval"
						+ ",?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, e.getName());
				ps.setString(2, e.getSex());
				ps.setInt(3, e.getAge());
				ps.setString(4, e.getDept());
				ps.setString(5, e.getJob());
				ps.setString(6, e.getFrom());
				ps.setString(7, e.getTo());
				ps.setString(8, e.getJobId());
				ps.setString(9, e.getIdNo());
				ps.setString(10, e.getCardId());
				ps.executeUpdate();
				
			} catch (SQLException e1) {
				//1.记日志
				e1.printStackTrace();
				/*2.看异常能否恢复，如果能够恢复则立即恢复，如果不能恢复（比如数据库服务暂停
				 * 一般将这样的异常称之为系统异常），则提示用户稍后重试
				 * */
				throw new RuntimeException(e1);
			}finally{
				DBUtil.close(conn);
				
			}
			
			
			
		}
		public List<Card> findAll(){
			List<Card> employees=new ArrayList<Card>();
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="Select * from card";
				PreparedStatement ps=conn.prepareStatement(sql);
				//获取结果集
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Card e=new Card();
					
					e.setName(rs.getString("姓名"));
					e.setSex(rs.getString("性别"));
				    e.setAge(rs.getInt("年龄"));
				    e.setDept(rs.getString("单位"));
				    e.setJob(rs.getString("职务"));
				    e.setFrom(rs.getString("出发站"));
				    e.setTo(rs.getString("终到站"));
				    e.setJobId(rs.getString("工作证号"));
				    e.setIdNo(rs.getString("身份证号"));
				    e.setCardId(rs.getString("乘车证号"));
				    e.setId(rs.getInt("id"));
					employees.add(e);
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				  DBUtil.close(conn);
				
				
			}
			
			
			return employees;
		}
		public void delete(int id){
			
			
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="DELETE FROM card where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,id);
				ps.executeUpdate();
			} catch (SQLException e1) {
			//先记日志
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}finally{
				DBUtil.close(conn);
				
			}
			
			
			
		}
		public Card findById(int id){
			Card e=null;
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="SELECT * from card where id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
				    e=new Card();
				    e.setName(rs.getString("姓名"));
					e.setSex(rs.getString("性别"));
				    e.setAge(rs.getInt("年龄"));
				    e.setDept(rs.getString("单位"));
				    e.setJob(rs.getString("职务"));
				    e.setFrom(rs.getString("出发站"));
				    e.setTo(rs.getString("终到站"));
				    e.setJobId(rs.getString("工作证号"));
				    e.setIdNo(rs.getString("身份证号"));
				    e.setCardId(rs.getString("乘车证号"));
				    //////////////////////////修改
				    e.setId(rs.getInt("id"));
					
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
				throw new RuntimeException(e1);
				
			}finally {
				
				DBUtil.close(conn);
			}
			return e;
			
			
			
			
			
			
		
		}
		public void modify(Card e){
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
		String sql="UPDATE card set 姓名=?,性别=?,年龄=?,单位=?,职务=?"
				+ ",出发站=?,终到站=?,工作证号=?,身份证号=?,乘车证号=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, e.getName());
		System.out.println(e.getName());
		ps.setString(2, e.getSex());
		ps.setInt(3, e.getAge());
		ps.setString(4, e.getDept());
		ps.setString(5, e.getJob());
		ps.setString(6, e.getFrom());
		ps.setString(7, e.getTo());
		ps.setString(8, e.getJobId());
		ps.setString(9, e.getIdNo());
		ps.setString(10, e.getCardId());
		ps.setInt(11, e.getId());
		System.out.println(e.getId());
		
		ps.executeUpdate();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
				throw new RuntimeException(e1);
				
			}finally{
				DBUtil.close(conn);
			}
			
			
			
			
		}

	}

	

