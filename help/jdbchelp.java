
import java.util.Scanner;

public class jdbchelp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        boolean key = true;

        while (key) {

            menu.menu1();

            char function1 = s.nextLine().charAt(0);

            char function2 = 0;

            switch (function1) {
                case '1':
                    menu.menu_1();
                    function2 = s.nextLine().charAt(0);
                    System.out.println(menu.return_menu_1(function2));
                    break;

                case '2':
                    menu.menu_2();
                    function2 = s.nextLine().charAt(0);
                    System.out.println(menu.return_menu_2(function2));
                    break;

                case '3':
                    menu.menu_3();
                    function2 = s.nextLine().charAt(0);
                    System.out.println(menu.return_menu_3(function2));
                    break;

                case '4':
                    menu.menu_4();
                    function2 = s.nextLine().charAt(0);
                    System.out.println(menu.return_menu_4(function2));
                    break;

                case '5':
                    menu.menu_5();
                    function2 = s.nextLine().charAt(0);
                    System.out.println(menu.return_menu_5(function2));
                    break;

                default:
                    key = false;
                    break;
            }

            // Runtime.getRuntime().exec("cls");
        }
        s.close();
    }

    public static class menu {

        public static void menu1() {
            System.out.println("=====================================================================");

            System.out.println("请选选择你需要进行的操作,多输入按照首字符作数");
            System.out.println("1.数据库相关操作      2.表相关操作");
            System.out.println("3.对表中数据进行操作   4.查询相关操作");
            System.out.println("5.约束      else:关闭程序");
        }

        public static void menu_1() {

            System.out.println("=====================================================================");

            System.out.println("请选选择你需要进行的操作,多输入按照首字符作数");
            System.out.println("1.显示全部数据库     2.创建数据库");
            System.out.println("3.删除数据库         4.开始使用某个数据库");
            System.out.println("5.查看当前使用的是哪个数据库");
        }

        public static String return_menu_1(char a) {

            switch (a) {
                case '1':
                    return ("show databases;");

                case '2':
                    return ("create database if not exists 数据库名");

                case '3':
                    return ("drop database if exists 数据库名");

                case '4':
                    return ("use 数据库名");

                case '5':
                    return ("select database()");
                default:
                    return null;
            }
        }

        public static void menu_2() {

            System.out.println("=====================================================================");

            System.out.println("请选选择你需要进行的操作,多输入按照首字符作数");
            System.out.println("1.显示该数据库中有哪些表   2.显示表的结构");
            System.out.println("3.创建表     4.往表中添加一列数据");
            System.out.println("5.删除表     6.删除表中一列数据");
            System.out.println("7.修改表名   8.修改表中某一列的数据类型");
            System.out.println("9.同时修改表中一列以及其数据类型");
        }

        public static String return_menu_2(char a) {

            switch (a) {
                case '1':
                    return ("show tables");

                case '2':
                    return ("desc 表名;");

                case '3':
                    return ("create table 表名 (字段名 数据类型, 字段名 数据类型, 字段名 数据类型);");

                case '4':
                    return ("alter table 表名 add 列名 数据类型;");

                case '5':
                    return ("drop table if exists 表名;");

                case '6':
                    return ("alter table 表名 drop 列名;");

                case '7':
                    return ("alter table 表名 rename to 新的表名;");

                case '8':
                    return ("alter table 表名 modify 列名 新的数据类型;");

                case '9':
                    return ("alter table 表名 change 列名 新列名 新的数据类型;");

                default:
                    return null;
            }
        }

        public static void menu_3() {

            System.out.println("=====================================================================");

            System.out.println("1.往表中添加数据    2.修改表中的数据");
            System.out.println("3.删除表中某些数据");
        }

        public static String return_menu_3(char a) {

            switch (a) {
                case '1':
                    return ("insert into 表名 (列名1 [别名], 列名2 [别名], 列名... [别名]) values (值1 , 值2 , 值...), (值1 , 值2 , 值...), (值1 , 值2 , 值...);");

                case '2':
                    return ("update 表名 set 列名1 = 值1, 列名2 = 值2, 列名. = 值. [where 条件];");

                case '3':
                    return ("delete from 表名 where 条件;//删除条件为这个的一行的信息");

                default:
                    return null;
            }
        }

        public static void menu_4() {

            System.out.println("=====================================================================");

            System.out.println("1.查看表中所有数据    2.查询某些信息");
            System.out.println("3.去重查询      4.条件查询");
            System.out.println("5.模糊查询");

        }

        public static String return_menu_4(char a) {

            switch (a) {
                case '1':
                    return ("select * from 表名");

                case '2':
                    return ("select 列名1 , 列名2 , 列名... from 表名");

                case '3':
                    return ("select distinct 需要去重的列名 , 其他需要查询的列名 from 表名;");

                case '4':
                    return ("select 列名1 , 列名2 , 列名... from 表名 where 条件");

                case '5':
                    return ("select * from 表名 where 某个信息 like _某些信息%;\n_占一个位置,%可以表示占多个位置（也可以不占位置");

                default:
                    return null;
            }
        }

        public static void menu_5() {

            System.out.println("=====================================================================");

            System.out.println("1.非空约束    2.唯一约束");
            System.out.println("3.主键约束    4.默认约束");
            System.out.println("5.检查约束    6.外键约束");
        }

        public static String return_menu_5(char a) {

            switch (a) {
                case '1':
                    return ("not null");

                case '2':
                    return ("unique");

                case '3':
                    return ("primary key");

                case '4':
                    return ("default 默认填充条件");

                case '5':
                    return ("check 条件//mySQl没有这玩意");

                case '6':
                    return ("//外键约束有两种添加方式\n\\1.在外面添加外键约束\n\nalter table 表名 add constraint 外键名 foreign key (这个表的列名) references 另一张表名(连接的主键列名);\n---------------------------\n//2.在创建表的时候添加\n\nconstraint 外键名 foreign key (该表中需要添加外键的列名) references 另一张表名(表中主键)");

                default:
                    return null;

            }
        }

    }
}