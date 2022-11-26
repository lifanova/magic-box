public class Main {
    public static void main(String[] args) {
        ToggleSwitch toggleswitch = new ToggleSwitch();

        Thread userThread = new Thread(null, toggleswitch::onSwitch, "Пользователь");
        Thread toyThread = new Thread(null, toggleswitch::offSwitch, "Игрушка");
        System.out.println("Начинаем игру с волшебной коробкой!");
        try {
            userThread.start();
            toyThread.start();

            userThread.join();
            System.out.println("Игра закончена, всем спасибо!");
            toyThread.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
