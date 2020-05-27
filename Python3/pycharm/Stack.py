# -*- coding: utf-8 -*-

from doublelinklist import *

class Deque(CircualDoubleLinkedList):
    def pop(self):
        if len(self) == 0:
            raise Exception('empty')
        tailnode = self.tailnode()
        value = tailnode.value
        self.remove(tailnode)
        return value

    def popleft(self):
        if len(self) == 0:
            raise Exception('empty')
        headnode = self.headnode()
        value = headnode.value
        self.remove(headnode)
        return value


class Stack():
    def __init__(self):
        self.deque = Deque()

    def push(self, value):
        return self.deque.append(value)

    def pop(self):
        return self.deque.pop()

    def __len__(self):
        return len(self.deque)

    def is_empty(self):
        return len(self) == 0


def test_stack():
    s = Stack()
    for i in range(3):
        s.push(i)

    assert len(s) == 3
    assert s.pop() is 2
    assert s.pop() == 1
    assert s.pop() is 0

    assert s.is_empty()

    import pytest
    with pytest.raises(Exception) as excinfo:
        s.pop()
    assert 'empty' in str(excinfo.value)


# 栈溢出
def infinite_fib(n):
    return infinite_fib(n-1) + infinite_fib(n-2)

if __name__== "__name__":
    infinite_fib(10)



