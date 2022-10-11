class Solution {
public:
    vector<int> getRow(int rowIndex) {
        ++rowIndex;
        std::vector<int> res(rowIndex, 1);
        for(int i{1}; i < rowIndex; ++i)
            res[i] = (int64_t)
            res[i-1] * (rowIndex-i) / i;
        return res;
    }
};