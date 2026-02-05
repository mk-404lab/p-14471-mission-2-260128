package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in);
    int id = 0;
    String cmd;

    WiseSaying[] wiseSayings = new WiseSaying[10];
    int lastWiseIndex = -1;

    public void run(){

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            cmd = input.nextLine();

            if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                actionModify(cmd);
            } else if (cmd.equals("종료")) {
                break;
            }

        }
    }

    private void actionModify(String cmd) {
        String idStr = cmd.split("=")[1];
        int id = Integer.parseInt(idStr);

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.wiseSaying);
        System.out.print("명언 : ");
        String content = input.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.author);
        System.out.print("작가 : ");
        String author = input.nextLine();

        modify(wiseSaying, content, author);
    }

    private void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.wiseSaying = content;
        wiseSaying.author = author;
    }

    private WiseSaying findById(int modifyTarget){
        for (int i = 0; i <= lastWiseIndex; i++) {
            WiseSaying foundedWiseSaying = wiseSayings[i];

            if (foundedWiseSaying.id == modifyTarget) {
                return wiseSayings[i];
            }
        }

        return null;
    }

    private void actionDelete(String cmd) {

        String idStr = cmd.split("=")[1];
        int id = Integer.parseInt(idStr);

        boolean rst = delete(id);

        if (!rst) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    private boolean delete(int deleteTarget){
        int foundedIndex = -1;

        for (int i = 0; i <= lastWiseIndex; i++) {
            WiseSaying foundedWiseSaying = wiseSayings[i];

            if (deleteTarget == foundedWiseSaying.id) {
                foundedIndex = i;
            }
        }

        if (foundedIndex == -1) {   // 삭제하고자 하는 명언 id가 없는 경우
            return false;
        }

        for (int i = foundedIndex; i < lastWiseIndex; i++) {
            wiseSayings[i] = wiseSayings[i + 1];
        }

        lastWiseIndex--;
        return true;
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");

        List<WiseSaying> wiseSayingList = findList();

        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.wiseSaying);

        }

    }

    private List<WiseSaying> findList() {
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        for (int i = lastWiseIndex; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings[i];

            wiseSayingList.add(foundedWiseSaying);
        }
        return wiseSayingList;
    }

    private void actionWrite(){
        System.out.print("명언 : ");
        String content = input.nextLine();

        System.out.print("작가 : ");
        String author = input.nextLine();

        write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    private void write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying();

        wiseSaying.id = ++id;
        wiseSaying.author = author;
        wiseSaying.wiseSaying = content;

        wiseSayings[++lastWiseIndex] = wiseSaying;

    }

}
