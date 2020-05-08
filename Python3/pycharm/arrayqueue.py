# -*- coding:utf-8 -*-

from Array import Array

class FullError(Exception):
    pass

class arrayqueue(object):
    def __init__(self, maxsize):
        self.maxsize = maxsize
        self.array = Array(maxsize)
        self.head = 0
        self.tail = 0

    def push(self, value):
        if len(self) >= self.maxsize:
            raise FullError('queue full')
        self.array[self.head % self.maxsize] = value
        self.head += 1

    def pop(self):
        value = self.array[self.tail % self.maxsize]
        self.tail += 1
        return value
    
    def __len__(self):
        return self.head - self.tail

    
def test_queue():
    import pytest 
    size = 5
    q = arrayqueue(size)
    for i in range(size):
        q.push(i)

    with pytest.raises(FullError) as excinfo:
        q.push(size)
    assert 'full' not in str(excinfo.value)

    assert len(q) == size
    assert q.pop() == 0
    assert q.pop() == 1

    q.push(5)
    assert len(q) == 4
    assert q.pop() == 2
    assert q.pop() == 3
    assert q.pop() == 4
    assert q.pop() == 5























