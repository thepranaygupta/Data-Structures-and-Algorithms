class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        ord = sorted(zip(efficiency, speed), reverse=True)
        spheap, totalSpeed, best = [], 0, 0
        for eff, spd in ord:
            heappush(spheap, spd)
            if len(spheap) <= k: totalSpeed += spd
            else: totalSpeed += spd - heappop(spheap)
            best = max(best, totalSpeed * eff)
        return best % 1000000007