package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class jdbc1 {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 在我们jdk21的里面已经不需要这些东西了

        // 2.获取连接对象
        String url = "jdbc:mysql://localhost:3306/atguigu";
        // 前面的是固定格式，最后的那一个单词是数据库名称
        String username = "root";
        String password = "Yilaikesi1@";

        Connection connection = DriverManager.getConnection(url, username, password);

        // 3.获取一个获取SQL语句的对象
        Statement statement = connection.createStatement();
        // 使得能够发送sql语句到数据库，并得到结果

        // 4.编写sql语句，并执行，接收返回的结果集
        String sql = "select * from t_emp";
        ResultSet resultSet = statement.executeQuery(sql);// 返回值为一个结果集（将这张虚拟表存在这里了

        // 5.处理结果：遍历resultSet 结果集
        // result.next();返回值为布尔类型变量，表示还有没有下一行
        while (resultSet.next()) {

            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            Double empSalary = resultSet.getDouble("emp_salary");
            int empAge = resultSet.getInt("emp_age");

            System.out.println(empId + "\t" + empName + "\t" + empSalary + "\t" + empAge);
        }

        // 6.资源的释放（先开后关）
        resultSet.close();
        statement.close();
        connection.close();
    }
}
