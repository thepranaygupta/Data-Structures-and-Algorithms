function removeAdjecent(str) {

    const stack = [];
    let i = 0; 
    const strArr = str.split('');
    while (i < strArr.length) {
        if(stack[stack.length - 1] === strArr[i]) {
            strArr[i] = "";
            stack.pop();
        } else {
            stack.push(strArr[i]);
        }
        i++;
    }

    return stack.join('');
}

const input = "aaaazxxzy";

console.log(removeAdjecent(input));
