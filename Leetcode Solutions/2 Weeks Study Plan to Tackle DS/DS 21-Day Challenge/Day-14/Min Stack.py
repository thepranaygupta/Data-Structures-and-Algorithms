class MinStack:
    def __init__(self):
        self.__a = []
    def push(self, x: int) -> None:
        m = x
        if self.__a:
            m = self.__a[-1][1]
            if m > x:
                m = x
        self.__a.append((x, m))
    def pop(self) -> None:
        self.__a.pop()
    def top(self) -> int:
        return self.__a[-1][0]
    def getMin(self) -> int:
        return self.__a[-1][1]