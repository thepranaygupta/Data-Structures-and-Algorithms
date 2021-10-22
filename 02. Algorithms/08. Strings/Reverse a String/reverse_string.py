"""
The idea:
    1. s = s.split(' ') -> splits the string with the space delim
    2. [x for x in s.split(' ') if x != ""] -> filters leading, trailing or extra spaces (if any)
    3. rev_s = list(reversed(s)) -> returns a reversed list
    4. " ".join(rev_s) -> create a string again from the rev_s with the space delim
"""
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """

        return " ".join(list(reversed([x for x in s.split(' ') if x != ""])))