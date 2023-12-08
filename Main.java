class Tree{

    private Tree left = null;
    private Tree right = null;
    private int value;

    public Tree(int value){
        this.value = value;
    }

    public void addLeft(int value){
        this.left = new Tree(value);
    }

    public void addRight(int value){
        this.right = new Tree(value);
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    private static int height(Tree tree){
        if (tree == null)
            return 0;
        return Math.max(height(tree.getLeft()), height(tree.getRight())) + 1;
    }

    public static boolean isBalanced(Tree tree){
        if (tree == null)
            return true;
        int leftHeight = height(tree.getLeft());
        int rightHeight = height(tree.getRight());
        if (Math.abs(leftHeight - rightHeight)<=1&&isBalanced(tree.getLeft())&&isBalanced(tree.getRight()))
            return true;
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        Tree myTreeRoot = new Tree(0);                          //корень
        myTreeRoot.addLeft(1);                                  //первый уровень
        myTreeRoot.addRight(0);                                 //первый уровень
        myTreeRoot.getLeft().addLeft(1);                        //второй уровень (первый от левой ветки от корня)
        myTreeRoot.getLeft().addRight(0);                      //второй уровень (первый от левой ветки от корня)
        myTreeRoot.getLeft().getLeft().addLeft(1);              //третий уровень (первый от левой ветки от левой ветки от корня)
        myTreeRoot.getRight().addLeft(1);                       //второй уровень (первый от правой ветки от корня)
        myTreeRoot.getRight().addRight(0);                      //второй уровень (первый от правой ветки от корня)
        myTreeRoot.getRight().getRight().addLeft(1);            //третий уровень (первый от правой ветки от правой ветки от корня)
        myTreeRoot.getRight().getRight().addRight(0);
        myTreeRoot.getRight().getRight().getRight().addLeft(1); //если удалить эту строчку, то дерево будет сбалансированным
        if (Tree.isBalanced(myTreeRoot))
            System.out.println("Дерево сбалансировано!");
        else
            System.out.println("Дерево совсем не сбалансировано(");
    }
}
