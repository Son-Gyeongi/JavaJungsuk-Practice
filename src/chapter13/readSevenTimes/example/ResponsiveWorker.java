package chapter13.readSevenTimes.example;

import java.util.concurrent.atomic.AtomicBoolean;

/*
페이지 535
yield() 와 interrupt()를 적절히 사용해서 프로그램의 응답성을 높이고 보다 효율적인 실행
 */
public class ResponsiveWorker {
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private Thread workerThread;

    public void startWork() {
        workerThread = new Thread(() -> {
            try {
                // 작업 데이터 준비
                int totalItems = 10000;

                for (int i = 0; i < totalItems; i++) {
                    // 인터럽트 체크
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("작업이 인터럽트되었습니다");
                        return;
                    }

                    // 일시 정지 확인
                    while (paused.get()) {
                        Thread.yield(); // 일시 정지 상태에서는 다른 스레드에 양보

                        // 일시 정지 상태에서도 인터럽트 확인
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println("일시 정지 상태에서 인터럽트되었습니다");
                            return;
                        }

                        try {
                            Thread.sleep(100); // 짧은 대기로 CPU 사용 최소화
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // 인터럽트 상태 복원
                        }
                    }

                    // 실제 작업 수행
                    processItem(i);

                    // 응답성 개선: 일정 주기마다 yield 호출
                    if (i % 100 == 0) {
                        Thread.yield();
                    }
                }

                System.out.println("작업이 완료되었습니다");
            } catch (Exception e) {
                System.out.println("작업 중 오류 발생: " + e.getMessage());
            }
        });

        workerThread.start();
    }

    public void pauseWork() {
        paused.set(true);
    }

    public void resumeWork() {
        paused.set(false);
    }

    public void stopWork() {
        if (workerThread != null) {
            workerThread.interrupt();
        }
    }

    private void processItem(int item) {
        // 시뮬레이션: 각 아이템 처리에 시간이 걸리는 작업
        try {
            // CPU 집약적인 작업 시뮬레이션
            long result = 0;
            for (int i = 0; i < 10000; i++) {
                result += (i * item) % 777;
            }

            // 간헐적으로 I/O 작업 시뮬레이션
            if (item % 500 == 0) {
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 인터럽트 상태 복원
        }
    }

    // 사용 예시
    public static void main(String[] args) throws Exception {
        /*ResponsiveWorker worker = new ResponsiveWorker();
        worker.startWork(); // 내부적으로 workerThread.start()가 호출됨

        // 3초 후 일시 정지
        Thread.sleep(3000);
        System.out.println("작업 일시 정지");
        worker.pauseWork();

        // 2초 후 재개
        Thread.sleep(2000);
        System.out.println("작업 재개");
        worker.resumeWork();

        // 3초 후 중지
        Thread.sleep(3000);
        System.out.println("작업 중지");
        worker.stopWork();*/

        ResponsiveWorker worker = new ResponsiveWorker();
        worker.startWork();

        // 작업 진행 상태 확인을 위한 대기
        System.out.println("작업이 시작되었습니다. 3초 후 중지합니다.");
        Thread.sleep(3000);

        // 작업 중지 - 인터럽트 발생
        System.out.println("인터럽트 신호를 보냅니다.");
        worker.stopWork();

        // 작업이 정상적으로 종료되었는지 확인
        System.out.println("메인 스레드는 계속 실행됩니다.");
        Thread.sleep(1000);
        System.out.println("프로그램을 종료합니다.");
    }
}