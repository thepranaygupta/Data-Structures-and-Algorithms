class Solution:
    def bagOfTokensScore(self, tokens: List[int], P: int) -> int:
        tokens.sort()
        L, H = 0, len(tokens)-1
        score, res = 0, 0
        while L <= H:
            if tokens[L] <= P:
                P-=tokens[L]
                score+=1
                res = max(score, res)
                L+=1
            elif score >= 1:
                P+=tokens[H]
                score-=1
                H-=1
            else:
                break
        return res