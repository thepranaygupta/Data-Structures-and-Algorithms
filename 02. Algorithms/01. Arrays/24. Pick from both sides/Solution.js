const pickFromBothSide = (A, B) => {
        let minB = 0;
        
        const getTotal = (s,e) =>  {
            let total = 0;
            for(let i = s; i < s + e;  i++) {
                total += A[i];
            }
            return total;
        }
        
        for(let  i = 0; i < A.length; i++) {
            if(i + A.length - B < A.length) {
                minB = Math.min(getTotal(i, A.length - B), minB);
            }
        }
        
        return A.reduce((acc, curr) => {
           return acc + curr; 
        },0) - minB;
}
