public class Main {
    public static void main(String[] args) {
        System.out.println("Mining the Genesis Block...");
        Blockchain.blockchain.add(new Block("First block (Genesis)", "0"));
        Blockchain.blockchain.get(0).mineBlock(Blockchain.difficulty);

        System.out.println("\nMining Block 2...");
        Blockchain.blockchain.add(new Block("This is Block 2", Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash));
        Blockchain.blockchain.get(1).mineBlock(Blockchain.difficulty);

        System.out.println("\nMining Block 3...");
        Blockchain.blockchain.add(new Block("This is Block 3", Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash));
        Blockchain.blockchain.get(2).mineBlock(Blockchain.difficulty);

        System.out.println("\nBlockchain Validity: " + Blockchain.isChainValid());

        // Print the blockchain
        for (Block block : Blockchain.blockchain) {
            System.out.println("\nBlock:");
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous Hash: " + block.previousHash);
        }
    }
}