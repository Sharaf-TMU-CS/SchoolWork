# --------------------------------------------------------------
# 1) Summing Evens
# --------------------------------------------------------------
def sumeven(n):
    total = 0
    for i in range(n):
        total += (i*2)
    return total # replace 'pass' with a return statement.
    
# --------------------------------------------------------------
# 2) Summing Squares
# --------------------------------------------------------------
def sumsquares(n):
    total = 0
    for i in range(1, n+1):
        total += (i*i)
    return total # replace 'pass' with a return statement.

# --------------------------------------------------------------
# 3) Summing Odd Digits
# --------------------------------------------------------------   

def odddigitsum(num):
    num = str(num)
    totalOdd = 0
    for i in range(len(str(num))):
        if (num[i] == "-"):
            continue
        if (int(num[i]) % 2 != 0):
            totalOdd += int(num[i])
    return totalOdd # replace 'pass' with a return statement.    

# --------------------------------------------------------------
# 4) Listing Exponentials
# --------------------------------------------------------------
def listexponential(n, base):
  baseList = []
  for i in range(n):
    baseList.append(base**i)
  return baseList # replace 'pass' with a return statement.
    
# --------------------------------------------------------------
# 5) Concatenating Digits
# --------------------------------------------------------------      
def digitcat(s):
  digits = ""
  for element in s:
    if (element.isnumeric()):
      digits += element
  if (digits == ""):
    return None
  return int(digits) # replace 'pass' with a return statement.

# --------------------------------------------------------------
# 6) Parsing Floats
# --------------------------------------------------------------      
def stringtofloatlist(fltstr):
  inputList = [] 
  tempList = fltstr.split(",")
  for i in range(len(tempList)):
      inputList.append(float(tempList[i]))
  return inputList # replace 'pass' with a return statement.

# --------------------------------------------------------------
# 7) Maximum of Each Type
# --------------------------------------------------------------      
def maxbytype(items):
  largest = [0, 0.0, ""]
  intFound = False
  floatFound = False
  strFound = False
  for element in items:
    if (type(element) == int):
      if(element > largest[0] or not intFound):
        largest[0] = element
        intFound = True
    elif (type(element) == float):
      if(element > largest[1] or not floatFound):
        largest[1] = element
        floatFound = True
    elif (type(element) == str):
      if(element > largest[2] or not strFound):
        largest[2] = element
        strFound = True
  if (largest[0] == 0):
    largest[0] = None
  if (largest[1] == 0.0):
    largest[1] = None
  if (largest[2] == ""):
    largest[2] = None
      
  return tuple(largest) # replace 'pass' with a return statement.



  
#if __name__ == "__main__":
#    print(sumeven(7))
#    print(sumsquares(4))
#    print(odddigitsum(-13579))
#    print(listexponential(6, 2))
#    print(digitcat("I want 3 oranges, 24 bananas, and 101 dalmations"))
#    print(maxbytype([ "hello", 1, 3.14, 99, "cat", "tac", 2.7, "bat" ]))
  