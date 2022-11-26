public class ToggleSwitch {
    int iMax = 5;

    volatile boolean toggle = false;

    public void onSwitch() {
        while (iMax != 0) {
            try {
                if (!toggle) {
                    toggle = true;
                    System.out.printf("%s -> Включаю тумблер!\n", Thread.currentThread().getName());
                    iMax--;
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void offSwitch() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(2000);
                if (toggle) {
                    toggle = false;
                    System.out.printf("%s -> Выключаю тумблер!\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
