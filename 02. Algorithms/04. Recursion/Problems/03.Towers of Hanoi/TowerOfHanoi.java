public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(3, 'A','B', 'C');
    }

    static void towerOfHanoi(int n, char from, char aux, char to) {
        if (n>0) {
            towerOfHanoi(n-1, from, to, aux);
            System.out.println("Move " + n + " from " + from + " to " + to );
            towerOfHanoi(n-1, aux, from, to);
        }
    }
}