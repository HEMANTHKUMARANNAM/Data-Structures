class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class TreeStructure {

    // Get the height of the tree
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // Fill the 2D array to represent the tree
    public static void fillTree(TreeNode root, String[][] res, int row, int start, int end) {
        if (root == null) return;

        int mid = (start + end) / 2 -1; // Calculate mid position to place the current node1

        res[row][mid] = String.valueOf(root.val);

        // Recursively fill the left and right subtrees
        fillTree(root.left, res, row + 1, start, mid - 1);
        fillTree(root.right, res, row + 1, mid + 1, end);
    }

    // Print the formatted tree
    public static void printTree(TreeNode root) {
        if (root == null) return;

        int height = getHeight(root);
        int rows = height * 2 - 1;  // Rows needed to visualize tree
        int cols = (int) Math.pow(2, height) - 1;  // Width of the tree
        String[][] res = new String[rows][cols];

        // Fill the array with spaces
        for (String[] row : res) {
            java.util.Arrays.fill(row, " ");
        }

        // Fill tree nodes into the array
        fillTree(root, res, 0, 0, cols - 1);

        // Print the tree
        for (String[] row : res) {
            for (String val : row) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example tree:
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.left.right= new TreeNode(17);

        root.left.left = new TreeNode(12  );

        root.left.left.right = new TreeNode(17);
        // root.left.left.left = new TreeNode(8);

        root.left.left.right.left = new TreeNode(0);

        // Print the tree
        printTree(root);
    }
}
