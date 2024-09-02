# Name: Sharaf Hussain

# --------------------------------------------------------------
# 1) TMU Letter Grade Converter
# --------------------------------------------------------------
def lettergrade(pct):
  if (pct < 0):
    return None
  elif (pct < 50):
    return "F"
  elif (pct < 60):
    return "D"
  elif (pct < 70):
    return "C"
  elif (pct < 80):
    return "B"
  elif (pct < 100):
    return "A"
  return None # replace 'pass' with a return statement.


# --------------------------------------------------------------
# 2) Duplicate Sequence Elements
# --------------------------------------------------------------
def duplicates(items):
  if (len(items) == 3):
    same = 0
    if (items[0] == items[1]):
      same += 1
    if (items[0] == items[2]):
      same += 1
    if (items[1] == items[2]):
      same += 1  
    if (same == 3):
      return "three-of-a-kind"
    elif (same == 1):
      return "two-of-a-kind"
    else:
      return "one-of-a-kind" 
  return "invalid input"  # replace 'pass' with a return statement.
    
    
# -------------------------------------------------------------
# 3) Inversions of Three
# -------------------------------------------------------------
def inversions(items):
  if (len(items) == 3):
    if (items[2] > items [1] > items[0] or items[2] == items [1] == items[0]):
      return 0
    elif (items[0] == items[1] and items[2] > items[1]):
        return 0
    elif (items[1] == items[2] and items[1] > items[0]):
        return 0
    elif (items[0] > items [1] > items[2]):
      return 3 
    elif (items[0] == items[2]):
        return 1
    elif (items[0] < items[1] and items[0] > items[2]):
        return 2
    elif (items[0] > items[1] and items[2] > items[1] and items[0] > items[2]):
        return 2
    elif (items[0] != items[1] != items[2]):
        return 1
    return 2
  return -1 # replace 'pass' with a return statement.    
 
# --------------------------------------------------------------
# 4) Increasing, Strictly or Otherwise?
# --------------------------------------------------------------   
def increasing(items, strict):   
  if (len(items) == 3 and type(strict) == bool):
    if (strict == True):
      if (items[2] > items[1] > items[0]):
        return True
    else: 
      if (items[2] >= items[1] >= items[0]):
        return True
    return False
  return "invalid input" # replace 'pass' with a return statement.
   
# --------------------------------------------------------------
# 5) Python as a Calculator 
# --------------------------------------------------------------      
def calculator(op1, op2, operator):     
  if (operator == "+"):
    return op1 + op2
  elif (operator == "-"):
    return op1 - op2  
  elif (operator == "*"):
    return op1 * op2  
  elif (operator == "/"):
    if (op2 == 0):
      return None
    return op1 / op2  
  elif (operator == "**"):
    return op1 ** op2  
  return None # replace 'pass' with a return statement.


#if __name__ == "__main__":
#    print(inversions([1, 1, 1])) #0
 #   print(inversions([1, 1, 2])) #0
 #   print(inversions([1, 1, 3])) #0
 #   print(inversions([1, 2, 1])) #1
  #  print(inversions([1, 2, 2])) #0
 #   print(inversions([1, 2, 3])) #0
  #  print(inversions([1, 3, 1])) #1
   # print(inversions([1, 3, 2])) #1
   # print(inversions([1, 3, 3])) #0
   # print(inversions([2, 1, 1])) #2
 #   print(inversions([2, 1, 2])) #1
   # print(inversions([2, 1, 3])) #1
  #  print(inversions([2, 2, 1])) #2
  #  print(inversions([2, 2, 2])) #0
  #  print(inversions([2, 2, 3])) #0
  #  print(inversions([2, 3, 1])) #2
  #  print(inversions([2, 3, 2])) #1
  #  print(inversions([2, 3, 3])) #0
  ##  print(inversions([3, 1, 1])) #2
   # print(inversions([3, 1, 2])) #2
   # print(inversions([3, 1, 3])) #1
  #  print(inversions([3, 2, 1])) #3
  #  print(inversions([3, 2, 2])) #2
  #  print(inversions([3, 2, 3])) #1
  #  print(inversions([3, 3, 1])) #2
 #   print(inversions([3, 3, 2])) #2
 #   print(inversions([3, 3, 3])) #0
