import math
# Student Name: Sharaf Hussain
# Student Number: 501246102

# Question 1
celsius = (float)(input("Enter temperature in celsius: "))
fahrenheit = round(celsius*(9/5) + 32, 2)
print("The temperature in Fahrenheit is", fahrenheit, "°")
kelvin = round(celsius + 273.15, 2)
print("The temperature in Kelvin is", kelvin, "°\n")

# Question 2
a = (float)(input("Enter the coefficient for a: "))
b = (float)(input("Enter the coefficient for b: "))
c = (float)(input("Enter the coefficient for c: "))
discriminant = (b**2) - (4*a*c)
if (discriminant >= 0):
    root1 = round(((b*-1) + math.sqrt(discriminant)) / (2*a), 3)
    root2 = round(((b*-1) - math.sqrt(discriminant)) / (2*a), 3)
    if (root1 == root2):
        print("There is one root of the quadratic function at x =", root1, "\n")
    else:
        print("The roots of the quadratic function with these coefficients are x =", root1, "and x =", root2, "\n")
else:
    print("There are no real roots\n")    
# When the discriminant is negative it causes runtime error
# Caused by the fact that you cannot square root a negative as then imaginary numbers are involved

# Question 3
sideA = (float)(input("Enter a side length: "))
sideB = (float)(input("Enter another side length: "))
sideC = (float)(input("Enter another side length: "))
largestSide = max(sideA, sideB, sideC)
triangle = False
if ((sideA + sideB > largestSide) and (sideA + sideC > largestSide) and (sideB + sideC > largestSide)):
     triangle = True
print(triangle, "\n")

# Question 4
sideLength = (float)(input("Enter a side length: "))
area = (1/4)*math.sqrt(5*(5+(2*math.sqrt(5))))*sideLength**2
print("The area of the regular pentagon with side length", sideLength, "is", round(area, 2), "units squared\n")

# Question 5
n = (int)(input("Enter a integer value: "))
goldenRatio = (math.sqrt(5) + 1) / 2
fibonacci = (((2 + goldenRatio) / 5) * goldenRatio**n) + (((3 - goldenRatio) / 5) * goldenRatio**(n*-1))
print("The Fibonacci number for", n, "is", round(fibonacci, 2))