import java.util.Scanner;

public class MinimumBribes {

    private static final Scanner scanner = new Scanner(System.in);
    private static int totalBrineCount = 0;
    private static boolean tooManyMovements = false;
    private static int[] bribeCounter;
    private static int[] moveCounter;

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        moveCounter = new int[q.length + 1];
        bribeCounter = new int[q.length + 1];
        for (int i = 0; i < q.length; i++) {
            moveCounter[q[i]] = (q[i] - 1) - i;
        }
        for (int j = q.length - 1; j >= 0; j--) {
            if (j == q.length - 1) {
                continue;
            }
            //&& moveCounter[j] > 0
            if (q[j] > q[j + 1] ) {
                moveNums(q, j, moveCounter[j]);
                j = q.length - 1;
            }
        }
        checkMovements();
    }

    static void checkMovements() {
        for (int i = 0; i < bribeCounter.length; i++) {
            if (bribeCounter[i] > 2) {
                tooManyMovements = true;
            } else {
                totalBrineCount += bribeCounter[i];
            }
        }
        if (tooManyMovements) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(totalBrineCount);
        }
    }

    static void moveNums(int[] arr, int startIndex, int noOfMoves) {
        for (int i = startIndex; i < (startIndex + noOfMoves); i++) {
            int currNum = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = currNum;
            bribeCounter[currNum]++;
            moveCounter[arr[i]] += 1;
            moveCounter[arr[i + 1]] -= 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("input t");
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            System.out.println("input n");
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            System.out.println("input array");
            String[] qItems = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }
            minimumBribes(q);
        }
        scanner.close();
    }
}
