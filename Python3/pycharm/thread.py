# -*- coding:utf-8 -*-
# 线程

import threading
import time
import logging

# def saysomething():
#     print("this is a test string.")
#     time.sleep(2)
#     print("it's over.")


# def saynothing():
#     print("he said nothing.")
#     time.sleep(1)


# if __name__=="__main__":
#     print('---Start-----:%s' % time.ctime())
#     for i in range(2):
#         t = threading.Thread(target=saysomething)
#         t1 = threading.Thread(target=saynothing)
#         t.start()
#         t1.start()

# ---------------------------------------------

# def test1():
#     for i in range(5):
#         print("----test1----%d----" % i)
#         time.sleep(1)


# def test2():
#     for i in range(5):
#         print("----test2----%d----" % i)
#         time.sleep(2)


# if __name__ == "__main__":
#     t1 = threading.Thread(target=test1)
#     t2 = threading.Thread(target=test2)

#     t1.start()
#     t2.start()

#     while True:
#         print(threading.enumerate())
#         time.sleep(1)


# ---------------------------------------------

class MyThread(threading.Thread):
    def run(self):
        for i in range(3):
            time.sleep(1)
            # name属性保存的是当前线程的名字
            msg = "I'm " + self.name + '@' + str(i)
            print(msg)


if __name__ == '__main__':
    t = MyThread()
    t.start()






