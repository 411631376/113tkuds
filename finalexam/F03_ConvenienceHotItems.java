import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String name = input[0];
            int qty = Integer.parseInt(input[1]);
            Item newItem = new Item(name, qty);

        
            int j = 0;
            while (j < items.size() && items.get(j).qty >= newItem.qty) {
                j++;
            }
            items.add(j, newItem);
        }

        // 輸出前 10 名
        for (int i = 0; i < Math.min(10, items.size()); i++) {
            System.out.println(items.get(i).name + " " + items.get(i).qty);
        }
    }

    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }
}
/*
 * Time Complexity: O(n^2)
 * 說明：每次插入操作最壞需比較已排序清單中所有元素（O(n)），
 * 總共需插入 n 次，因此整體最壞情況為 O(n^2)；
 * 插入排序平均情況下也約為 O(n^2)，適合小規模資料（n ≤ 200）。
 */