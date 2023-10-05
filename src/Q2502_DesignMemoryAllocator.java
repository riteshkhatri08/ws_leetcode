import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q2502_DesignMemoryAllocator {
    public static void main(String[] args) {

        String[] func = new String[] { "allocate", "allocate", "allocate", "free", "allocate", "allocate", "allocate",
                "free", "allocate", "free" };

        int[][] params = new int[][] { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2 }, { 3, 4 }, { 1, 1 }, { 1, 1 }, { 1 },
                { 10, 2 }, { 7 } };

        Allocator allocator = new Q2502_DesignMemoryAllocator().new Allocator(10);
        int i = 0;
        StringBuilder result = new StringBuilder("[");
        for (; i < func.length; i++) {
            System.out.println("\n\n " + func[i] + " params - " + params[i][0] );

            switch (func[i]) {

                case "allocate": {
                    result.append(allocator.allocate(params[i][0], params[i][1]) + ", ");
                    break;
                }
                case "free": {

                    result.append(allocator.free(params[i][0]) + ", ");
                    break;
                }

            }
        }
        result.replace(result.length() - 1, result.length(), "]");
        System.out.println(result);

    }

    class Allocator {

        // List in this hashmap must always be ordered
        HashMap<Integer, List<Block>> occupiedBlocksMap = new HashMap<Integer, List<Block>>();

        // This list must always be ordered
        List<Block> freeBlocksList = new ArrayList<Block>();

        public Allocator(int n) {

            // Record free memory block metadata
            freeBlocksList.add(new Block(0, n));

        }

        public int allocate(int requiredSize, int mID) {

            int blockIndex = findBlockOfSizeOrGreater(requiredSize);

            if (blockIndex > -1) {
                Block freeBlock = freeBlocksList.get(blockIndex);

                // Create a new block and add to occupied blocks list
                Block newOccupiedBlock = new Block(freeBlock.startAddr, requiredSize);
                addBlockToOccupiedBlockMap(mID, newOccupiedBlock);
                System.out.println(occupiedBlocksMap);
                // Remove or reduce the size of freeBlock from free block list
                if (freeBlock.size == requiredSize) {
                    // Remove this from free block list as this is now completely occupied
                    freeBlocksList.remove(blockIndex);
                } else {
                    // Reduce the size of this block as this has been partially occupied
                    freeBlock.startAddr = freeBlock.startAddr + requiredSize;
                    freeBlock.size = freeBlock.size - requiredSize;
                }
                System.out.println("FREE BLOCKS - " + freeBlocksList);
                return newOccupiedBlock.startAddr;
            }
            System.out.println("FREE BLOCKS - " + freeBlocksList);
            // Return -1 as we cant find an available block
            return -1;

        }

        private int findBlockOfSizeOrGreater(int requiredSize) {

            // Optional<Block> matchingBlock = freeBlocksList.stream().filter(p -> p.size >=
            // requiredSize).findFirst();
            // Find first element from list where element's size >= requiredSize
            Block currentBlock;
            for (int index = 0; index < freeBlocksList.size(); index++) {
                currentBlock = freeBlocksList.get(index);
                if (currentBlock.size >= requiredSize) {

                    // Find a block having size greater than or equal to requiredSize
                    return index;
                }
            }
            // Reached here means no block of required size or greater is present;
            return -1;
        }

        private void addBlockToOccupiedBlockMap(int mID, Block newBlock) {
            if (occupiedBlocksMap.containsKey(mID)) {
                // ADD in sorted order
                List<Block> mappedBlocksList = occupiedBlocksMap.get(mID);
                int index = 0;
                while (index < mappedBlocksList.size() && mappedBlocksList.get(index).startAddr < newBlock.startAddr) {
                    index++;
                }

                // Combine reserved blocks
                // If insert at first postion
                if (index == 0) {
                    Block currentBlock = mappedBlocksList.get(index);
                    if ((newBlock.startAddr + newBlock.size) == currentBlock.startAddr) {
                        // merge
                        currentBlock.startAddr = newBlock.startAddr;
                        currentBlock.size = currentBlock.size + newBlock.size;
                    } else {
                        // add at 0th position
                        mappedBlocksList.add(index, newBlock);
                    }
                } else if (index == mappedBlocksList.size()) {
                    // Insert at Last Postion
                    Block prevBlock = mappedBlocksList.get(index - 1);
                    if (prevBlock.startAddr + prevBlock.size == newBlock.startAddr) {
                        prevBlock.size = prevBlock.size + newBlock.size;
                    } else {
                        mappedBlocksList.add(newBlock);
                    }
                } else {
                    // Insert between 2 blocks
                    Block prevBlock = mappedBlocksList.get(index - 1);
                    Block currentBlock = mappedBlocksList.get(index);

                    if ((prevBlock.startAddr + prevBlock.size == newBlock.startAddr)
                            && (newBlock.startAddr + newBlock.size == currentBlock.startAddr)) {
                        // combine prev new and current blocks
                        prevBlock.size = prevBlock.size + newBlock.size + currentBlock.size;
                        // Remoce current block
                        mappedBlocksList.remove(index);
                    } else if (prevBlock.startAddr + prevBlock.size == newBlock.startAddr) {
                        // combines with prev block
                        prevBlock.size = prevBlock.size + newBlock.size;
                    } else if ((newBlock.startAddr + newBlock.size) == currentBlock.startAddr) {
                        // Combines with block currently at index
                        currentBlock.startAddr = newBlock.startAddr;
                        currentBlock.size = newBlock.size + currentBlock.size;
                    } else {
                        // Combines with none cannot merge blocks
                        mappedBlocksList.add(index, currentBlock);
                    }

                }

                mappedBlocksList.add(index, newBlock);

            } else {
                // Initialise list and add first block mapped to mId
                List<Block> newBlockList = new ArrayList<Block>();
                newBlockList.add(newBlock);
                occupiedBlocksMap.put(mID, newBlockList);
            }
            occupiedBlocksMap.put(mID, occupiedBlocksMap.getOrDefault(mID, Arrays.asList(newBlock)));
        }

        public int free(int mID) {
            return -1;
        }
    }

    class Block {

        int startAddr;
        int size;

        Block(int startAddr, int size) {
            this.startAddr = startAddr;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Block [startAddr=" + startAddr + ", size=" + size + "]";
        }

    }
}

// DRY RUN
// first block of size s from left
// 1 Init
// 2 allocate 1 - m1
// 3 allocate 4- m2
// 4 allocate 3 - m1
// 5 allocate 2 - m3
// 6 free - m1
// 7 allocate 2 - m2
// 8 free - m3

// occupiedBlockMap =
// 1 = {}
// 2 = m1:0
// 3 = m1:0 | m2:1-4
// 4 = m1:0,5-7 | m2:1-4
// 5 = m1:0,5-7 | m2:1-4 | m3:8-9
// 6 = m2:1-4 | m3:8-9
// 7 = m2:1-4,5-6 | m3:8-9
// freeBlocksOrderedList =
// 1 - 0-9:10
// 2 - 1-9:9
// 3 - 5-9:5
// 4 - 8-9:2
// 5 - NONE
// 6 - 0:1 | 5-7:3
// 7 - 0:1 | 7:1
// 8 -
