import java.util.Scanner;

public class line {

    public static void main(String []args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int counter=0;

        int index = 0;

        int[] first = new int[T];
        int[] second = new int[T];

        for(int i=0; i<T; i++) {
            first[i] = sc.nextInt();
        }

        for(int i=0; i<T; i++) {
            second[i] = sc.nextInt();
        }

        for(int i=0; i<T; i++) {

            if(first[i] != second[i]) {

                for(int j=i+1; j<T; j++) {
                    if (first[j] == second[i]) {
                        index = j;
                        break;
                    }
                }

                System.arraycopy(first, 0, first, 1, index);

                counter++;

            }

        }

        System.out.println(counter);

    }

}
