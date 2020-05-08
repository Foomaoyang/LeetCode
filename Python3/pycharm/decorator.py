def decorator_foo(func):
    """装饰器基于闭包"""
    def call_func():
        # 闭包：内函数用到外函数的数据
        print("----这是装饰器----")
        print("----这是装饰器----")
        # 调用函数，如果是数据就是闭包
        func()
        # 注意返回的是函数引用不带圆括号，圆括号是返回的返回值
    return call_func

@decorator_foo
def test1():
    print("-----This is test programe.----")


test1()
# -----------------------------------

def decorator_2(func):
    """带参数的装饰器"""
    # add parameter num
    def call_func(num):
        print("----这是装饰器----")
        func(num)
    return call_func

@decorator_2
def test2(num):
    """带参"""
    print("-----This is test programe.----")
    print("-----num = %d----" % num)

test2(100)
test2(200)

# -----------------------------------

def decorator_3(func):
    """带多参数的装饰器"""
    def call_func(*args, **kwargs):
        print("----这是装饰器----")
        func(*args, **kwargs) # 拆包
    return call_func

@decorator_3
def test3(num, *args, **kwargs):
    print("-----test3 = %d----" % num)
    print("-----test3 ----" , args)
    print("-----test3 ----" , kwargs)


test3(100)
test3(100, 200)
test3(100, 200, 300, mm = 999)


# -----------------------------------

def decorator_4(func):
    """带返回值的装饰器"""
    def call_func(*args, **kwargs):
        print("----这是装饰器----")
        return func(*args, **kwargs) # 拆包
    return call_func

@decorator_4
def test4(num, *args, **kwargs):
    print("-----test3 = %d----" % num)
    print("-----test3 ----" , args)
    print("-----test3 ----" , kwargs)
    return "ok"


print(test4(100))

# ------------------------------------

# 多个装饰器应用到一个函数

def add_authority(func):
    def cal_func():
        print("添加权限")
        func()
    return cal_func


def decorator_5(func):
    def call_func():
        print("----这是装饰器----")
        func()
    return call_func

@add_authority
@decorator_5
def test5():
    print("-----test5-----")

test5()

# ------------------------------------
# 使用类做装饰器

class Te(object):
    def __init__(self, func):
        self.func = func

    def __call__(self):
        print("----this is decorator.----")
        return self.func()

@Te
def get_str():
    return 'str'

print(get_str())
