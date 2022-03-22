from audioop import mul


def dec2Bin(n):
    res = ""
    while n:
        rem = n % 2
        res = str(rem) + res
        n = n//2
    return res


def bin2Dec(n):
    res = 0
    multiplier = 1
    while n:
        digit = n % 10
        res += digit * multiplier
        multiplier = multiplier * 2
        n = n//10
    return res


def dec2Oct(n):
    res = ""
    while n:
        rem = n % 8
        res = str(rem) + res
        n = n//8
    return res


def oct2Dec(n):
    res = 0
    multiplier = 1
    while n:
        digit = n % 10
        res = res + digit * multiplier
        multiplier = multiplier * 8
        n = n//10
    return res


decToHexDict = {10: "A", 11: "B", 12: "C", 13: "D", 14: "E", 15: "F"}
hexToDecDict = {"A": 10, "B": 11, "C": 12, "D": 13, "E": 14, "F": 15}


def dec2Hex(n):
    res = ""
    while n:
        rem = n % 16
        if rem >= 10:
            res = decToHexDict[rem] + res
        else:
            res = str(rem) + res
        n = n//16
    return res


def hex2Dec(n):
    res = 0
    multiplier = 1

    for i in n[::-1]:
        if i.isdigit():
            res = res + int(i) * multiplier
        elif i.isalpha():
            res = res + multiplier * hexToDecDict(i)
        multiplier = multiplier * 16
    return res

print(dec2Bin(6))
print(bin2Dec(1000))
print(dec2Oct(8))
print(oct2Dec(10))
print(dec2Hex(242))
print(hex2Dec("70"))
