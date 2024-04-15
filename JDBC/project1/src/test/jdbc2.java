package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//演示sql注入问题
public class jdbc2 {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String username = "root";
        String password = "Yilaikesi1@";

        Connection connection = DriverManager.getConnection(url, username, password);

        // 3.获取执行sql语句的对象
        Statement statement = connection.createStatement();

        // 4.编写sql语句，并执行，接收返回的结果
        // String sql = "select * from t_emp where emp_name='康师傅'";原来的命令
        System.out.println("请输入要查询的员工姓名:");
        String sql = ("select * from t_emp where emp_name='" + s.nextLine() + "'");

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            Double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        // 演示注入攻击问题：
        sql = ("select * from t_emp where emp_name='" + s.nextLine() + "'");
        // select * from t_emp where emp_name=' abc' or '1' = '1 '
        // 输入这个：abc' or '1' = '1就会触发结果恒为true导致输出全部结果

        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            Double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        resultSet.close();
        statement.close();
        connection.close();
        s.close();
    }
}
