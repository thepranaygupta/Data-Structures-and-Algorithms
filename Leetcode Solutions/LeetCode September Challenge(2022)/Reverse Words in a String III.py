class Solution:
    def reverseWords(self, s):
        return " ".join(map(lambda x: x[::-1], s.split()))