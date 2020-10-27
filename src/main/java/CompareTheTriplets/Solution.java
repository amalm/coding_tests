package CompareTheTriplets;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<String> wins = new ArrayList<>(a.size());
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                wins.add("a");
            else if (a.get(i) < b.get(i))
                wins.add("b");
            else
                wins.add("-");

        }
        List<Integer> results = new ArrayList<>(2);
        results.add((wins.stream().filter(w -> w.equals("a")).collect(Collectors.toList()).size()));
        results.add((wins.stream().filter(w -> w.equals("b")).collect(Collectors.toList()).size()));
        return results;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
