import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class HandPQ {

    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            String[] header = br.readLine().split(",");
            int count = Integer.parseInt(header[0]);
            int target = Integer.parseInt(header[1]);
            String ans = "";
            MinPQ<Hand> pq = new MinPQ<>(count);
            for (String in = br.readLine(); in != null; in = br.readLine()) {
                String c[] = in.split(",");
                Card cards[] = new Card[5];
                for (int i = 0; i < 5; i++) {
                    String[] s = c[i].split("_");
                    cards[i] = new Card(s[1], s[0]);
                }
                pq.insert(new Hand(cards));
                if (pq.size() > target) pq.delMin();
            }

            Card c[] = pq.delMin().getCards();
            for (int j = 0; j < 5; j++) {
                ans += (c[j].getSuit() + "_" + c[j].getFace());
                if (j != 4) ans += ",";
            }
            System.out.println(ans);
        }
    }
}
