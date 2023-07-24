//Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.
// basically you need to find that number in base 9.
// watch this video if you want more understanding.  https://www.youtube.com/watch?v=4Vmls2RwX6Q&ab_channel=HelpingTutorials

// Time O(log(n)) | Space O(1)
const findNth = (N) => {
    let remainder = [];
    while(N) {
        remainder.push(N%9);
        N = Math.floor(N/9);
    }
    return +remainder.reverse().join('');
}
  
  // Example usage:
  const N1 = 66;
  const result1 = findNth(N1);
  console.log(result1); // Output: 8
  
  
