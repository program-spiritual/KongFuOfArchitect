package seventh;

public class QuickUnionUF {
  private int[] roots;

  public QuickUnionUF(int[] roots) {
    this.roots = roots;
  }

  public QuickUnionUF(int N) {
    this.roots = new int[N];
    for (int i = 0; i < N; i++) {
      roots[i] = i;
    }
  }

  private int findRoot(int i) {
    int root = i;
    while (root != roots[root]) {
      root = roots[root];
    }

    while (i != roots[i]) {
//      parent
      int tmp = roots[i];
      roots[i] = root;
      i = tmp;
    }
    return root;
  }

  public boolean connected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  public void union(int p, int q) {
    int qroot = findRoot(q);
    int proot = findRoot(p);
    roots[proot] = qroot;
  }

}
