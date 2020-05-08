# -*- coding: utf-8 -*-

# 参考：
# https://www.bilibili.com/video/BV1jT4y1G7e2?p=4

class Array(object):
    """自定义数组ADT"""
    def __init__(self, size = 32):
        self._size = size
        self._items = [None] * size

    def __getitem__(self, index):
        return self._items[index]

    def __setitem__(self, index, value):
        self._items[index] = value

    def __len__(self):
        return self._size

    def clear(self, value = None):
        for i in range(len(self._items)):
            self._items[i] = value

    def __iter__(self):
        """迭代器"""
        for item in self._items:
            yield item


def test_array():
    """测试方法"""
    size = 10
    a = Array(size)
    a[0] = 1 
    assert a.__getitem__(0) == 0
    assert a[0] == 1

    a.clear()
    assert a[0] is None 

# 在命令行中安装pytest:pip install pytest
# 使用断言assert
# pytest array.py













