package main;

import entity.Property;
import io.github.cdimascio.dotenv.Dotenv;
import propertyManager.PropertyManager;
import propertyManager.impl.PropertyManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PropertyManager propertyManager = new PropertyManagerImpl(connection);
            boolean loopFlag = true;
            while (loopFlag) {
                System.out.println("------- 메뉴 선택 -------");
                System.out.println("\t1. 매물 등록하기");
                System.out.println("\t2. 매물 조회하기");
                System.out.println("\t3. 매물 면적 순으로 조회하기");
                System.out.println("\t4. 매물 오래된 순으로 조회하기");
                System.out.println("\t5. 매물 판매일 수정하기");
                System.out.println("\t6. 매물 제거하기");
                System.out.println("\t7. 프로그램 종료하기");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int type = Integer.parseInt(br.readLine());
                switch (type){
                    case 1:
                        break;
                    case 2:
                        List<Property> properties = propertyManager.getProperties();
                        for (Property property : properties) {
                            System.out.println(property.toString());
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 6:
                        int pro_id = Integer.parseInt(br.readLine());
                        deleteProperty(pro_id);
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;

                }
            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
