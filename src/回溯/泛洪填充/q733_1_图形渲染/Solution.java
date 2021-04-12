package 回溯.泛洪填充.q733_1_图形渲染;

/**
 * 方法一：DFS
 * Java：100% 92%
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor)
            dfs(image, sr, sc, image.length, image[0].length, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int n, int m, int oldColor, int newColor) {
        //越界或者不等于oldColor，直接return
        if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != oldColor) {
            return;
        }
        image[row][col] = newColor;
        //上下左右
        dfs(image, row - 1, col, n, m, oldColor, newColor);
        dfs(image, row, col - 1, n, m, oldColor, newColor);
        dfs(image, row + 1, col, n, m, oldColor, newColor);
        dfs(image, row, col + 1, n, m, oldColor, newColor);
    }
}