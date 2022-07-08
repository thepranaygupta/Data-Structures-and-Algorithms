class Node{

    constructor(val) {
        this.val = val
        this.next = Array(26).fill(null);
        this.count = 0;
        this.isEnd = false;
    }
}

class Trie{
    constructor() {
        this.root = new Node();
    }
    add(word) {
        let curruntNode = this.root;
        [...word].forEach((char) => {
            if(!curruntNode.next[char.charCodeAt(0) - 97]) {
                curruntNode.next[char.charCodeAt(0) - 97] = new Node(char);
            }
            curruntNode.next[char.charCodeAt(0) - 97].count++;
            curruntNode = curruntNode.next[char.charCodeAt(0) - 97];
        });
        curruntNode.isEnd = true;
    }
    NumberOfWordsStartsWith(prefix) {
        let curruntNode = this.root;
        [...prefix].forEach((char) => {
            curruntNode = curruntNode.next[char.charCodeAt(0) - 97];
        });

        return curruntNode.count;
    }
    search(word) {
        let curruntNode = this.root;

        for(let i = 0; i < word.length; i++) {
            if(curruntNode.next[word[i].charCodeAt(0) - 97]) {
                curruntNode = curruntNode.next[word[i].charCodeAt(0) - 97];
            } else {
                return false;
            }
        }
        if(curruntNode.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    delete(word) {
     
     let curruntNode = this.root;
     if(this.search(word)){
        [...word].forEach((char) => {
            curruntNode = curruntNode.next[char.charCodeAt(0) - 97];
        });
        curruntNode.isEnd = false;
     } else {
         return 'not found';
     }
    }

}

const myTrie = new Trie();
myTrie.add('aadil');
myTrie.add('aacil');
myTrie.add('aac');
// myTrie.delete('aacil');
// console.log(myTrie.search('aacil'));
console.log(myTrie.NumberOfWordsStartsWith('aad'));
