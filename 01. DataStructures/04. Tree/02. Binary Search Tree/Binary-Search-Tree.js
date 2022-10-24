//1. ### Insert a Node(Iterative Approach)
// 2. ### Insert a Node(Recursive Approach)
// 3. ### Insert a Node(Level Order Insertion)
// 4. ### Print 2D
// 5. ### Height of tree
// 6. ### Sum of all Nodes in the Tree
// 7. ### Total Number of Nodes in the Tree
// 8. ### Maximum Value in the Binary Tree
// 9. ### Print Level Order/Breadth First Search (using queue)
// 10. ### Print Level Order/Breadth First Search (using Recursion)
// 11. ### Print Given Level of the Tree
// 12. ### Sum of values at level K
// 13. ### Print Pre-Order Traversal (NODE, LEFT, RIGHT)
// 14. ### Print In-Order Traversal (LEFT, NODE, RIGHT)
// 15. ### Print Post-Order Traversal (LEFT, RIGHT, NODE)
// 16. ### Print all Paths from Root to Leaf Nodes
// 17. ### Search in Binary Search Tree (Iterative Approach)
// 18. ### Search in Binary Search Tree (Recursive Approach)
// 19. ### Diameter of Binary Tree (O(n^2) Approach)
// 20. ### Diameter of Binary Tree (O(n) Approach)
// 21. ### Delete a Node
// 22. ### Construct BT from Pre-Order and In-Order
// 23. ### Construct BT from Post-Order and In-Order
// 24. ### Construct BST from In-Order
// 25. ### Construct BST from Pre-Order
// 26. ### Construct BST from Post-Order
// 27. ### Check if the Binary Tree is Balanced

// queue class

class QNode {
    constructor(val, next) {
        this.val = val;
        this.next = next;
    }
}

class Queue {
    constructor(size) {
        this.front = null;
        this.size = size;
        this.count = 0;
        this.back = null;
    }

    enqueue(data) {
        
        if(this.isFull()) return;
        
        if(this.back) {
            this.back.next = new QNode(data);
            this.back = this.back.next;
        } else {
            this.back = new QNode(data);
            this.front = this.back;
        }
        this.count++;
    }

    dequeue() {
        if(this.front && !this.front.next) {
            const dequeueNode = this.front;
            this.front = this.front.next;
            this.back = this.front;
            this.count--;
            return dequeueNode;
        } else {
            const dequeueNode = this.front;
            this.front = this.front.next;
            this.count--;
            return dequeueNode;
        }
    }
    reverseQueue() {
        const stack = [];
        while(this.front) {
            stack.push(this.front.val);
            this.front = this.front.next;
        }
        // setting everyting to 0 and null;
        this.front = null;
        this.back = null;
        this.count = 0;
        // pushing on to the queue in reverse
        while(stack.length) {
           
            this.enqueue(stack.pop());
        }
    }
    isFull() {
        if(this.count < this.size) {
            return false;  
        } else {
            return true;
        }
    }

    isEmpty() {

        if(this.count <= 0) {
            return true;
        } else {
            return false;
        }
    }

    count1() {
        return this.count;
    }

    peek() {
        return this.front.val;
    }

    print() {
        let currunt = this.front;
        let linkedStr = '';
        while(currunt) {
            linkedStr += currunt.val + "->" ; 
            currunt = currunt.next;
        }
        return linkedStr + 'null';
    }
}





class Node {
    constructor(val, right = null, left = null) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}

class BST {
    constructor() {
        this.root = null;
        this.globleSpaceForPrinting = 5;
        this.maxHeight = Number.MIN_SAFE_INTEGER;
        this.totalSumOfNodes = 0;
        this.totalNumOfNode = 0;
        this.maxValue = Number.MIN_SAFE_INTEGER;
        this.preOrderTraversalArr = [];
        this.postOrderTraversalArr = [];
        this.inOrderTraversalArr = [];
        this.burteDiemeterMaxLenght = 0;
    }

