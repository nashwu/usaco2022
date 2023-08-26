import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class arrange_meal {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int n = Integer.parseInt(in.readLine()); n > 0; n--) {


            StringTokenizer tokenizer = new StringTokenizer(in.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());

            int[] number = new int[N];

            StringTokenizer tokenizer1 = new StringTokenizer(in.readLine());

            for (int j = 0; j < N; j++) {
                number[j] = Integer.parseInt(tokenizer1.nextToken());
            }

            int list_length = number.length;

            int end_index = list_length - 1;
            int sum = 0;
            int final_score = 0;
            for (int j : number) {
                sum = sum + j;
                if (j > final_score) {
                    final_score = j;
                }
            }
            double top_try = sum / 2;

            int step;
            int no_luck = 1;
            int finish = 0;
            int next_final_score_just_if_group_sum_greater_than_final_score = 0;

            while (final_score <= top_try) {
                int group_sums = 0;
                int count_changes = 0;
                int modification = 0;
                int enter_equal = 0;
                int index = 0;
                int indexx;
                while (index < list_length) {
                    int equal = 0;
                    group_sums = group_sums + number[index];

                    if (group_sums == final_score) {

                        enter_equal++;
                        modification = modification + count_changes;
                        if (index == end_index) {
                            finish = 1;
                            break;
                        }
                        if (enter_equal == 1) {
                            indexx = index + 1;

                            if (number[indexx] == 0) {
                                step = 1;
                            } else {
                                step = number[indexx];
                            }

                            next_final_score_just_if_group_sum_greater_than_final_score = group_sums + step;
                        }
                        group_sums = 0;
                        equal = 1;


                    } else if (group_sums > final_score) {
                        if (enter_equal >= 1) {

                            final_score = next_final_score_just_if_group_sum_greater_than_final_score;
                        } else {
                            final_score = group_sums;
                        }
                        break;
                    }
                    if (index == end_index) {
                        if (enter_equal >= 1) {
                            final_score = next_final_score_just_if_group_sum_greater_than_final_score;
                        } else {
                            final_score = group_sums;
                        }
                    }

                    count_changes = count_changes + 1;
                    if (equal == 1) {
                        count_changes = 0;
                    }

                    index = index + 1;


                }
                if (finish == 1) {
                    System.out.println(modification);
                    no_luck = 0;
                    break;
                }


            }
            if (no_luck == 1) {
                System.out.println(list_length - 1);
            }
        }

    }


}
