# The function to find if the string is a palindrome or not
def is_palindrome(s):
    # Check if string is equal to its reverse.
    s = s.lower()
    return s == s[::-1]

# The driver code
if __name__ == '__main__':
    s = str(raw_input("Ask user for something: "))
    IS_PALINDROME = is_palindrome(s)

    if IS_PALINDROME:
        print("Yes, the input is a palindrome")
    else:
        print("No, the input in not a palindrome")