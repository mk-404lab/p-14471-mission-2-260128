package org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner input = new Scanner(System.in);
        String cmd, wiseSaying, author;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            cmd = input.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                wiseSaying = input.nextLine();

                System.out.print("작가 : ");
                author = input.nextLine();

                System.out.println("1번 명언이 등록되었습니다.");
            } else if (cmd.equals("종료")) {
                break;
            }

        }
    }
}
