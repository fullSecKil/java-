public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("我最帅");
        });

        System.out.println("得到线程优先级" + thread.getPriority());
        thread.setPriority(7);
        System.out.println("得到线程优先级" + thread.getPriority());
        System.out.println("是否是守护线程" + thread.isDaemon());
        System.out.println("得到线程状态" + thread.getState());
        thread.setDaemon(true);
        System.out.println("是否是守护线程" + thread.isDaemon());
    }
}
