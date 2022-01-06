/**
 * TowerOfHanoi
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 4; // Number of disks
        TOH(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }

    public static void TOH(int n, char src, char dest, char aux) {
        if (n == 0)
            return;
        TOH(n - 1, src, aux, dest);
        System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);
        TOH(n - 1, aux, dest, src);

    }
}

// number of movements :   pow(2,n)-1
// Time complexity :       Theta(2^n)