class ArvoreBinariaBusca {

    public class No {
        public int val;
        public No esq, dir;

        public No(int item) {
            val = item;
            esq = dir = null;
        }
    }

    No raiz;

    ArvoreBinariaBusca() {
        raiz = null;
    }

    ArvoreBinariaBusca(int value) {
        raiz = new No(value);
    }

    // This method mainly calls addRec()
    void add(int val) {
        raiz = addRec(raiz, val);
    }

    // A recursive function to add
    // a new val in BST
    No addRec(No auxiliar, int val) {

        if (auxiliar == null) {
            auxiliar = new No(val);
            return auxiliar;
        }

        if (val < auxiliar.val)
            auxiliar.esq = addRec(auxiliar.esq, val);
        else if (val > auxiliar.val)
            auxiliar.dir = addRec(auxiliar.dir, val);

        return auxiliar;
    }

    void print() {
        printRec(raiz);
    }

    // A utility function to
    // do print traversal of BST
    void printRec(No raiz) {
        if (raiz != null) {
            printRec(raiz.esq);
            System.out.println(raiz.val);
            printRec(raiz.dir);
        }
    }

    public boolean search(No raiz, int val) {
        if (raiz == null) {
            return false;
        }
        if (raiz.val == val) {
            return true;
        }
        if (raiz.val < val) {
            return search(raiz.dir, val);
        }
        return search(raiz.esq, val);
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca tree = new ArvoreBinariaBusca();

        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);

        tree.print();
        tree.print();

        if (tree.search(tree.raiz, 90)) {
            System.out.println("O elemento foi achado");
        } else {
            System.out.println("O elemento ñ foi achado");
        }
    }
}
