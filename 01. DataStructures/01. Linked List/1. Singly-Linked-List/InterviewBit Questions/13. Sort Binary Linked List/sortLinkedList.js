// for some reason this solution is not passing in interview bit you wasted about 2 hours for that problem and you solved it.
// I think there is something wrong with that stupid site.

function sortBinaryList (A) {
    if(!A || !A.next) return A;

    let count0  = 0;
    let count1 = 0;

    let currunt = A;
    while(currunt) {
        if(currunt.data == 0) {
        count0++;
        current.next;
        } else {
            count1++;
            current.next;
        }
    }

    currunt = A;
    let count = 0;
    while(count < count0) {
        currunt.data = 0;
        currunt = currunt.next; 
        count++;
    }
    count = 0;
    while(count < count1) {
        currunt.data = 1;
        currunt = currunt.next;
        count++;
    }

    return A;
}
