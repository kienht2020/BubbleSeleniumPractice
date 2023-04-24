package automation;

public class Settings {
    private static int objecWait = 45;

    /**
     * Set time out for wait control, element. Default is 60 seconds
     * @param objecWait: second
     */
    public static void setObjecWait(int objecWait) {
        Settings.objecWait = objecWait;
    }
    public static int getObjecWait() {
        return objecWait;
    }
}
