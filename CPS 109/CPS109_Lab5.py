num = int(input())
keyboard = []
words = []
for j in range(num):
    key = input()
    keyboard.append(key.split(" "))

for i in range(len(keyboard)):
    number = keyboard[i][0]
    number = int(number)
    temp = keyboard[i][1]
    temp = temp[:number-1] + temp[number:]
    words.append(temp)
    print(f"{i+1} {words[i]}")

