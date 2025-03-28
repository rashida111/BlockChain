import java.security.MessageDigest;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data; // Block data (e.g., transactions)
    private long timeStamp;
    private int nonce;

    // Constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // Calculate hash using SHA-256
    public String calculateHash() {
        String input = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;
        return applySha256(input);
    }

    // Mine block with Proof of Work (difficulty = leading zeros required in hash)
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }

    // Apply SHA-256 hashing algorithm
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}