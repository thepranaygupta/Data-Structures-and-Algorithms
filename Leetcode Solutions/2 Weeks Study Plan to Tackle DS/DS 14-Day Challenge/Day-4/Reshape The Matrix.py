class Solution(object):
    def matrixReshape(self, mat, r, c):
        if not mat:
            return mat
        col = len(mat[0])
        row = len(mat)
        if row * col != r * c:
            return mat
        new_mat = [[0 for _ in range(c)] for _ in range(r)]
        i = 0
        while i < r * c:
            new_mat[i // c][ i % c] =  mat[i // col][i % col]
            i += 1
        return new_mat