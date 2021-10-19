
array = [1,2,3]

def permute(array: list) -> list:
    if len(array) == 1: # base case
        return [array]

    # recursive case

    perms=[]

    for i in range(len(array)):
        first = [array[i]]
        minilists = permute(array[:i]+array[i+1:])

        for p in minilists:
            perms.append(first+p)

    return perms

print(permute(array))