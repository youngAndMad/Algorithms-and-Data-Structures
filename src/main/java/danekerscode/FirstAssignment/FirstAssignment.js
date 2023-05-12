let squareSum = n => n === 1 ? 1 : n * n + squareSum(n - 1);
// console.log(squareSum(4));
let arr = [1, 2, 3, 4, 5, 6, 7, 8];
let sumOfFirstNElementsInArray = (arr, n) => n === 0 ? 0 : sumOfFirstNElementsInArray(arr, n - 1) + arr[n - 1];
// console.log(sumOfFirstNElementsInArray(arr, 3));
let sumOfTheFirstNPositiveIntegers = n => n === 0 ? 0 : n + sumOfTheFirstNPositiveIntegers(n - 1);
// console.log(sumOfTheFirstNPositiveIntegers(5));
let sumOfTheFirstNPowers = (n, m) => m === 0 ? 1 : Math.pow(n, m) + sumOfTheFirstNPowers(n, m - 1);
// console.log(sumOfTheFirstNPowers(4, 3));
let arr1 = [1, 2, 3, 4, 5];
let reversePrintArray = (arr, n) => {
    if (n === -1) return;
    console.log(arr[n]);
    reversePrintArray(arr, n - 1);
}
reversePrintArray(arr1, arr1.length - 1);

let gen = (n, k, arr) => {

    if (arr.length === n) {
        console.log(arr.join(' '));
        return;
    }

    for (let i = 1; i <= k; i++) {
        arr.push(i);
        gen(n, k, arr);
        arr.pop();
    }

}

gen(3, 3, []);

let stringPermutations =
        str => str.length === 2 ? [str, str[1] + str[0]] : str.length === 1 ?
    str :
    str.split('').reduce((acc, letter, i) =>
        acc.concat(stringPermutations(str.slice(0, i)
            + str.slice(i + 1))
            .map(val => letter + val)), []);

 console.log(stringPermutations("iox"));

 let isPowerOfTwo = n => Math.log2(n) % 1 === 0;
let print = (n, m) => {
    if (n === m + 1) return;
    console.log(`${n} is ${isPowerOfTwo(n) ? '' : "not"} power of two `);
    print(n + 1, m);
}
//print(0, 32);
let counter = 1;
function spiralMatrix(n, row, col, rowEnd, colEnd, arr) {
    if (row === rowEnd || col === colEnd) {
        arr[row][col] = n * n;
        return arr;
    }
    for (let i = col; i <= colEnd; i++)
        arr[row][i] = counter++;
    row++;
    for (let i = row; i <= rowEnd; i++)
        arr[i][colEnd] = counter++;
    colEnd--;
    for (let i = colEnd; i >= col; i--)
        arr[rowEnd][i] = counter++;
    rowEnd--;
    for (let i = rowEnd; i >= row; i--)
        arr[i][col] = counter++;
    col++;
    return spiralMatrix(n, row, col, rowEnd, colEnd, arr);
}
let n = 5;
//console.log(spiralMatrix(n, 0, 0, n - 1, n - 1, Array.from({ length: n }, () => [])));