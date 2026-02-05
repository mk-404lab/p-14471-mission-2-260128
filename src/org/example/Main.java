package org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner input = new Scanner(System.in);
        int id = 0;
        String cmd;

        WiseSaying[] wiseSayings = new WiseSaying[10];
        int lastWiseIndex = -1;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            cmd = input.nextLine();

            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = input.nextLine();

                System.out.print("작가 : ");
                String author = input.nextLine();

                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.id = ++id;
                wiseSaying.author = author;
                wiseSaying.wiseSaying = content;

                wiseSayings[++lastWiseIndex] = wiseSaying;

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");

                for (int i = lastWiseIndex; i >= 0; i--) {
                    WiseSaying foundedWiseSaying = new WiseSaying();
                    foundedWiseSaying = wiseSayings[i];

                    System.out.printf("%d / %s / %s\n", foundedWiseSaying.id, foundedWiseSaying.author, foundedWiseSaying.wiseSaying);
                }

            } else if (cmd.equals("종료")) {
                break;
            }

        }
    }
}
