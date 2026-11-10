import java.util.*;

class b2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        Map<String, String> phongban = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] row = sc.nextLine().trim().split("\\s+", 2);
            phongban.put(row[0], row[1]);
        }

        int m = Integer.parseInt(sc.nextLine().trim());
        int[][] rates = {
            {10, 12, 14, 20},
            {10, 11, 13, 16},
            {9, 10, 12, 14},
            {8, 9, 11, 13}
        };

        for (int i = 0; i < m; i++) {
            String id = sc.nextLine().trim();
            String name = sc.nextLine().trim();
            long luong = Long.parseLong(sc.nextLine().trim());
            long cong = Long.parseLong(sc.nextLine().trim());

            int years = Integer.parseInt(id.substring(1, 3));
            int b = years <= 3 ? 0 : years <= 8 ? 1 : years <= 15 ? 2 : 3;
            int rate = rates[id.charAt(0) - 'A'][b];

            String pb = phongban.get(id.substring(3, 5));
            long salary = luong * cong * rate;

            System.out.printf("%s %s %s %d", id, name, pb, salary);
            System.out.println("000");
           
        }
    }
}