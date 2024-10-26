from os import *
from sys import *
from collections import *
from math import *

class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.arr = arr
        self.lookup = [0]*(4*self.n+5)
        self.build(0, 0, self.n-1)
        
    def build(self, index, left, right):
        if left > right:
            return
        if left == right:
            self.lookup[index] = self.arr[left]
            return
        mid = (left+right) >> 1
        self.build(2*index+1, left, mid)
        self.build(2*index+2, mid+1, right)
        self.lookup[index] = self.lookup[2*index+1] + self.lookup[2*index+2]
        return
    
    def query(self, left, right):
        return self.queryHelper(0, 0, self.n-1, left, right)
    
    def queryHelper(self, index, left, right, fromIndex, toIndex):
        # complete overlap
        if fromIndex <= left and toIndex >= right:
            return self.lookup[index]
        # no overlap
        if fromIndex > right or toIndex < left:
            return 0
        # partial overlap
        mid = (left+right) >> 1
        leftSum, rightSum = self.queryHelper(2*index+1, left, mid, fromIndex, toIndex), self.queryHelper(2*index+2, mid+1, right, fromIndex, toIndex)
        return leftSum + rightSum
    
    def update(self, atIndex, value):
        self.updateHelper(0, 0, self.n-1, atIndex, value)
        
    def updateHelper(self, index, left, right, atIndex, value):
        if left > right:
            return
        if left == right and right == atIndex:
            self.arr[left] = value
            self.lookup[index] = self.arr[left]
            return
        mid = (left+right) >> 1
        if atIndex > mid:
            self.updateHelper(2*index+2, mid+1, right, atIndex, value)
        else:
            self.updateHelper(2*index+1, left, mid, atIndex, value)
        self.lookup[index] = self.lookup[2*index+1] + self.lookup[2*index+2]
        return
    
'''
        This template of segment trees is for range sum queries.
        
        If you  want to do range minimum queries, soon you can see the template in the segment-tree-range-minimun.py.
        
        Author: @pardhusnc2004

'''