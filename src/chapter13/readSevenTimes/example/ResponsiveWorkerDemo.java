package chapter13.readSevenTimes.example;

import java.util.concurrent.atomic.AtomicBoolean;

/*
페이지 535
yield() 와 interrupt()를 적절히 사용해서 프로그램의 응답성을 높이고 보다 효율적인 실행
 */
public class ResponsiveWorkerDemo {
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
                            System.out.println("sleep 중 InterruptedException 발생!");
                            Thread.currentThread().interrupt(); // 인터럽트 상태 복원
                        }
                    }

                    // 실제 작업 수행
                    processItem(i);

                    // 진행 상황 표시 (100개 항목마다)
                    if (i % 100 == 0) {
                        System.out.println("작업 진행 중: " + i + "/" + totalItems);
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
        System.out.println("작업 일시 정지 요청됨");
    }

    public void resumeWork() {
        paused.set(false);
        System.out.println("작업 재개 요청됨");
    }

    public void stopWork() {
        if (workerThread != null) {
            System.out.println("작업 중지 요청됨 (인터럽트 신호 발송)");
            workerThread.interrupt();
        }
    }

    private void processItem(int item) {
        // 시뮬레이션: 각 아이템 처리에 시간이 걸리는 작업
        try {
            // CPU 집약적인 작업 시뮬레이션
            long result = 0;
            for (int i = 0; i < 1000; i++) {
                result += (i * item) % 777;
            }

            // 간헐적으로 I/O 작업 시뮬레이션
            if (item % 500 == 0) {
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 인터럽트 상태 복원
        }
    }

    // 두 가지 인터럽트 시나리오를 테스트하는 메인 메서드
    public static void main(String[] args) throws Exception {
        // 시나리오 1: 일반 작업 중 인터럽트
        testNormalInterrupt();

        // 잠시 대기 후 시나리오 2 실행
        Thread.sleep(1000);
        System.out.println("\n===========================\n");

        // 시나리오 2: 일시 정지 상태에서 인터럽트
        testPausedInterrupt();
    }

    // 시나리오 1: 일반 작업 중 인터럽트
    private static void testNormalInterrupt() throws Exception {
        System.out.println("시나리오 1: 일반 작업 중 인터럽트 테스트");
        ResponsiveWorkerDemo worker = new ResponsiveWorkerDemo();
        worker.startWork();

        // 잠시 작업 진행
        Thread.sleep(500);

        // 작업 중지 (인터럽트)
        worker.stopWork();

        // 인터럽트 처리 완료 대기
        Thread.sleep(500);
    }

    // 시나리오 2: 일시 정지 상태에서 인터럽트
    private static void testPausedInterrupt() throws Exception {
        System.out.println("시나리오 2: 일시 정지 상태에서 인터럽트 테스트");
        ResponsiveWorkerDemo worker = new ResponsiveWorkerDemo();
        worker.startWork();

        // 잠시 작업 진행
        Thread.sleep(500);

        // 작업 일시 정지
        worker.pauseWork();

        // 일시 정지 상태 확인
        Thread.sleep(500);

        // 일시 정지 상태에서 인터럽트
        worker.stopWork();

        // 인터럽트 처리 완료 대기
        Thread.sleep(500);
    }
}
