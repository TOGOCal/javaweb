package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//使用RreparedStatement
/**
 * 好处：
 * 1.在创建时就会预编译
 * 2.防止sql注入，他会在传进来的参数外面添加 '',有效防止注入攻击
 * 方法：将其中所有'转义为了普通字符（加上/
 * 3.性能提升，可以重复多次使用这个
 */
public class jdbc3 {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "Yilaikesi1@");

        // 3.获取执行的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_emp where emp_name = ?");

        System.out.println("请输入员工姓名：");
        String name = s.nextLine();

        // 4.为'?'占位符赋值，执行sql语句，获取返回的结果
        preparedStatement.setString(1, name);// 这里的前面的数字代表要set第几个问号占位符，因为是第几个，所以是从1开始的
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            Double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        s.close();
    }
}