    insertNodeIteretively(data) {
        if(!this.root) {
            this.root = new  Node(data);
        } else {
            let temp = this.root;
            while(temp) {
                if(data <= temp.val) {
                    if(data == temp.val) {
                        return 'duplicates are not allowed';
                    }

                    if(!temp.left) {
                        temp.left = new Node(data);
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if(data >= temp.val) {
                    if(data == temp.val) {
                        return 'duplicates are  not allowed';
                    } 
                    
                    if(!temp.right) {
                        temp.right = new Node(data);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
    }
    // need to pass the root in this function
    insertRecursivly(root, data, RL = null) {
        // i have to do this rl stuff because the null is passed by value and not reference where we need the reference 
        if(RL) {
            if(RL == 'left') {
                root.left = new Node(data);
            } else if(RL == 'right') {
                root.right = new Node(data);
            }
            // root  = new Node(data);            
            return;
        } else {
            // console.log(data, root.val);
            if(data < root.val) {
                // console.log('left');
                if(root.left == null) {
                    console.log('stopping left');
                    this.insertRecursivly(root, data, 'left');
                } else {
                    this.insertRecursivly(root.left, data);
                }

            } else if(data > root.val) {
                // console.log('right');
                if(root.right == null) {
                    console.log('stopping right');
                    this.insertRecursivly(root, data, 'right');
                } else {
                    this.insertRecursivly(root.right, data);
                }
            } else {
                return 'no duplicates are allowed';
            }
        }
    }

    // levelOrderInsertion it will make binary tree and not binary search tree.
    levelOrderInsert(data) {
        const queue = new Queue(Number. MAX_VALUE);
        if(!this.root) {
            this.root = new Node(data);
            return;
        } else {
            const queue = new Queue(Number. MAX_VALUE);

            queue.enqueue(this.root);
            while(true) {
                const currunt = queue.dequeue().val;
                if(!currunt.left) {
                    currunt.left = new Node(data);
                    return;
                }
                if(!currunt.right) {
                    currunt.right = new Node(data);
                    return;
                }
                queue.enqueue(currunt.left);
                queue.enqueue(currunt.right);
            }
        }
    }

    //  just focus on the "space" variable and how it's changing with each recursive call. nothing complicated besides that.
    print2D(root, space) {
       
        if(!root) {
            return;
        }
        space = this.globleSpaceForPrinting + space;
        this.print2D(root.right, space);

        let curruntSpace = '';
        for(let i = this.globleSpaceForPrinting; i < space; i++) {
            curruntSpace += " ";
        }

        console.log(curruntSpace + root.val + '\n');
        this.print2D(root.left, space);
    }
    // 
    printLevelOrder(root) {
        const queue = new Queue(Number.MAX_VALUE);

        if(!root) return null;
        let output = "";
        queue.enqueue(root);
        while(!queue.isEmpty()) {
            const curruntNode = queue.dequeue().val;
            output += curruntNode.val + '->';
            if(curruntNode.left) {
                queue.enqueue(curruntNode.left);
            }
            if(curruntNode.right) {
                queue.enqueue(curruntNode.right);
            }
        }
        return output;
    }
    printLevelOrderRecursivly(root) {

      // calculating height of the tree  
      const height = this.heightOfTree(root, 0);
      let output = '';

    //   calling print1 for each level
      for(let i = 0; i < height + 1; i++) {
          print1(root, i);
      }

      function print1(root, level) {
          if(level == 0) {
              if(root) {
                output += root.val + ' ';
              }
            return;
          } else {
              if(root) {
                print1(root.left, level - 1);
                print1(root.right, level - 1);  
              }
          }
      }

      return output;
    }
    preOrderTraversal(root) {
        if(!root) return;
        this.preOrderTraversalArr.push(root.val);
        this.preOrderTraversal(root.left);
        this.preOrderTraversal(root.right);

        return this.preOrderTraversalArr;
    }
    postOrderTraversal(root) {
        if(!root) return;
        this.postOrderTraversal(root.left);
        this.postOrderTraversal(root.right);
        this.postOrderTraversalArr.push(root.val);

        return this.postOrderTraversalArr;
    }
    inOrderTraversal(root) {
        if(!root) return;
        this.inOrderTraversal(root.left);
        this.inOrderTraversalArr.push(root.val);
        this.inOrderTraversal(root.right);

        return this.inOrderTraversalArr;
    }

    printAllRootToLeaf(root) {
        // start from here.
       
        const allPath = [];
        goRecursive(root, []);
        function goRecursive(root, curruntArr) {
            if(!root) return;
            curruntArr.push(root.val);
            goRecursive(root.left, curruntArr);
            goRecursive(root.right, curruntArr);
            const newArr = curruntArr.slice();
            if(!root.left && !root.right) {
                allPath.push(newArr);
            }
            curruntArr.pop();
        }

        return allPath;
    }
    printSpecificLevel(root, level) {
          
          let output = "";
          print1(root, level - 1);

          function print1(root, level) {
              if(level == 0) {
                  if(root) {
                    output += root.val + ' ';
                  }
                return;
              } else {
                  if(root) {
                    print1(root.left, level - 1);
                    print1(root.right, level - 1);  
                  }
              }
          }
          return output; 
    }


    // its basically an inorder traversal
    heightOfTree(root) {

        let maxHeight = 0;
        return calculate(root, 0);

        function calculate(root, curruntHeight) {
            if(!root) return 0;

            curruntHeight += 1;
            maxHeight = Math.max(maxHeight, curruntHeight);
            calculate(root.left, curruntHeight);
            calculate(root.right, curruntHeight);
    
            return maxHeight - 1;
        }

    }

    // it's basically an inorder traversal
    sumOfAllNodes(root) {
        if(!root) return;

        this.totalSumOfNodes += root.val;
        this.sumOfAllNodes(root.left);
        this.sumOfAllNodes(root.right);

        return this.totalSumOfNodes;
    }   

    // just modifed the printLevelorderRecusivly. 
    sumOfNodesAtEachLevel(root) {
      // calculating height of the tree  
      const height = this.heightOfTree(root, 0);

    //   calling print1 for each level
      const outputArr = [];
      for(let i = 0; i < height + 1; i++) {
          outputArr.push(print1(root, i, 0));
      }

      
      function print1(root, level, curruntSum) {
          if(level == 0) {
              if(root) {
                curruntSum += root.val;
              }
            return curruntSum;
          } else {
              if(root) {
                curruntSum =  print1(root.left, level - 1, curruntSum);
                curruntSum =  print1(root.right, level - 1, curruntSum);  
              }
          }

          return curruntSum;
      }

      return outputArr;
    }

    searchIterativly(root, target) {

        let temp = root;

        while(temp) {
            if(temp.val === target) {
                return temp;
            } else if(target > temp.val) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return false;
    }

    searchRecursively(root, target) {


        let temp = root;
        return goRecursive(temp, target);

        function goRecursive(temp, target) {
            if(!temp) return false;
            if(temp.val === target) return temp;

            let result;
            if(target > temp.val) {
              result  =  goRecursive(temp.right, target);
            } else {
               result = goRecursive(temp.left, target);
            }

            return result;
        }
    }

    diemeterBrute(root) {
        let maxDiemeterLen = 0;
        const that = this;

        return calculate(root);

        function calculate(root) {
        if(!root) return;
        let leftHeight = that.heightOfTree(root.left);
        let rightHeight = that.heightOfTree(root.right);

        maxDiemeterLen = Math.max(leftHeight + rightHeight + 2, maxDiemeterLen);
        calculate(root.left);
        calculate(root.right);
        return maxDiemeterLen; 
       }
    }

    diemeterOptimized(root) {
        // do it later
    }

    deleteNode(root, deleteNode) {
        let found = this.searchIterativly(root, deleteNode);
        if(found) {
            this.swapDfsAndDelete(found);
            return 'deleted';
        } else {
            return `${deleteNode} doesn't exists`;
        }
    }

    swapDfsAndDelete(root) {

        if(!root) return;
        if(!root.left && !root.right) {
            console.log(root, 'this is it');
            // for some weird reason it's not working, but when you do root.val == 'delete' it is referenceing the  desired node. don't know why it's not working
            root = null;
            console.log(this.root);
           
            return true;
        }        
        this.swap(root, root.left);
        if(this.swapDfsAndDelete(root.left)) {
            return;
        }  

        this.swap(root, root.right);
        if(this.swapDfsAndDelete(root.right)) {
            return;
        }
    }

    swap(a,b) {
        if(b) {
            console.log('this runs');
            const temp = a.val;
            a.val = b.val;
            b.val = temp;    
        } 
    }
    totalNodes(root) {
        if(!root) return;

        this.totalNumOfNode += 1;
        this.totalNodes(root.left);
        this.totalNodes(root.right);
        
        return this.totalNumOfNode;
    }
    // just need to remember all the variables passed in goRecursive function.
    InPreTreeConstruction(inO, preO) {

        return goRecursive(inO, 0, inO.length - 1, preO, 0, preO.length - 1);

        function goRecursive(inO, isi, iei, preO, psi, pei) {
            console.log(isi, iei, psi, pei);
            if(isi > iei) return null;

            const node = new Node(preO[psi]);
            // console.log(node);
            let curruntIndex = isi;
            while(inO[curruntIndex] !== preO[psi]) {
                curruntIndex++;
            }

            const totalElementUntillRoot = curruntIndex -  isi;
            // just keep track of these parameters and you'll know it.
            node.left = goRecursive(inO, isi, curruntIndex - 1, preO, psi + 1, totalElementUntillRoot + psi);
            node.right = goRecursive(inO, curruntIndex + 1, iei, preO, psi + 1 + totalElementUntillRoot, pei);
            return node;
        }
    }
    

    InPostTreeConstruction(postO, InO) {
        // start writing the code here.
        // console.log(postO, InO);
        return goRecursive(postO, 0, postO.length - 1, InO, 0, InO.length - 1);

        function goRecursive(postO, psi, pei, InO, isi, iei) {
            if(isi > iei) return null;

            const node = new Node(postO[pei]);

            let curruntIndex = isi;
            while(InO[curruntIndex] !== postO[pei]) {
                curruntIndex++;
            }
            const numberOfel = curruntIndex - isi;

            // console.log(curruntIndex);
            node.left = goRecursive(postO, psi, psi + numberOfel - 1, InO, isi, curruntIndex - 1);
            node.right = goRecursive(postO, numberOfel + psi, pei - 1, InO, curruntIndex + 1, iei);

            return node;
        }
    }

    // constructing BST from inorder array. just notice inorder array is sorted.
    inOrderBSTConstruction(InO) {

        return goRecursive(InO, 0, InO.length - 1);
        
        function goRecursive(InO, psi, pei) {
            if(psi > pei) return null;

            const midPoint = Math.ceil((psi + pei) / 2);
            const node = new Node(InO[midPoint]);

            node.left = goRecursive(InO, psi, midPoint - 1);
            node.right = goRecursive(InO, midPoint + 1, pei);

            return node;
        }
    }

    postOrderBSTConstruction(PostO) {
        let lr = Math.MIN_SAFE_INTEGER;
        let rr = Math.MAX_SAFE_INTEGER;

        PostO.reverse();
        let i = 0;

        return goRecursive(PostO, lr, rr)
        function goRecursive(PostO, lr, rr) {

        if(i >= PostO.length || PostO[i] > rr || PostO[i] < lr) return null;

        const node = new Node(PostO[i]);
        i++;
        node.right = goRecursive(PostO, node.val, rr);
        node.left = goRecursive(PostO, lr, node.val);
        
        return node;
        }
    }
    preOrderBSTConstruction(preO) {
    let lr = Math.MIN_SAFE_INTEGER;
    let rr = Math.MAX_SAFE_INTEGER;
    let i = 0;
    return goRecursive(preO, lr, rr);

    function goRecursive(preO, lr, rr) {

        // all the crux of this algorithem is in this blow condition
        if(i >= preO.length || preO[i] > rr || preO[i] < lr) return null;

        const node = new Node(preO[i]);
        i++;
        node.left = goRecursive(preO, lr, node.val);
        node.right = goRecursive(preO, node.val, rr);
        console.log(node);
        return node;
    }
    }

    isBalanced(root) {
        
        let balanced = true;
        goRecursive(root);
        function goRecursive(root) {
            if(!root) return -1;

            const left = goRecursive(root.left);
            const right = goRecursive(root.right);
            
            if(Math.abs(left - right) > 1) {
                balanced = false;
            }

            return Math.max(left, right) + 1;
        }

        return balanced;
    }
    maxValueInTree(root) {
        if(!root) return;
        this.maxValue = Math.max(this.maxValue, root.val);
        this.maxValueInTree(root.left);
        this.maxValueInTree(root.right);
        return this.maxValue;
    }

    printNormal() {
        console.log(this.root);
    }
}

const myBinary = new BST();

// create tree A
// myBinary.insertNodeIteretively(10);
// myBinary.insertNodeIteretively(2);
// myBinary.insertNodeIteretively(14);
// myBinary.insertNodeIteretively(1);
// myBinary.insertNodeIteretively(7);
// myBinary.insertNodeIteretively(40);
// myBinary.insertNodeIteretively(3);
// myBinary.insertNodeIteretively(4);

// create tree B
// myBinary.insertNodeIteretively(10);
// myBinary.insertNodeIteretively(2);
// myBinary.insertNodeIteretively(24);
// myBinary.insertNodeIteretively(9);
// myBinary.insertNodeIteretively(23);
// myBinary.insertNodeIteretively(32);
// myBinary.insertNodeIteretively(144);
// myBinary.insertNodeIteretively(25);
// myBinary.insertNodeIteretively(40);
// myBinary.insertNodeIteretively(55);
// myBinary.insertNodeIteretively(44);
// myBinary.insertNodeIteretively(96);
// myBinary.insertNodeIteretively(49);
// myBinary.insertNodeIteretively(69);
// myBinary.insertNodeIteretively(70);
// myBinary.insertNodeIteretively(77);

//tree C
// myBinary.levelOrderInsert(0);
// myBinary.levelOrderInsert(1);
// myBinary.levelOrderInsert(2);
// myBinary.levelOrderInsert(3);
// myBinary.levelOrderInsert(4);
// myBinary.levelOrderInsert(5);
// myBinary.levelOrderInsert(6);
// myBinary.levelOrderInsert(7);
// myBinary.levelOrderInsert(8);
// myBinary.levelOrderInsert(9);
// myBinary.levelOrderInsert(10);
// myBinary.levelOrderInsert(11);

myBinary.insertNodeIteretively(3);
myBinary.insertNodeIteretively(1);
myBinary.insertNodeIteretively(2);
myBinary.insertNodeIteretively(4);

const inOrder = myBinary.inOrderTraversal(myBinary.root);
// console.log(inOrder);
const preOrder = myBinary.preOrderTraversal(myBinary.root);
// console.log(preOrder);
const postOrder = myBinary.postOrderTraversal(myBinary.root);
// console.log(postOrder);

// const newRoot = myBinary.postOrderBSTConstruction(postOrder);
// console.log(newRoot);
myBinary.print2D(myBinary.root, 0);
// console.log(myBinary.deleteNode(myBinary.root, 2));

console.log(myBinary.heightOfTree(myBinary.root.left));
