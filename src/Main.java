import com.github.hadisabbasi.theater.*;

import java.util.Scanner;
public class Main {
    private static ConferenceArray conferences = new ConferenceArray();
    private static AccountArray accountArray = new AccountArray();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("*برای ورود به حساب کاربری عدد1 و برای ساختن حساب کاربری عدد2 را وارد کنید:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("نام کاربری خود را وارد کنید");
                String username = scanner.nextLine();
                System.out.println("رمز خودرا واردکنید");
                int password = scanner.nextInt();
                try{
                    Account loginAccount = accountArray.getAccount(username, password);
                    if (loginAccount == null) {
                        // throw exception
                        throw new RuntimeException("این حساب کاربری وجود ندارد!");
                    }}catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }

                // new menu step 2
                menusStep2();

            case 2:
                System.out.println("نام کاربری مورد نظر و رمز خود را وارد کنید");
                String userName = scanner.nextLine();
                int pass = scanner.nextInt();

                Account registeredAccount = new Account(userName, pass);
                accountArray.add(registeredAccount);

                // new menu step 2
                menusStep2();
        }
    }

    public static void menusStep2() {
        System.out.println("1.برنامه های خالی هفته");
        System.out.println("2.رزرو تایم");
        System.out.println("3.برنامه این هفته");
        System.out.println("4.حذف یک برنامه");
        System.out.println("5.برای خروج5 را وارد کنید");
        System.out.println("------------------------");

        int number = scanner.nextInt();
        try {

            do {
                if (number == 1) {
                    conferences.showEmptyTurns();
                } else if (number == 2) {
                    System.out.println("روز را وارد کنید");
                    String day = scanner.nextLine();
                    System.out.println("نوبت را وارد کنید");
                    int turn = scanner.nextInt();

                    ConferenceTurn conferenceTurn = ConferenceTurn.getByNameAndTurn(day, turn);
                    if (conferenceTurn == null) {
                        System.out.println("نوبت ثبت شد!");
                    } else {
                        try {
                            if (conferences.isTurnExist(conferenceTurn)) {
                                // throw exception
                                throw new RuntimeException("این نوبت قبلا رزرو شده است!");
                            }}catch (RuntimeException e){
                            System.out.println(e.getMessage());
                        }

                        System.out.println("نام خود را وارد کنید");
                        String name = scanner.nextLine();

                        System.out.println("تعداد افراد شرکت کننده را وارد کنید");
                        int people = scanner.nextInt();

                        Conference c = new Conference(name, people, conferenceTurn);
                        int result = conferences.add(c);
                        if (result == -1)
                            System.out.println("ظرفیت خالی برای این هفته وجود ندارد.");
                        else
                            System.out.println("رویداد جدید به برنامه ی این هفته اضافه شد. آیدی:" + result);
                    }

                } else if (number == 3) {
                    conferences.show();
                } else if (number == 4) {
                    System.out.println("ایدی برنامه مورد نظر را  برای حذف کردن وارد کنید");
                    int id = scanner.nextInt();
                    int result = conferences.remove(id);

                    if (result == -1)
                        System.out.println("رویداد مورد نظر یافت نشد.");
                    else
                        System.out.println("برنامه با ایدی" + id + "حذف شد");
                }
            } while (number != 5);
        } catch (Exception e) {
            System.out.println("error!");
            e.printStackTrace();
        }
    }
}


