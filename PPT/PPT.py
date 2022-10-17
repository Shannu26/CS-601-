def naiveIterativeLogic(x, y):

    finalProduct = 0
    shift = 1
    yCopy = y
    while x != 0:
        tempProduct = 0
        multiplier = 1
        carry = 0
        y = yCopy
        xLast = x % 10
        x = x // 10

        while y != 0:
            yLast = y % 10
            product = xLast * yLast
            product += carry
            carry = product // 10
            product = product % 10
            tempProduct += product * multiplier 
            multiplier *= 10
            y = y // 10

        tempProduct += carry * multiplier
        finalProduct += tempProduct * shift
        shift *= 10

    return finalProduct



from math import ceil, floor
#math.ceil(x) Return the ceiling of x as a float, the smallest integer value greater than or equal to x.
#math.floor(x) Return the floor of x as a float, the largest integer value less than or equal to x.

def naiveRecursiveLogic(x,y):
    #base case
    if x < 10 and y < 10: # in other words, if x and y are single digits
        return x*y

    n = max(len(str(x)), len(str(y)))
    m = ceil(n/2)   #Cast n into a float because n might lie outside the representable range of integers.

    x_H  = floor(x / 10**m)
    x_L = x % (10**m)

    y_H = floor(y / 10**m)
    y_L = y % (10**m)

    #recursive steps
    a = naiveRecursiveLogic(x_H,y_H)
    b = naiveRecursiveLogic(x_H,y_L)
    c = naiveRecursiveLogic(x_L,y_H)
    d = naiveRecursiveLogic(x_L,y_L)

    return int(a*(10**(m*2)) + (b + c) *(10**m) + d)

from math import ceil, floor
#math.ceil(x) Return the ceiling of x as a float, the smallest integer value greater than or equal to x.
#math.floor(x) Return the floor of x as a float, the largest integer value less than or equal to x.

def karatsuba(x,y):
    #base case
    if x < 10 and y < 10: # in other words, if x and y are single digits
        return x*y

    n = max(len(str(x)), len(str(y)))
    m = ceil(n/2)   #Cast n into a float because n might lie outside the representable range of integers.

    x_H  = floor(x / 10**m)
    x_L = x % (10**m)

    y_H = floor(y / 10**m)
    y_L = y % (10**m)

    #recursive steps
    a = karatsuba(x_H,y_H)
    d = karatsuba(x_L,y_L)
    e = karatsuba(x_H + x_L, y_H + y_L) - a - d

    return int(a*(10**(m*2)) + e*(10**m) + d)

x = int(input())
y = int(input())
print(naiveIterativeLogic(x, y))
print(naiveRecursiveLogic(x, y))
print(karatsuba(x, y))


