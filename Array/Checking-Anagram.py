def isAnagram(s1,s2):

    s1 = s1.replace(" ", "").lower()
    s2 = s2.replace(" ", "").lower()

    count = {}

    for letter in s1:
        if letter in count:
            count[letter] += 1
        else:
            count[letter] = 1

    for letter in s2:
        if letter in count:
            count[letter] -= 1
        else:
            count[letter] = 1

    for i in count:
        if count[i] != 0:
            return False

    return True


#driver code
str1 = input("Enter first string : ")
str2 = input("Enter second string : ")

print(isAnagram(str1,str2))