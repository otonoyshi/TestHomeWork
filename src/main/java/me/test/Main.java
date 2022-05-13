package me.test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

class Main {
    public static int earnings = 0;
    public static int spendings = 0;

    public int main(String a) {
        Scanner scanner = new Scanner(System.in);
        int s = 0;
        while (true){

            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("Чтобы завершить расчет введите end");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать сиcтему налогооблажения");
            String input = a;//scanner.nextLine();
            if ("end".equals(input)){
                System.out.println("Программа завершена");
                s = 404;
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation){
                case 1:
                    System.out.println("Введите сумму дохода:");
                    getEarnings(scanner.nextInt());
                    s = 1;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    getSpendings(scanner.nextInt());
                    s = 2;
                    break;
                case 3:
                    text(taxEarningsMinusSpendings(earnings,spendings),taxSpendingsPercent(earnings,spendings));
                    s = 3;
                    break;
                default:
                    System.out.println("Такой операции нет");

            }


        }
        return s;
    }


    public int getSpendings(int money){
        spendings = money;
        return spendings;
    }


    public int getEarnings(int money){
        earnings += money;
        return earnings;
    }

    public int taxEarningsMinusSpendings(int earnings, int spendings){
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0){
            return tax;
        }else{
            return 0;
        }
    }
    public int taxSpendingsPercent(int earnings, int spendings){
        int tax = earnings * 6 / 100;
        if (tax >= 0){
            return tax;
        }else{
            return 0;
        }
    }

    public int text(int textEarningsMinusSpendings, int textEarningsPercent){
        StringBuilder sb = new StringBuilder();
        int message;
        if (textEarningsMinusSpendings<textEarningsPercent){
            sb.append("Мы советуем вам УСН доходы минус расходы - ");
            sb.append("Ваш налог составит: " + textEarningsMinusSpendings + " рублей - ");
            sb.append("Налог на другой системе: " + textEarningsPercent + " рублей - ");
            sb.append("Экономия: " + (textEarningsPercent - textEarningsMinusSpendings));
            message = 1;
        }else {
            sb.append("Мы советуем вам УСН доходы - ");
            sb.append("Ваш налог составит: " + textEarningsPercent + " рублей - ");
            sb.append("Налог на другой системе: " + textEarningsMinusSpendings + " рублей - ");
            sb.append("Экономия: " + (textEarningsMinusSpendings - textEarningsPercent));
            message = 2;
        }
        String text = sb.toString();
        return message;
    }











}
