import java.util.ArrayList;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 4; // Adjust difficulty (higher = slower mining)

    // Validate blockchain integrity
    public static boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            // Validate hash
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current block hash is invalid!");
                return false;
            }

            // Validate previous hash linkage
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous block hash is invalid!");
                return false;
            }
        }
        return true;
    }
}