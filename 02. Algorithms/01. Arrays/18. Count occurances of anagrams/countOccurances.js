/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {

    const sCount = {};
    const pCount = {};

    p.split("").forEach((element, index) => {
        const count = pCount[element];
        count ? pCount[element] = count+ 1 : pCount[element] = 1;
        const count1 = sCount[s[index]];
        count1 ? sCount[s[index]] = count1+1 : sCount[s[index]] = 1;
    });

   let left = 0;
   let right = p.length - 1;

    const res = [];

   while(right < s.length) {
       if(checkAna(sCount, pCount)) {
           res.push(left);
       }
        sCount[s[left]] -= 1;
        left++;
        right++;
        const count = sCount[s[right]];
        count ? sCount[s[right]] = count + 1 : sCount[s[right]] = 1;
   }

   return res;
}

function checkAna(sCount, pCount) {
    
    for(const prop in pCount) {
        if(!sCount[prop] || sCount[prop] !== pCount[prop]) return false;
    }

    return true;
}

















