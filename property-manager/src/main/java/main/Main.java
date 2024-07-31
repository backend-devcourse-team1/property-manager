package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loopFlag = true;
        while (loopFlag) {
            conn = DriverManager.getConnection("", "", "");
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
            if(type == 1) {

            } else if(type == 2) {

            } else if(type == 3) {

            } else if(type == 4) {

            } else if(type == 5) {

            } else if(type == 6) {

            } else if(type == 7) {

            } else {
                System.out.println("잘못된 입력입니다.");
            }

        }
    }
}
